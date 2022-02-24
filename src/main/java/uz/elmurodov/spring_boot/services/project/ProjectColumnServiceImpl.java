package uz.elmurodov.spring_boot.services.project;

import org.springframework.stereotype.Service;
import uz.elmurodov.spring_boot.mapper.project.ProjectColumnMapper;
import uz.elmurodov.spring_boot.reposiroty.project.ProjectColumnRepository;
import uz.elmurodov.spring_boot.services.base.AbstractService;
import uz.elmurodov.spring_boot.utils.BaseUtils;
import uz.elmurodov.spring_boot.utils.validators.project.ProjectColumnValidator;

/**
 * @Author Aziza Tojiboyeva
 */
@Service
public class ProjectColumnServiceImpl extends AbstractService<
        ProjectColumnRepository,
        ProjectColumnMapper,
        ProjectColumnValidator
        > {


    protected ProjectColumnServiceImpl(
            ProjectColumnRepository repository,
            ProjectColumnMapper mapper,
            ProjectColumnValidator validator,
            BaseUtils baseUtils) {
        super(repository, mapper, validator, baseUtils);
    }
}
