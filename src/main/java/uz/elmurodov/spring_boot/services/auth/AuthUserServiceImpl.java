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

import java.util.List;
import java.util.UUID;

@Service
public class AuthUserServiceImpl extends
        AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements AuthUserService {

    private final PasswordEncoder encoder;
    private final AuthRoleRepository authRoleRepository;

    protected AuthUserServiceImpl(AuthUserRepository repository,
                                  AuthUserMapper mapper,
                                  AuthUserValidator validator,
                                  BaseUtils baseUtils, PasswordEncoder encoder, AuthRoleRepository authRoleRepository) {
        super(repository, mapper, validator, baseUtils);
        this.encoder = encoder;
        this.authRoleRepository = authRoleRepository;
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setPassword(encoder.encode(createDto.getPassword()));
        user.setOrganizationId(1L);
        user.setRole(authRoleRepository.getAuthRoleById(1L).get());
        user.setCreatedBy(new AuditAwareImpl().getCurrentAuditor().get());
        repository.save(user);
        return user.getId();
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(AuthUserUpdateDto updateDto) {
        return null;
    }


    @Override
    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        AuthUser authUser = repository.getById(id);
        return mapper.toDto(authUser);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

}
