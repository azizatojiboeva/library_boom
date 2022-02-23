package uz.elmurodov.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.Auditable;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "project_member", schema = "etm_b4")
public class ProjectMember extends Auditable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_lead")
    private Boolean isLead;

}