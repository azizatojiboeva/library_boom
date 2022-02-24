package uz.elmurodov.spring_boot.mapper.project;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnUpdateDto;
import uz.elmurodov.spring_boot.entity.project.ProjectColumn;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Component
@Mapper(componentModel = "spring")
public interface ProjectColumnMapper extends BaseMapper<
        ProjectColumn,
        ProjectColumnDto,
        ProjectColumnCreateDto,
        ProjectColumnUpdateDto
        > ,uz.elmurodov.spring_boot.mapper.base.Mapper {

    @Override
    ProjectColumnDto toDto(ProjectColumn projectColumn);

    @Override
    List<ProjectColumnDto> toDto(List<ProjectColumn> e);

    @Override
    ProjectColumn fromCreateDto(ProjectColumnCreateDto projectColumnCreateDto);

    @Override
    ProjectColumn fromUpdateDto(ProjectColumnUpdateDto projectColumnUpdateDto);

}
