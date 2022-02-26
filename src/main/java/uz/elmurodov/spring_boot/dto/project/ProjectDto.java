package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

import java.time.LocalDateTime;
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
    private String tzPath;
    private LocalDateTime finishDate;
    private List<ProjectColumnDto> columns;
    private List<ProjectMemberDto> members;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name,
                      Long organizationId,
                      LocalDateTime finishDate,
                      boolean closed,
                      String tzPath,
                      List<ProjectColumnDto> columns,
                      List<ProjectMemberDto> members) {

        super(id);
        this.name = name;
        this.organizationId = organizationId;
        this.finishDate = finishDate;
        this.closed = closed;
        this.tzPath = tzPath;
        this.columns = columns;
        this.members = members;
    }
}
