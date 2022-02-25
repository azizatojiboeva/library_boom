package uz.elmurodov.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.base.Auditable;
import uz.elmurodov.spring_boot.entity.project.Project;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Entity
public class Task extends Auditable {

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "level_code", nullable = false)
    private Level level;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "priority_code", nullable = false)
    private Priority priority;

    @Column(columnDefinition = " timestamp ")
    private LocalDateTime deadline;

    @Column(nullable = false, name = "column_id")
    private Long columnId;

    private boolean completed;


}
