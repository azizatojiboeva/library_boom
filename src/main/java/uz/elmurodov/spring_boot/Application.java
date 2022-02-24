package uz.elmurodov.spring_boot;

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
public class Application /*implements CommandLineRunner*/ {


    private final AuthUserRepository authUserRepository;
    private final AuthRoleRepository authRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public Application(AuthUserRepository authUserRepository, AuthRoleRepository authRoleRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.authRoleRepository = authRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Transactional(timeout = 10)
    public void run(String... args) throws Exception {

        AuthUser admin = new AuthUser();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        AuthRole adminRole = authRoleRepository.findAuthRoleByCode("ADMIN").get();
        admin.setRole(adminRole);
        admin.setCode(UUID.randomUUID());

        authUserRepository.save(admin);

//        authUserRepository.saveAll(List.of(user1, user2));

    }
}
