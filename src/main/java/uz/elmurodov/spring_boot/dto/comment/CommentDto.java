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
public class CommentDto extends GenericDto {
    private String commentBody;
    private Long taskId;
    private String  commentType;


    @Builder(builderMethodName = "childBuilder")
    public CommentDto(Long id, String commentBody, Long taskId, String commentType) {
        super(id);
        this.commentBody = commentBody;
        this.taskId = taskId;
        this.commentType = commentType;
    }

}
