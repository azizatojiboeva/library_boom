package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class ProjectColumnDto extends GenericDto {
    private String name;
    private List<TaskDto> tasks;
    private Long project_id;

    @Builder(builderMethodName = "childBuilder")
    public ProjectColumnDto(Long id, String name, List<TaskDto> tasks, Long project_id) {
        super(id);
        this.name = name;
        this.tasks = tasks;
        this.project_id = project_id;
    }
}
