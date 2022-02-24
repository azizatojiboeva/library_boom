package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class ProjectDto extends GenericDto {
    private String name;
    private Long organizationId;
    private boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, Long organizationId, boolean closed) {
        super(id);
        this.name = name;
        this.organizationId = organizationId;
        this.closed = closed;
    }
}
