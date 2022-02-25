package uz.elmurodov.spring_boot.dto.auth;

import lombok.Getter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

@Getter
public class AuthRoleDto extends GenericDto {
    private String name;
    private String code;
}
