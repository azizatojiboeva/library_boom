package uz.elmurodov.spring_boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import uz.elmurodov.spring_boot.entity.auth.AuthRole;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.reposiroty.auth.AuthRoleRepository;
import uz.elmurodov.spring_boot.reposiroty.auth.AuthUserRepository;

import java.util.UUID;

@SpringBootApplication
@EnableJpaAuditing
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
