package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.services.project.ProjectService;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectService> {

    public ProjectController(ProjectService service) {
        super(service);
    }


}
