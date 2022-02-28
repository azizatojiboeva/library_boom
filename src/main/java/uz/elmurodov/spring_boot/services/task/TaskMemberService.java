package uz.elmurodov.spring_boot.services.task;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.task.TaskMemberCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;

/**
 * @Author Aziza Tojiboyeva
 */
public interface TaskMemberService extends GenericCrudService<
        TaskMemberDto,
        TaskMemberCreateDto,
        TaskMemberUpdateDto,
        GenericCriteria,
        Long
        > {
}
