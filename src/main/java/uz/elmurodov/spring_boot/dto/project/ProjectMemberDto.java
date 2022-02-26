package uz.elmurodov.spring_boot.dto.project;

import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.base.GenericDto;

public class ProjectMemberDto extends GenericDto {
    private Long project;

    private Long userId;
}
