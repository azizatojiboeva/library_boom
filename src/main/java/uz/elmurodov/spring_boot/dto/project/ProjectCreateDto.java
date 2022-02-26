package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.elmurodov.spring_boot.dto.base.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Builder
public class ProjectCreateDto implements Dto {
    private String name;
    private LocalDateTime finishDate;
    private MultipartFile tz;

    public ProjectCreateDto(String name,  LocalDateTime finishDate,MultipartFile tz) {
        this.name = name;
        this.finishDate=finishDate;
        this.tz = tz;
    }
}
