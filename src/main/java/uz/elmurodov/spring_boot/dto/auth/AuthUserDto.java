package uz.elmurodov.spring_boot.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;
@Setter
@Getter
@Builder(builderMethodName = "childBuilder")
public class AuthUserDto extends GenericDto {
    private String username;
    private String email;
}
