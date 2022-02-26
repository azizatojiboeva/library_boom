package uz.elmurodov.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query(value = "update project set deleted = true where id = :id", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update project set name = :#{#dto.name} where id = :#{#dto.id}", nativeQuery = true)
    void update(@Param("dto") ProjectUpdateDto dto);

    @Query(value = "select * from etm_b4.project p where p.organization_id = id and not p.is_deleted order by p.id asc", nativeQuery = true)
    List<Project> getAll(@Param( value = "id") Long id);

    @Query("select p from Project p where  p.deleted = false and p.id =:id ")
    Project getProject(Long id);
}
