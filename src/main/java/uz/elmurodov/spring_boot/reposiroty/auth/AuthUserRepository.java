package uz.elmurodov.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;


import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {
    Optional<AuthUser> findAuthUserByUsername(String username);

}
