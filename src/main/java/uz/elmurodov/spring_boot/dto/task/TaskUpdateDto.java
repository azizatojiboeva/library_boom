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

public class TaskUpdateDto extends GenericDto {

    private String name;
    private String description;
    private LocalDateTime deadline;
    @Builder(builderMethodName = "childBuilder")
    public TaskUpdateDto(Long id, String name, String description, LocalDateTime deadline) {
        super(id);
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }
}
