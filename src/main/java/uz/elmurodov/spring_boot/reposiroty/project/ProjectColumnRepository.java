package uz.elmurodov.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.elmurodov.spring_boot.entity.project.ProjectColumn;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
public interface ProjectColumnRepository extends JpaRepository<ProjectColumn, Long>, AbstractRepository {

    @Query(value = "select * from etm_b4.project_column pc where pc.project_id = :id and not pc.is_deleted ",nativeQuery = true)
    List<ProjectColumn> getAll(@Param("id") Long id );
}
