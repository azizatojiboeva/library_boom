package uz.elmurodov.spring_boot.entity.base;

import lombok.Getter;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.config.security.UserDetails;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;

import java.util.Optional;

@Component
@Getter
public class AuditAwareImpl implements AuditorAware<Long> {

    private UserDetails userDetails;

    @Override
    public Optional<Long> getCurrentAuditor() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.userDetails = principal;
        return Optional.of(principal.getId());
    }

    public Optional<UserDetails> getCurrentUserDetails() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }


}
