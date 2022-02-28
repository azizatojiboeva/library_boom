package uz.elmurodov.spring_boot.services.task;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.task.TaskMemberCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberUpdateDto;
import uz.elmurodov.spring_boot.entity.task.TaskMember;
import uz.elmurodov.spring_boot.mapper.task.TaskMemberMapper;
import uz.elmurodov.spring_boot.reposiroty.task.TaskMemberRepository;
import uz.elmurodov.spring_boot.services.auth.AuthUserServiceImpl;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.task.TaskMemberValidator;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class TaskMemberServiceImpl extends AbstractService<
        TaskMemberRepository,
        TaskMemberMapper,
        TaskMemberValidator
        > implements TaskMemberService{
    private final AuthUserServiceImpl authUserService;

    protected TaskMemberServiceImpl(
            TaskMemberRepository repository,
            TaskMemberMapper mapper,
            TaskMemberValidator validator,
            BaseUtils baseUtils, AuthUserServiceImpl authUserService) {
        super(repository, mapper, validator, baseUtils);
        this.authUserService = authUserService;
    }


    @Override
    public Long create(TaskMemberCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(TaskMemberUpdateDto updateDto) {
        return null;
    }



    @Override
    public List<TaskMemberDto> getAll(Long id) {
        List<TaskMember> taskMembers = repository.getAllByTaskId(id);
        return mapper.toDto(taskMembers);
    }

    @Override
    public TaskMemberDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
