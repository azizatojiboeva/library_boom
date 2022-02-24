package uz.elmurodov.spring_boot.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {

}
