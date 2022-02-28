package uz.elmurodov.spring_boot.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.entity.task.TaskMember;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface TaskMemberRepository extends JpaRepository<Task, Long>, AbstractRepository {

    @SuppressWarnings("SpringDataRepositoryMethodReturnTypeInspection")
    @Query(value = "select tm from etm_b4.task_member tm where not tm.is_deleted and tm.task_id = :id", nativeQuery = true)
    List<TaskMember> getAllByTaskId(Long id);
}
