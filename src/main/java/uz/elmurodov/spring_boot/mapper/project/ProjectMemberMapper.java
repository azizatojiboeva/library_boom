package uz.elmurodov.spring_boot.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberDto;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberUpdateDto;
import uz.elmurodov.spring_boot.entity.project.ProjectMember;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMemberMapper extends BaseMapper<
        ProjectMember,
        ProjectMemberDto,
        ProjectMemberCreateDto,
        ProjectMemberUpdateDto
        > {
    @Override
    ProjectMemberDto toDto(ProjectMember projectMember);

    @Override
    List<ProjectMemberDto> toDto(List<ProjectMember> e);

    @Override
    ProjectMember fromCreateDto(ProjectMemberCreateDto projectMemberCreateDto);

}
