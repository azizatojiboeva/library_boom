package uz.elmurodov.spring_boot.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

import javax.transaction.Transactional;

/**
 * @Author Aziza Tojiboyeva
 */
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Transactional
    @Modifying
    @Query(value = "update etm_b4.task set priority= prior where id=id",nativeQuery = true)
    void changePriority(@Param("id") Long id, @Param("priority") String prior);

}
