package uz.elmurodov.spring_boot.entity.upload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Entity
public class Uploads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalName;
    private String generatedName;
    private String contentType;
    private long size;
    private String path;
}
