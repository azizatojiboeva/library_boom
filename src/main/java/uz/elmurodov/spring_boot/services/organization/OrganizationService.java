package uz.elmurodov.spring_boot.services.organization;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.mapper.OrganizationMapper;
import uz.elmurodov.spring_boot.reposiroty.OrganizationRepository;
import uz.elmurodov.spring_boot.services.BaseService;

import java.util.List;

@Service
public class OrganizationService implements BaseService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper mapper;

    public OrganizationService(OrganizationRepository organizationRepository, OrganizationMapper mapper) {
        this.organizationRepository = organizationRepository;
        this.mapper = mapper;
    }

    public void create(OrganizationCreateDto dto) {
        Organization organization = mapper.fromCreateDto(dto);
        organizationRepository.save(organization);
    }

    public List<OrganizationDto> getAll() {
        List<Organization> organizations = organizationRepository.findAll();
        return mapper.toDto(organizations);
    }
}
