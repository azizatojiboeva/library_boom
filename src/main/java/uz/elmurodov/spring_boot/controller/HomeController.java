package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.services.auth.AuthUserServiceImpl;
import uz.elmurodov.spring_boot.services.organization.OrganizationService;
import uz.elmurodov.spring_boot.services.project.ProjectService;

@Controller
@RequestMapping("/home/*")
public class HomeController {

    protected final AuthUserServiceImpl service;
    protected final OrganizationService organizationService;
    protected final ProjectService projectService;

    public HomeController(AuthUserServiceImpl service, OrganizationService organizationService, ProjectService projectService) {
        this.service = service;
        this.organizationService = organizationService;
        this.projectService = projectService;
    }

    @RequestMapping(value = "")
    public String listsPage(Model model) {
        model.addAttribute("organizations", organizationService.getAll(new GenericCriteria()));
        return "index/index";
    }
}
