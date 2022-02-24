package uz.elmurodov.spring_boot.services.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.mapper.organization.OrganizationMapper;
import uz.elmurodov.spring_boot.reposiroty.organization.OrganizationRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.services.file.FileStorageService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.organization.OrganizationValidator;

import java.util.List;

@Service
public class OrganizationServiceImpl extends
        AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {

    private final FileStorageService fileStorageService;

    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository,
                                      @Qualifier("organizationMapper")
                                              OrganizationMapper mapper,
                                      OrganizationValidator validator,
                                      BaseUtils baseUtils,
                                      FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(OrganizationCreateDto createDto) {
        MultipartFile file = createDto.getLogo();
        String logoPath = fileStorageService.store(file);
        Organization organization = mapper.fromCreateDto(createDto);
        organization.setLogo(logoPath);
        repository.save(organization);
        return organization.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto updateDto) {
        Organization organization = mapper.fromUpdateDto(updateDto);
        repository.save(organization);
        return null;
    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not Found");
        });
        OrganizationDto dto = mapper.toDto(organization);
        return dto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
