package uz.elmurodov.spring_boot.services.auth;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.auth.AuthUserCreateDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.mapper.auth.AuthUserMapper;
import uz.elmurodov.spring_boot.mapper.organization.OrganizationMapper;
import uz.elmurodov.spring_boot.reposiroty.auth.AuthUserRepository;
import uz.elmurodov.spring_boot.reposiroty.organization.OrganizationRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.auth.AuthUserValidator;
import uz.elmurodov.spring_boot.utils.validators.organization.OrganizationValidator;

import java.util.List;

@Service
public class AuthUserServiceImpl extends
        AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator>
        implements AuthUserService {
    protected AuthUserServiceImpl(AuthUserRepository repository,
                                  AuthUserMapper mapper,
                                  AuthUserValidator validator,
                                  BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        AuthUser user = mapper.fromCreateDto(createDto);
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
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

}
