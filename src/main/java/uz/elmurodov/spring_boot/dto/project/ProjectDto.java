package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Setter
@Getter
public class ProjectDto extends GenericDto {
    private String name;
    private Long organizationId;
    private boolean closed;
    private List<ProjectColumnDto> columns;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, Long organizationId, boolean closed, List<ProjectColumnDto> columns) {
        super(id);
        this.name = name;
        this.organizationId = organizationId;
        this.closed = closed;
        this.columns = columns;
    }
}
