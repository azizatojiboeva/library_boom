package uz.elmurodov.spring_boot.services.comment;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.entity.comment.Comment;
import uz.elmurodov.spring_boot.mapper.comment.CommentMapper;
import uz.elmurodov.spring_boot.reposiroty.comment.CommentRepository;
import uz.elmurodov.spring_boot.reposiroty.task.TaskRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.comment.CommentValidator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class CommentServiceImpl extends AbstractService<CommentRepository, CommentMapper, CommentValidator>
        implements CommentService {

    private final TaskRepository taskRepository;

    protected CommentServiceImpl(
            CommentRepository repository,
            CommentMapper commentMapper,
            CommentValidator validator,
            BaseUtils baseUtils, TaskRepository taskRepository) {
        super(repository, commentMapper, validator, baseUtils);
        this.taskRepository = taskRepository;
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        Comment comment = mapper.fromCreateDto(createDto);
        comment.setTask_id(taskRepository.getById(createDto.getTaskId()).getId());
        repository.save(comment);
        return comment.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteSoft(id);
        return null;
    }

    @Override
    public Void update(CommentUpdateDto updateDto) {

        return null;
    }


    @Override
    public List<CommentDto> getAll(Long id) {
        return mapper.toDto(repository.findAll().stream()
                .filter(comment -> comment.getTask_id()
                        .equals(id))
                .collect(Collectors
                        .toList()));
    }

    @Override
    public CommentDto get(Long id) {
        return null;
    }


    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
