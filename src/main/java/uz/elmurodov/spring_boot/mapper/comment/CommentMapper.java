package uz.elmurodov.spring_boot.mapper.comment;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
@Mapper(componentModel = "spring")
public interface CommentMapper extends BaseMapper<Comment, CommentDto, CommentCreateDto, CommentUpdateDto> {

    @Override
    CommentDto toDto(Comment comment);

    @Override
    List<CommentDto> toDto(List<Comment> e);

    @Override
    Comment fromCreateDto(CommentCreateDto commentCreateDto);

    @Override
    Comment fromUpdateDto(CommentUpdateDto commentUpdateDto);
}
