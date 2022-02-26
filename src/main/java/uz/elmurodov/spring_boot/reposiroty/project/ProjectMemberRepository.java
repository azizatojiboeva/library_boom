package uz.elmurodov.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.project.ProjectMember;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>, AbstractRepository {
}
