package uz.elmurodov.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberDto;
import uz.elmurodov.spring_boot.entity.project.ProjectMember;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>, AbstractRepository {

    @Query(value = "select * from  etm_b4.project_member pm where pm.project_id = :id", nativeQuery = true)
    List<ProjectMember> getAllByProjectId(@Param("id") Long id);

    @Query(value = "select pm.user_id from etm_b4.project_member pm where pm.project_id =:projectId ", nativeQuery = true)
    List<Long> getAllProjectMembersById(@Param("projectId") Long projectId);
}
