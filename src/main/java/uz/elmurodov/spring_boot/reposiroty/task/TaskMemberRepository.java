package uz.elmurodov.spring_boot.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
@Repository
public interface TaskMemberRepository extends JpaRepository<Task, Long>, AbstractRepository {
}
