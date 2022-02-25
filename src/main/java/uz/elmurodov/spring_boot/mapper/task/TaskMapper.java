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

    public TaskDto toDto(Task task);

    @Override
    public List<TaskDto> toDto(List<Task> e);

    @Override
    public Task fromCreateDto(TaskCreateDto taskCreateDto);


    public Task fromUpdateDto(TaskUpdateDto taskUpdateDto);
}
