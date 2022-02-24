package uz.elmurodov.spring_boot.utils.validators.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnUpdateDto;
import uz.elmurodov.spring_boot.exceptions.ValidationException;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.AbstractValidator;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
public class ProjectColumnValidator extends AbstractValidator<ProjectColumnCreateDto,
        ProjectColumnUpdateDto, Long> {


    @Autowired
    protected ProjectColumnValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectColumnCreateDto projectColumnCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectColumnUpdateDto cd) throws ValidationException {

    }
}
