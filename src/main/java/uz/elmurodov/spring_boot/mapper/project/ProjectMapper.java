package uz.elmurodov.spring_boot.mapper.project;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
public interface ProjectMapper extends BaseMapper<
        Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto>, uz.elmurodov.spring_boot.mapper.base.Mapper {

    @Override
    @Mapping(target = "finishDate", ignore = true)
  //  @Mapping(target = "organization", ignore = true)
    public ProjectDto toDto(Project project) ;

    @Override
    @Mapping(target = "finishDate", ignore = true)
    //@Mapping(target = "organization", ignore = true)
    public List<ProjectDto> toDto(List<Project> e) ;

    @Override
    public Project fromCreateDto(ProjectCreateDto projectCreateDto) ;


    @Override
    public Project fromUpdateDto(ProjectUpdateDto projectUpdateDto) ;
}
