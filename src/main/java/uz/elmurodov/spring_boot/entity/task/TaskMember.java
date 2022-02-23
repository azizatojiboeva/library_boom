package uz.elmurodov.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.base.Auditable;

import javax.persistence.*;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Entity
public class TaskMember extends Auditable {

    @Column(name = "column_id", nullable = false)
    private Long task_id;

    @Column(name = "user_id")
    private Long userId;



}
