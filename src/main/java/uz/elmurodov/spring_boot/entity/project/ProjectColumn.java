package uz.elmurodov.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.entity.Auditable;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private int order;

    private boolean active;

}
