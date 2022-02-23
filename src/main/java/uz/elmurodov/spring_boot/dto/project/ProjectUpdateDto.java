package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Builder
public class ProjectUpdateDto extends GenericDto {
    private String name;

}
