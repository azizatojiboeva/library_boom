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
public class ProjectUpdateDto extends GenericDto {
    private String name;

    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name) {
        super(id);
        this.name=name;
    }
}
