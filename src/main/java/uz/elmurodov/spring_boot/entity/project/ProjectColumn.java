package uz.elmurodov.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.entity.base.Auditable;
import uz.elmurodov.spring_boot.entity.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Entity
public class ProjectColumn extends Auditable {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "project_id", nullable = false)
    private Long project_id;

    private int position;

    private boolean active;

}
