package uz.elmurodov.spring_boot.reposiroty.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

import javax.transaction.Transactional;

/**
 * @Author Aziza Tojiboyeva
 */
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Transactional
    @Modifying
    @Query(value = "update etm_b4.task set priority = :priority where id= :id",nativeQuery = true)
    void changePriority( @Param("priority") String priority,@Param("id") Long id);


    @Query(value = "select * from etm_b4.task where id = :id and not is_deleted", nativeQuery = true)
    TaskDto getTaskById(@Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value = "update etm_b4.task set level = :level where id= :id",nativeQuery = true)
    void changeLevel(@Param("id")Long id, @Param("level") String level);
}
