package uz.elmurodov.spring_boot.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.spring_boot.dto.base.Dto;

@Getter
@Setter
@Builder
public class ProjectMemberCreateDto implements Dto {

    private Long project;

    private Long userId;
}
