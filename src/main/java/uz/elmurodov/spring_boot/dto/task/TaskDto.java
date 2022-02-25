package uz.elmurodov.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

import java.time.LocalDateTime;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class TaskDto extends GenericDto {

    private String name;
    private String description;
    private String level;
    private String priority;
    private LocalDateTime deadline;
    private Long projectId;
    private Long columnId;

}
