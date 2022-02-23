package uz.elmurodov.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.Auditable;
import uz.elmurodov.spring_boot.entity.project.Project;

import javax.persistence.*;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Entity
public class TaskMember extends Auditable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "user_id")
    private Long userId;

}
