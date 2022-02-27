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

public class TaskMemberUpdateDto extends GenericDto {
    @Builder(builderMethodName = "childBuilder")
    public TaskMemberUpdateDto(Long id) {

        super(id);
    }
}
