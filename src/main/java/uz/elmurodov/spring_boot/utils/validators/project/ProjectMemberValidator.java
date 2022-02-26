package uz.elmurodov.spring_boot.utils.validators.project;

import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberUpdateDto;
import uz.elmurodov.spring_boot.exceptions.ValidationException;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.AbstractValidator;

@Component
public class ProjectMemberValidator extends AbstractValidator<
        ProjectMemberCreateDto,
        ProjectMemberUpdateDto,
        Long> {
    protected ProjectMemberValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectMemberCreateDto projectMemberCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectMemberUpdateDto cd) throws ValidationException {

    }
}
