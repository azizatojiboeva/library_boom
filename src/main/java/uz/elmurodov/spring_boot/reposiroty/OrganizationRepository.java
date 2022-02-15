package uz.elmurodov.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.elmurodov.spring_boot.entity.organization.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
