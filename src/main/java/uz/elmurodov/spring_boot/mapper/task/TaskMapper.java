package uz.elmurodov.spring_boot.mapper.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.task.TaskCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.dto.task.TaskUpdateDto;
import uz.elmurodov.spring_boot.entity.task.Task;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Mapper(componentModel = "spring")
@Component
public interface TaskMapper extends BaseMapper<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto
        > {

    @Override
    @Mapping(target = "level",ignore = true)
    @Mapping(target = "priority",ignore = true)
    public TaskDto toDto(Task task);

    @Override
    @Mapping(target = "priority",ignore = true)
    @Mapping(target = "level",ignore = true)
    public List<TaskDto> toDto(List<Task> e);

    @Override
    @Mapping(target = "priority",ignore = true)
    @Mapping(target = "level",ignore = true)
    public Task fromCreateDto(TaskCreateDto taskCreateDto);

    @Override
    @Mapping(target = "priority",ignore = true)
    @Mapping(target = "level",ignore = true)
    public Task fromUpdateDto(TaskUpdateDto taskUpdateDto);
}
