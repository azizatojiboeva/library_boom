package uz.elmurodov.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import uz.elmurodov.spring_boot.entity.base.Auditable;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.entity.upload.Uploads;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@Table(name = "project", schema = "etm_b4")
public class Project extends Auditable {


    @Column(name = "name")
    private String name;


    @Type(type = "")
    @Column(name = "tz_path")
    private String tzPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @Column(name = "closed")
    private Boolean closed;

    @Column(columnDefinition = "TIMESTAMP default '2022-04-26 16:41:17.293' ")
    private LocalDateTime finishDate;

    @Column(nullable = true)
    private Boolean deleted = false;


}