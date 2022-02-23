package uz.elmurodov.spring_boot.entity.project;

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
public class ProjectColumn extends Auditable {
    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "project_id", nullable = false)
    private Long project_id;

    private int order;

    private boolean active;

}
