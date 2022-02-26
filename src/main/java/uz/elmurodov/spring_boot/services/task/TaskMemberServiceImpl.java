package uz.elmurodov.spring_boot.services.task;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.task.TaskCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.dto.task.TaskUpdateDto;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.mapper.task.TaskMemberMapper;
import uz.elmurodov.spring_boot.reposiroty.task.TaskMemberRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.Validator;
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

    protected TaskMemberServiceImpl(
            TaskMemberRepository repository,
            TaskMemberMapper mapper,
            TaskMemberValidator validator,
            BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }


    @Override
    public Long create(TaskCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(TaskUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<TaskDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public List<TaskDto> getAll(Long id) {
        return null;
    }

    @Override
    public TaskDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
