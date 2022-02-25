package uz.elmurodov.spring_boot.dto.comment;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.Dto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class CommentCreateDto implements Dto {
    private String commentBody;
    private Long taskId;
    private String commentType;

}
