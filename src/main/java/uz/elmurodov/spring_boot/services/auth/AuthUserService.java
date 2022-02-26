package uz.elmurodov.spring_boot.services.auth;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.auth.AuthUserCreateDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;

import java.util.List;

public interface AuthUserService extends GenericCrudService<
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto,
        GenericCriteria,
        Long
        > {
    List<AuthUserDto> getAllProjectMembers(List<Long> membersId);
}
