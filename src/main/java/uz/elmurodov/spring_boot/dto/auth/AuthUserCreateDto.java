package uz.elmurodov.spring_boot.dto.auth;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.Dto;

@Getter
@Setter
public class AuthUserCreateDto implements Dto {
    private String username;
    private String password;
    private String email;
    private Long role_id;
    private Long org_id;
}
