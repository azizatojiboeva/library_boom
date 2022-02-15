package uz.elmurodov.spring_boot.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.dto.BaseDto;

@Getter
@Setter
@Builder
public class OrganizationCreateDto implements BaseDto {
    private String name;
    private String code;
    private String email;
    private MultipartFile logo;

    public OrganizationCreateDto(String name, String code, String email, MultipartFile logo) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.logo = logo;
    }
}
