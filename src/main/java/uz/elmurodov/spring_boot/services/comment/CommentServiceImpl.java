package uz.elmurodov.spring_boot.services.comment;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.mapper.comment.CommentMapper;
import uz.elmurodov.spring_boot.reposiroty.comment.CommentRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.comment.CommentValidator;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class CommentServiceImpl extends AbstractService<CommentRepository, CommentMapper, CommentValidator> implements CommentService {

    protected CommentServiceImpl(
            CommentRepository repository,
            CommentMapper mapper,
            CommentValidator validator,
            BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(CommentUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<CommentDto> getAll(GenericCriteria criteria) {
        return null;
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
