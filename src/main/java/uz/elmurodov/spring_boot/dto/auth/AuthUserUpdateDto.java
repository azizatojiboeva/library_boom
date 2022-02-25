package uz.elmurodov.spring_boot.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;
import uz.elmurodov.spring_boot.entity.auth.AuthRole;

@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class AuthUserUpdateDto extends GenericDto {
    private String username;
    private String email;
    private Long role;
}
