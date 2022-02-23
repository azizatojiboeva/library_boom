package uz.elmurodov.spring_boot.entity.auth;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.entity.base.Auditable;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AuthPermission extends Auditable {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

}
