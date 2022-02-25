package uz.elmurodov.spring_boot.mapper.task;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.elmurodov.spring_boot.dto.task.TaskMemberCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberUpdateDto;
import uz.elmurodov.spring_boot.entity.task.TaskMember;
import uz.elmurodov.spring_boot.mapper.base.BaseMapper;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Mapper(componentModel = "spring")
@Component
public interface TaskMemberMapper extends BaseMapper<
        TaskMember,
        TaskMemberDto,
        TaskMemberCreateDto,
        TaskMemberUpdateDto
        > {

    @Override
    TaskMemberDto toDto(TaskMember taskMember);

    @Override
    List<TaskMemberDto> toDto(List<TaskMember> e);

    @Override
    TaskMember fromCreateDto(TaskMemberCreateDto taskMemberCreateDto);

    @Override
    TaskMember fromUpdateDto(TaskMemberUpdateDto taskMemberUpdateDto);
}
