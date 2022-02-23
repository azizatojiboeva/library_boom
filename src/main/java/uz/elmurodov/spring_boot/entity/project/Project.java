package uz.elmurodov.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.Auditable;
import uz.elmurodov.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Setter
@Getter
@Table(name = "project", schema = "etm_b4")
public class Project extends Auditable {

    @Lob
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "tz_path")
    private String tzPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "closed")
    private Boolean closed;



}