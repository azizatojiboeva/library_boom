package uz.elmurodov.spring_boot.services.project;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.base.GenericDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
public interface ProjectColumnService extends GenericCrudService<
        ProjectColumnDto,
        ProjectColumnCreateDto,
        ProjectColumnUpdateDto,
        GenericCriteria,
        Long
        > {
}
