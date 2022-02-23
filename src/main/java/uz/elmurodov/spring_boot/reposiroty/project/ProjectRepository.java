package uz.elmurodov.spring_boot.reposiroty.project;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.project.Project;

import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

/**
 * @Author Aziza Tojiboyeva
 */
public interface ProjectRepository extends AbstractRepository, JpaRepository<Project, Long>{
}
