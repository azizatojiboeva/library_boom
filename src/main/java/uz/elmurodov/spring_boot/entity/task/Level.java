package uz.elmurodov.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author Aziza Tojiboyeva
 */
@Entity
@Setter
@Getter
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String code;

    private String name;


}
