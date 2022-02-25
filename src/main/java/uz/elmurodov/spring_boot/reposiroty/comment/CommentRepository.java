package uz.elmurodov.spring_boot.reposiroty.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {
}
