package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.services.auth.AuthUserServiceImpl;
import uz.elmurodov.spring_boot.services.organization.OrganizationService;
import uz.elmurodov.spring_boot.services.project.ProjectService;

@Controller
@RequestMapping("/home/*")
public class HomeController {

    protected final AuthUserServiceImpl service;
    protected final OrganizationService organizationService;
    protected final ProjectService projectService;
    private final AuditAwareImpl auditAware;

    public HomeController(AuthUserServiceImpl service, OrganizationService organizationService, ProjectService projectService, AuditAwareImpl auditAware) {
        this.service = service;
        this.organizationService = organizationService;
        this.projectService = projectService;
        this.auditAware = auditAware;
    }

    @RequestMapping(value = "")
    public String listsPage(Model model) {
        if ("SUPER_ADMIN".equals(auditAware.getCredentials().getRole().getCode())) {
            model.addAttribute("organizations", organizationService.getAll(7L));
            return "index/index";
        }
        if ("ADMIN".equals(auditAware.getCredentials().getRole().getCode())) {
            model.addAttribute("projects", projectService.getAll(auditAware.getCredentials().getOrganizationId().getId()));
            return "index/index2";
        }
        return "index/index";
    }
}
