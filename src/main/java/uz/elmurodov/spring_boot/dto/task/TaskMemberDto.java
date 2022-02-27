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
    @Builder(builderMethodName = "childBuilder")
    public TaskMemberDto(Long id) {
        super(id);
    }
}
