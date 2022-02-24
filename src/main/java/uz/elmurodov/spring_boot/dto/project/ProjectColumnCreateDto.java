package uz.elmurodov.spring_boot.dto.project;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.Dto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class ProjectColumnCreateDto implements Dto {
    private String name;
    private Long project_id;
}
