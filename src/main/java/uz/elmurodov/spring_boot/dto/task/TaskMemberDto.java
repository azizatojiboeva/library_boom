package uz.elmurodov.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter

public class TaskMemberDto extends GenericDto {
    private Long task_id;
    private Long user_id;


    @Builder(builderMethodName = "childBuilder")
    public TaskMemberDto(Long id, Long task_id, Long user_id) {
        super(id);
        this.task_id=task_id;
        this.user_id=user_id;
    }
}
