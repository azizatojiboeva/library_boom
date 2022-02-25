package uz.elmurodov.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnUpdateDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.entity.project.ProjectColumn;
import uz.elmurodov.spring_boot.mapper.project.ProjectColumnMapper;
import uz.elmurodov.spring_boot.reposiroty.project.ProjectColumnRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.services.task.TaskService;
import uz.elmurodov.spring_boot.services.task.TaskServiceImpl;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectColumnValidator;

import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class ProjectColumnServiceImpl extends AbstractService<
        ProjectColumnRepository,
        ProjectColumnMapper,
        ProjectColumnValidator
        > implements ProjectColumnService {
    private final TaskServiceImpl taskService;

    @Autowired
    protected ProjectColumnServiceImpl(
            ProjectColumnRepository repository,
            ProjectColumnMapper mapper,
            ProjectColumnValidator validator,
            BaseUtils baseUtils, TaskService taskService, TaskServiceImpl taskService1) {
        super(repository, mapper, validator, baseUtils);
        this.taskService = taskService1;
    }


    @Override
    public Long create(ProjectColumnCreateDto createDto) {
        ProjectColumn projectColumn = mapper.fromCreateDto(createDto);
        ProjectColumn projectColumn1 = repository.save(projectColumn);
        return projectColumn1.getId();
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(ProjectColumnUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<ProjectColumnDto> getAll(GenericCriteria criteria) {
//        ProjectColumn projectColumn = repository.getAll();
        return null;
    }

    public List<ProjectColumnDto> getAll(Long id) {
        List<ProjectColumn> projectColumn = repository.getAll(id);
        List<ProjectColumnDto> dtos = mapper.toDto(projectColumn);
        for (ProjectColumnDto dto : dtos) {
            List<TaskDto> tasks = taskService.getAll(dto.getId());
            dto.setTasks(tasks);
        }
        return dtos;
    }

    @Override
    public ProjectColumnDto get(Long id) {
        ProjectColumn projectColumn = repository.getById(id);
        return mapper.toDto(projectColumn);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
