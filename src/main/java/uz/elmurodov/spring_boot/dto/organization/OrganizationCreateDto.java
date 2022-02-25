package uz.elmurodov.spring_boot.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.dto.base.Dto;

@Getter
@Setter
@Builder
@ToString
public class OrganizationCreateDto implements Dto {
    private String name;
    private MultipartFile logo;
    private String code;
    private String email;

    public OrganizationCreateDto(String name, MultipartFile logo, String code, String email) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.logo = logo;
    }
}
