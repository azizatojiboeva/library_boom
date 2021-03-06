package uz.elmurodov.spring_boot.config.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('ADMIN')")
public @interface HasAdminRole {
}
