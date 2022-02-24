package uz.elmurodov.spring_boot.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.base.Auditable;
import uz.elmurodov.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.util.UUID;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Table
@Entity
public class AuthUser extends Auditable {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private UUID code;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private AuthRole role;

    private boolean active = true;

    private boolean blocked;

    @Column(nullable = false )
    private String email;

    @Column(columnDefinition = "default false")
    private boolean isSuperUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organizationId;

}
