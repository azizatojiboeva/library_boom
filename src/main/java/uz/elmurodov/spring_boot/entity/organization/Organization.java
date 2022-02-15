package uz.elmurodov.spring_boot.entity.organization;

import lombok.CustomLog;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String logo;

    private String email;

    @Column(unique = true, nullable = false)
    private String code;

    private String location;

    private Long owner;
}
