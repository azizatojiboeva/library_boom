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

    private String level;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private String priority;

    @Column(columnDefinition = " timestamp ")
    private LocalDateTime deadline;

    @Column(nullable = false, name = "column_id")
    private Long columnId;

    private boolean completed;


}
