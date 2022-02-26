package uz.elmurodov.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.mapper.project.ProjectMapper;
import uz.elmurodov.spring_boot.reposiroty.project.ProjectRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectValidator;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class ProjectServiceImpl extends AbstractService<
        ProjectRepository,
        ProjectMapper,
        ProjectValidator> implements ProjectService {

    private final AuditAwareImpl auditAware;
    private final ProjectColumnService projectColumnService;

    @Autowired
    protected ProjectServiceImpl(
            ProjectRepository repository,
            ProjectMapper mapper,
            ProjectValidator validator,
            BaseUtils baseUtils,
            AuditAwareImpl auditAware,
            ProjectColumnService projectColumnService) {
        super(repository, mapper, validator, baseUtils);
        this.auditAware = auditAware;
        this.projectColumnService = projectColumnService;
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
        if (!auditAware.getCredentials().getRole().getCode().equals("ADMIN")) throw new RuntimeException("403");
        Project project = mapper.fromCreateDto(createDto);
        project.setOrganization(auditAware.getCredentials().getOrganizationId());
        project.setCreatedBy(auditAware.getCurrentAuditor().get());
        repository.save(project);
        return project.getId();
    }


    @Override
    public Void delete(Long id) {
        if (!auditAware.getCredentials().getRole().getCode().equals("ADMIN")) throw new RuntimeException("403");
        repository.deleteSoft(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        if (!auditAware.getCredentials().getRole().getCode().equals("ADMIN")) throw new RuntimeException("403");
        repository.update(updateDto);
        return null;
    }

    @Override
    public List<ProjectDto> getAll(Long id) {
//        projectColumnService.getAll();

        return mapper.toDto(repository.getAll());
    }

    @Override
    public List<ProjectDto> getAll(Long id) {
        return null;
    }

    @Override
    public ProjectDto get(Long id) {
        return mapper.toDto(repository.getProject(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


}