package uz.elmurodov.spring_boot.services.task;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.task.TaskCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.dto.task.TaskUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;

/**
 * @Author Aziza Tojiboyeva
 */
public interface TaskService extends GenericCrudService<
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        GenericCriteria,
        Long
        > {

}
