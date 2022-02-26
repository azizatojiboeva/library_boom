package uz.elmurodov.spring_boot.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.project.ProjectCreateDto;
import uz.elmurodov.spring_boot.dto.project.ProjectUpdateDto;
import uz.elmurodov.spring_boot.services.project.ProjectColumnService;
import uz.elmurodov.spring_boot.services.project.ProjectMemberService;
import uz.elmurodov.spring_boot.services.project.ProjectServiceImpl;

@Controller
@RequestMapping("/project/*")
public class ProjectController extends AbstractController<ProjectServiceImpl> {
    private final ProjectMemberService projectMemberService;
    private final ProjectColumnService projectColumnService;

    @Autowired
    public ProjectController(ProjectServiceImpl service,
                             ProjectMemberService projectMemberService, ProjectColumnService projectColumnService) {
        super(service);
        this.projectMemberService = projectMemberService;
        this.projectColumnService = projectColumnService;
    }


    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "project/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProjectCreateDto dto) {
        service.create(dto);
        return "redirect:/";
    }

    @RequestMapping("detail/{id}/")
    public String detail(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", service.get(id));
//        model.addAttribute("columns", projectColumnService.getAllByProjectId(id));
        model.addAttribute("members", projectMemberService.getAllByProjectId(id));
        return "project/detail";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String listPage(Model projects) {


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
