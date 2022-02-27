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
public class TaskDto extends GenericDto {

    private String name;
    private String description;
    private String level;
    private String priority;
    private LocalDateTime deadline;
    private Long projectId;
    private Long columnId;
    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String name, String description, String level, String priority, LocalDateTime deadline, Long projectId, Long columnId) {
        super(id);
        this.name = name;
        this.description = description;
        this.level = level;
        this.priority = priority;
        this.deadline = deadline;
        this.projectId = projectId;
        this.columnId = columnId;
    }
}
