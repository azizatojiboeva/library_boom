package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.GenericDto;
@Getter
@Setter

public class ProjectMemberDto extends GenericDto {
    private Long projectId;

    private Long userId;

    @Builder(builderMethodName = "childBuilder")
    public ProjectMemberDto(Long id, Long projectId, Long userId) {
        super(id);
        this.projectId = projectId;
        this.userId = userId;
    }
}
