package uz.elmurodov.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.*;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.mapper.project.ProjectMapper;
import uz.elmurodov.spring_boot.reposiroty.project.ProjectRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.services.file.FileStorageService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectValidator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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
    private final FileStorageService fileStorageService;
    private final ProjectMemberService projectMemberService;


    @Autowired
    protected ProjectServiceImpl(
            ProjectRepository repository,
            ProjectMapper mapper,
            ProjectValidator validator,
            ProjectMemberService projectMemberService,
            BaseUtils baseUtils,
            AuditAwareImpl auditAware,
            ProjectColumnService projectColumnService,
            FileStorageService fileStorageService) {
        super(repository, mapper, validator, baseUtils);
        this.auditAware = auditAware;
        this.projectColumnService = projectColumnService;
        this.projectMemberService = projectMemberService;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
        if (!auditAware.getCredentials().getRole().getCode().equals("ADMIN")) throw new RuntimeException("403");
        MultipartFile file = createDto.getTz();
        String tzPath = fileStorageService.store(file);
        Project project = mapper.fromCreateDto(createDto);
        project.setTzPath(tzPath);
        project.setOrganization(auditAware.getCredentials().getOrganizationId());
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
//
//    @Override
//    public List<ProjectDto> getAll(Long organizationId) {
//        List<ProjectDto> dtos = mapper.toDto(repository.getAll());
//        for (ProjectDto dto : dtos) {
//            List<ProjectColumnDto> columns = projectColumnService.getAll(dto.getId());
//            dto.setColumns(columns);
//            List<ProjectMemberDto> members = projectMemberService.getAll(dto.getId());
//            dto.setMembers(members);
//        }
//        dtos.forEach(dto->{
//            List<ProjectColumnDto> columns = projectColumnService.getAll(dto.getId());
//            List<ProjectMemberDto> members = projectMemberService.getAll(dto.getId());
//            dto.setColumns(columns);
//            dto.setMembers(members);
//        });
//        return dtos;


    @Override
    public List<ProjectDto> getAll(Long id) {
        List<Project> projects = repository.findAll(Sort.by("id"));
        //   List<Project> projects = repository.getAll(id);
        List<ProjectDto> projectsList = new ArrayList<>();
        projects.sort(Comparator.comparing(project -> project.getOrganization().getId().equals(id)));
        for (Project project : projects) {
            if (Objects.equals(project.getOrganization().getId(), id) && !project.isDeleted()) {
                ProjectDto projectDto = mapper.toDto(project);
                projectDto.setFinishDate(project.getFinishDate());
                projectsList.add(projectDto);
            }
        }
        return projectsList;
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.getProject(id);
        ProjectDto projectDto = mapper.toDto(project);
         projectDto.setOrganizationId(project.getOrganization().getId());
         return projectDto;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


}