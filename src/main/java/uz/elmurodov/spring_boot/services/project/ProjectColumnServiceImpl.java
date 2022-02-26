package uz.elmurodov.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnDto;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnUpdateDto;
import uz.elmurodov.spring_boot.mapper.project.ProjectColumnMapper;
import uz.elmurodov.spring_boot.reposiroty.project.ProjectColumnRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
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
        ProjectColumnValidator>
        implements ProjectColumnService{

    @Autowired
    protected ProjectColumnServiceImpl(
            ProjectColumnRepository repository,
            ProjectColumnMapper mapper,
            ProjectColumnValidator validator,
            BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }


    @Override
    public Long create(ProjectColumnCreateDto createDto) {
        return null;
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
        return null;
    }

    @Override
    public List<ProjectColumnDto> getAll(Long id) {
        return null;
    }

    @Override
    public ProjectColumnDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
