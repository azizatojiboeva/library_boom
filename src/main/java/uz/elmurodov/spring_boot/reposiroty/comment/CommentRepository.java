package uz.elmurodov.spring_boot.reposiroty.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {
    @Transactional
    @Modifying
    @Query(value = "update comment set deleted = true where id = :id", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);


    @Modifying
    @Transactional
    @Query(value = "update comment set commentBody  = :#{#dto.commentBody} where id = :#{#dto.id}", nativeQuery = true)
    void update(@Param("dto") CommentUpdateDto dto);
}
