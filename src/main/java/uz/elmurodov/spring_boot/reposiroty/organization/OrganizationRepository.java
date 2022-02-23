package uz.elmurodov.spring_boot.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

}
