package uz.elmurodov.spring_boot.mapper.auth;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import uz.elmurodov.spring_boot.dto.auth.AuthUserCreateDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto>,
        uz.elmurodov.spring_boot.mapper.base.Mapper {

    @Override
    AuthUserDto toDto(AuthUser authUser);

    @Override
    List<AuthUserDto> toDto(List<AuthUser> e);

    @Override
    AuthUser fromCreateDto(AuthUserCreateDto dto);

    @Override
    @Mapping(target = "role",ignore = true)
    AuthUser fromUpdateDto(AuthUserUpdateDto authUserUpdateDto);
}
