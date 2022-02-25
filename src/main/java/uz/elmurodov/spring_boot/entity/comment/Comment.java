package uz.elmurodov.spring_boot.entity.comment;

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
public class Comment extends Auditable {

    @Column(nullable = false)
    private String commentBode;

   @Column(name = "task_id", nullable = false)
    private Long task_id;

    private String commentType;

}
