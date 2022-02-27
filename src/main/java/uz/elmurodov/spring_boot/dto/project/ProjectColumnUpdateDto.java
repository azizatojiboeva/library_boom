package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter

public class ProjectColumnUpdateDto extends GenericDto {
    private String name;

    @Builder(builderMethodName = "childBuilder")
    public ProjectColumnUpdateDto(Long id, String name) {
        super(id);
        this.name = name;
    }
}
