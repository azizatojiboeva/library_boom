package uz.elmurodov.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.base.Auditable;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "project_member", schema = "etm_b4")
public class ProjectMember extends Auditable {

    @Column(name = "project_id",nullable = false)
    private Long project;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_lead")
    private Boolean isLead = false;

    @Column(nullable = true)
    private Boolean deleted = false;

}