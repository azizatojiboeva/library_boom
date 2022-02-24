package uz.elmurodov.spring_boot.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.Dto;
import uz.elmurodov.spring_boot.entity.auth.AuthRole;

@Getter
@Setter
public class AuthUserCreateDto implements Dto {
    private String username;
    private String password;
    private String email;
//    private AuthRole role_id;
//    private Long organizationId;

}
