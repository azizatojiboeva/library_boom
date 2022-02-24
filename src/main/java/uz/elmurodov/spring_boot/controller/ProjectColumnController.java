package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.services.project.ProjectColumnService;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/projectColumn/*")
public class ProjectColumnController extends AbstractController<ProjectColumnService> {


    public ProjectColumnController(ProjectColumnService service) {
        super(service);
    }
}
