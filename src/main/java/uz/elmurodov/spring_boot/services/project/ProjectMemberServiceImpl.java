package uz.elmurodov.spring_boot.services.project;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberUpdateDto;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.entity.project.ProjectMember;
import uz.elmurodov.spring_boot.mapper.project.ProjectMemberMapper;
import uz.elmurodov.spring_boot.reposiroty.project.ProjectMemberRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectMemberValidator;

import java.util.List;

public class ProjectMemberServiceImpl extends AbstractService<
        ProjectMemberRepository,
        ProjectMemberMapper,
        ProjectMemberValidator
        > implements ProjectMemberService {
    private final AuditAwareImpl auditAware;

    protected ProjectMemberServiceImpl(ProjectMemberRepository repository,
                                       ProjectMemberMapper mapper,
                                       ProjectMemberValidator validator,
                                       BaseUtils baseUtils, AuditAwareImpl auditAware) {
        super(repository, mapper, validator, baseUtils);
        this.auditAware = auditAware;
    }

    @Override
    public Long create(ProjectMemberCreateDto createDto) {
//        if (!auditAware.getCredentials().getOrganizationId().getId().equals(createDt)) throw new RuntimeException("403");
        if (!auditAware.getCredentials().getRole().getCode().equals("ADMIN")) throw new RuntimeException("403");
        ProjectMember projectMember = mapper.fromCreateDto(createDto);
        ProjectMember save = repository.save(projectMember);
        return save.getId();
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(ProjectMemberUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<ProjectMemberDto> getAll(Long id) {
        return null;
    }

    @Override
    public ProjectMemberDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
