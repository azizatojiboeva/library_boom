package uz.elmurodov.spring_boot.entity.base;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.config.security.UserDetails;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import java.util.Optional;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
public class AuditAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal.getId());
    }

}
