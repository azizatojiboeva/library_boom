package uz.elmurodov.spring_boot.entity.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.elmurodov.spring_boot.entity.base.Auditable;
import uz.elmurodov.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Author Aziza Tojiboyeva
 */
@Entity
@Setter
@Getter
@ToString
public class AuthUser extends Auditable {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    //    @Column(columnDefinition = "default false")
    private boolean isSuperUser;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "organization_id", nullable = true)
    private Organization organizationId;

    @Column(nullable = true)
    private UUID code;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "role_id", nullable = true)
    private AuthRole role;

    private boolean active = true;

    private boolean blocked;
    @Column(nullable = true)
    private Boolean deleted = false;

//    @Column(nullable = false )
//    private String email;
//
//
//    private boolean isSuperUser;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "organization_id", nullable = false)
//    private Organization organizationId;

}
