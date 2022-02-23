package uz.elmurodov.spring_boot.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.base.Auditable;
import uz.elmurodov.spring_boot.entity.task.Task;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_code",nullable = false)
    private CommentType commentType;

}
