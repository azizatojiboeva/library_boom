package uz.elmurodov.spring_boot.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class CommentUpdateDto extends GenericDto {

    private String commentBody;

    @Builder(builderMethodName = "childBuilder")
    public CommentUpdateDto(Long id, String commentBody) {
        super(id);
        this.commentBody = commentBody;
    }

}
