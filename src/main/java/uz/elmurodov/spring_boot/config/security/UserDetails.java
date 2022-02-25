package uz.elmurodov.spring_boot.config.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.elmurodov.spring_boot.entity.auth.AuthRole;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.entity.organization.Organization;

import java.util.*;

@Getter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Long id;

    private Organization organizationId;

    //    private AuthRole role;

    private String username;

    private String password;

    private UUID code;

    private boolean blocked;

    private boolean active;

    private boolean superUser;

    private Set<GrantedAuthority> authorities;


    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.organizationId = user.getOrganizationId();
        this.superUser = user.isSuperUser();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.code = user.getCode();
        this.blocked = user.isBlocked();
        this.active = user.isActive();
//        this.role= user.getRole();
        processAuthorities(user);
    }

    private void processAuthorities(AuthUser user) {
        authorities = new HashSet<>();
        AuthRole role = user.getRole();
        if (Objects.isNull(role)) return;
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
        if (Objects.isNull(role.getPermissions())) return;
        role.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getCode())));
    }

    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

}
