package uz.elmurodov.spring_boot.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;
@Setter
@Getter
public class AuthUserDto extends GenericDto {
    private String username;
    private String email;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserDto(Long id, String username, String email) {
        super(id);
        this.username = username;
        this.email = email;
    }
}
