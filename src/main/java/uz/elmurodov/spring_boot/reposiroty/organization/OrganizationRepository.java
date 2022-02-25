package uz.elmurodov.spring_boot.reposiroty.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.elmurodov.spring_boot.entity.organization.Organization;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {
    @Query(value = "select * from etm_b4.organization where not deleted", nativeQuery = true)
    List<Organization> getAll();

    @Modifying
    @Transactional
    @Query(value = "update organization  set deleted=true, email = email+code where id=:id", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);
}
