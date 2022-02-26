package uz.elmurodov.spring_boot.services.task;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.task.TaskCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.dto.task.TaskUpdateDto;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.mapper.task.TaskMapper;
import uz.elmurodov.spring_boot.reposiroty.task.TaskRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.task.TaskValidator;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class TaskServiceImpl extends AbstractService<
        TaskRepository,
        TaskMapper,
        TaskValidator
        >
        implements TaskService {


    protected TaskServiceImpl(TaskRepository repository, TaskMapper mapper, TaskValidator validator, BaseUtils baseUtils) {
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
