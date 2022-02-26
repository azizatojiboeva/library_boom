package uz.elmurodov.spring_boot.services.project;

import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberUpdateDto;
import uz.elmurodov.spring_boot.services.base.GenericCrudService;
import uz.elmurodov.spring_boot.services.base.GenericService;

import java.util.List;

public interface ProjectMemberService extends GenericCrudService<
        ProjectMemberDto,
        ProjectMemberCreateDto,
        ProjectMemberUpdateDto,
        GenericCriteria,
        Long
        > {
    List<AuthUserDto> getAllByProjectId(Long id);
}
