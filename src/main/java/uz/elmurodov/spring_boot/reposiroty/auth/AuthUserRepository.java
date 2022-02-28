package uz.elmurodov.spring_boot.reposiroty.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uz.elmurodov.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.elmurodov.spring_boot.entity.auth.AuthUser;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.reposiroty.base.AbstractRepository;


import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {
    Optional<AuthUser> findAuthUserByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = "update etm_b4.auth_user set username = username+ code , email= email+code where id = :id", nativeQuery = true)
    void deleteSoft(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update etm_b4.auth_user set username = :#{#dto.username} ,role_id=:#{#dto.role}, email=:#{#dto.email}  where id = :id", nativeQuery = true)
    void update(@Param("dto") AuthUserUpdateDto dto);


    @Query(value = "select * from etm_b4.auth_user where not is_deleted", nativeQuery = true)
    List<AuthUser> getAll();
    @Query("select A from AuthUser A where  A.deleted = false and  A.role.id = 1")
    List<AuthUser> findAllUser();

    @Query(value = "select * from auth_user where id = :id and not is_deleted", nativeQuery = true)
    AuthUser getAuthUser(@Param("id") Long id);

    /*@Query(value = "select * from etm_b4.auth_user where  organization_id = :id and not is_deleted ",nativeQuery = true)
    List<AuthUser> getAllByOrgId(@Param("id") Long id);*/
}
