package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
@Builder
public class ProjectDto extends GenericDto {
    private String name;
    private Long organizationId;
    private boolean closed;

    public ProjectDto(Long id, String name, Long organizationId, boolean closed) {
        super(id);
        this.name = name;
        this.organizationId = organizationId;
        this.closed = closed;
    }

    public ProjectDto(String name, Long organizationId, boolean closed) {
        this.name = name;
        this.organizationId = organizationId;
        this.closed = closed;
    }
}
