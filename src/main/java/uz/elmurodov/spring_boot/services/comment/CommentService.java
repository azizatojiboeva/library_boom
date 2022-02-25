package uz.elmurodov.spring_boot.services.comment;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;

/**
 * @Author Aziza Tojiboyeva
 */
public interface CommentService extends GenericCrudService<CommentDto, CommentCreateDto, CommentUpdateDto, GenericCriteria,Long> {
}
