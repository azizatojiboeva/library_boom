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
public class Application /*implements CommandLineRunner*/ {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    private final AuthUserRepository authUserRepository;
    private final AuthRoleRepository authRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public Application(AuthUserRepository authUserRepository, AuthRoleRepository authRoleRepository, PasswordEncoder passwordEncoder) {
        this.authUserRepository = authUserRepository;
        this.authRoleRepository = authRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @Transactional(timeout = 10)
    public void run(String... args) throws Exception {

        AuthUser admin = new AuthUser();
        admin.setUsername("1");
        admin.setPassword(passwordEncoder.encode("1"));
        AuthRole adminRole = authRoleRepository.findAuthRoleByCode("ADMIN").get();
        admin.setEmail("a1@.gmail.com");
        admin.setOrganizationId(1L);
        admin.setRole(adminRole);
        admin.setCode(UUID.randomUUID());

        authUserRepository.save(admin);

//        authUserRepository.saveAll(List.of(user1, user2));

    }


}
