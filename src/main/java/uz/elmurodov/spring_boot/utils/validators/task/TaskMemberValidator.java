package uz.elmurodov.spring_boot.utils.validators.task;

import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.task.TaskMemberCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberUpdateDto;
import uz.elmurodov.spring_boot.exceptions.ValidationException;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.AbstractValidator;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
public class TaskMemberValidator extends AbstractValidator<TaskMemberCreateDto, TaskMemberUpdateDto,Long> {

    protected TaskMemberValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(TaskMemberCreateDto taskMemberCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(TaskMemberUpdateDto cd) throws ValidationException {

    }
}
