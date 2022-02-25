package uz.elmurodov.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {
   @Modifying
   @Transactional
   @Query(value = "update project set deleted = true where id = :id",nativeQuery = true)
    void deleteSoft(@Param("id") Long id);
}
