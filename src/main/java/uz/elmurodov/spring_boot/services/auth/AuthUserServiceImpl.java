package uz.elmurodov.spring_boot.services.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.auth.AuthUserCreateDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.mapper.auth.AuthUserMapper;
import uz.elmurodov.spring_boot.reposiroty.auth.AuthRoleRepository;
import uz.elmurodov.spring_boot.reposiroty.auth.AuthUserRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.auth.AuthUserValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AuthUserServiceImpl extends
        AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements AuthUserService {

    private final PasswordEncoder encoder;
    private final AuditAwareImpl auditAware;
    private final AuthRoleRepository authRoleRepository;

    protected AuthUserServiceImpl(AuthUserRepository repository,
                                  AuthUserMapper mapper,
                                  AuthUserValidator validator,
                                  BaseUtils baseUtils,
                                  PasswordEncoder encoder,
                                  AuthRoleRepository authRoleRepository,
                                  AuditAwareImpl auditAware) {
        super(repository, mapper, validator, baseUtils);
        this.encoder = encoder;
        this.auditAware = auditAware;
        this.authRoleRepository = authRoleRepository;
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setPassword(encoder.encode(createDto.getPassword()));
        user.setOrganizationId(auditAware.getCredentials().getOrganizationId());
        user.setCreatedBy(auditAware.getCurrentAuditor().get());
        user.setCode(UUID.randomUUID());
        setAuthRole(user);
        repository.save(user);
        return user.getId();
    }

    private void setAuthRole(AuthUser user) {
        if (auditAware.getCredentials().isSuperUser())
            user.setRole(authRoleRepository.getAuthRoleById(2L).get());
        else
            user.setRole(authRoleRepository.getAuthRoleById(3L).get());
    }


    @Override
    public Void update(AuthUserUpdateDto updateDto) {
//        if (updateDto.getRole().getId()
        repository.update(updateDto);
        return null;
    }

    @Override
    public Void delete(Long id) {
        if (auditAware.getCurrentAuditor().get().equals(id)) throw new RuntimeException("403");
        repository.deleteSoft(id);
        return null;
    }


    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        if (Objects.equals(auditAware.getCredentials().getRole().toString(), "SUPER_ADMIN")){
        return mapper.toDto(repository.findAllUser());
        }
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<AuthUserDto> getAll(Long organizationId) {
        List<AuthUser> users = repository.findAll();
        List<AuthUser> list= users.stream().filter(authUser -> authUser.getOrganizationId().getId() == organizationId && !authUser.isDeleted()).collect(Collectors.toList());
        return mapper.toDto(list);
    }



    public List<AuthUserDto> getAllProjectMembers(List<Long> membersId) {
        List<AuthUserDto> dtos = new ArrayList<>();
        for (Long id : membersId) {
            AuthUser user= repository.getAuthUser(id);
            System.out.println(user);
             AuthUserDto userDto = mapper.toDto(user);
            dtos.add(userDto);
        }
        return dtos;
    }


    @Override
    public AuthUserDto get(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

}
