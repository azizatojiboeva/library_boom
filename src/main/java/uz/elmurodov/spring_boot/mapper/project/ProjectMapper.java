package uz.elmurodov.spring_boot.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.entity.project.Project;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
@Mapper(componentModel = "spring")
public class ProjectMapper implements BaseMapper<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto>, uz.elmurodov.spring_boot.mapper.base.Mapper {

    @Override
    public ProjectDto toDto(Project project) {
        return null;
    }

    @Override
    public List<ProjectDto> toDto(List<Project> e) {
        return null;
    }

    @Override
    public Project fromCreateDto(ProjectCreateDto projectCreateDto) {
        return null;
    }

    @Override
    public Project fromUpdateDto(ProjectUpdateDto projectUpdateDto) {
        return null;
    }
}
