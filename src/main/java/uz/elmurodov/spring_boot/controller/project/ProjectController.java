package uz.elmurodov.spring_boot.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.services.auth.AuthUserServiceImpl;
import uz.elmurodov.spring_boot.services.project.ProjectColumnService;
import uz.elmurodov.spring_boot.services.project.ProjectMemberService;
import uz.elmurodov.spring_boot.services.project.ProjectServiceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectServiceImpl> {
    private final ProjectMemberService projectMemberService;
    private final ProjectColumnService projectColumnService;
    private final AuthUserServiceImpl userService;

    @Autowired
    public ProjectController(ProjectServiceImpl service,
                             ProjectMemberService projectMemberService, ProjectColumnService projectColumnService, AuthUserServiceImpl userService) {
        super(service);
        this.projectMemberService = projectMemberService;
        this.projectColumnService = projectColumnService;
        this.userService = userService;
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "project/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectCreateDto dto, @RequestParam(name = "deadline") String deadline) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date = LocalDateTime.parse(deadline, format);
        dto.setFinishDate(date);
        service.create(dto);
        return "redirect:/home/";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexPage() {
        return "index/index";
    }

    @RequestMapping("detail/{id}")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
        model.addAttribute("columns", projectColumnService.getAll(id));
        model.addAttribute("members", projectMemberService.getAllByProjectId(id));
        model.addAttribute("users",userService.getAll(service.get(id).getOrganizationId()));
        return "index/project";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage() {
        return "project/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("dto", service.get(id));
        return "project/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PATCH)
    public String update(@ModelAttribute ProjectUpdateDto dto) {
        service.update(dto);
        return "project/update";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("dto", service.get(id));
        return "project/delete";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "project/delete";
    }
}
