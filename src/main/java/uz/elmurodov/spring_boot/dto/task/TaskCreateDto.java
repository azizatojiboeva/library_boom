package uz.elmurodov.spring_boot.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.Dto;

import java.time.LocalDateTime;

/**
 * @Author Aziza Tojiboyeva
 */

@Setter
@Getter
@Builder
public class TaskCreateDto implements Dto {

    private String name;
    private String description;
    private String level;
    private String priority;
    private LocalDateTime deadline;
    private Long projectId;

}
