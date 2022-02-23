package uz.elmurodov.spring_boot.entity.comment;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Entity
public class CommentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String name;

}
