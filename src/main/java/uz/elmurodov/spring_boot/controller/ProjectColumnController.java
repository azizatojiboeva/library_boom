package uz.elmurodov.spring_boot.controller;

import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.services.project.ProjectColumnService;

/**
 * @Author Aziza Tojiboyeva
 */
public class ProjectColumnController extends AbstractController<ProjectColumnService> {


    public ProjectColumnController(ProjectColumnService service) {
        super(service);
    }
}
