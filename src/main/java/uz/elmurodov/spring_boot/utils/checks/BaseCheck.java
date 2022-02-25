package uz.elmurodov.spring_boot.utils.checks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.config.security.UserDetails;
import uz.elmurodov.spring_boot.entity.auth.AuthPermission;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
public class BaseCheck {

    private final AuditAwareImpl auditable;

    @Autowired
    public BaseCheck(AuditAwareImpl auditable) {
        this.auditable = auditable;
    }

    public boolean hasRole(String code){
        UserDetails credentials = auditable.getCredentials();
        return code.equalsIgnoreCase(credentials.getRole().getCode());
    }

    public boolean hasPermission(String code){
        UserDetails credentials = auditable.getCredentials();
        List<AuthPermission> permissions = credentials.getRole().getPermissions();
        for (AuthPermission permission : permissions) {
            if(permission.getCode().equalsIgnoreCase(code)){
                return true;
            }
        }
        return false;
    }
}
