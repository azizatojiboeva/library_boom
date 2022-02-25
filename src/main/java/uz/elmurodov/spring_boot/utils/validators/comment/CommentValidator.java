package uz.elmurodov.spring_boot.utils.validators.comment;

import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.exceptions.ValidationException;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.AbstractValidator;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
public class CommentValidator extends AbstractValidator<CommentCreateDto, CommentUpdateDto, Long> {


    protected CommentValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CommentCreateDto commentCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CommentUpdateDto cd) throws ValidationException {

    }
}
