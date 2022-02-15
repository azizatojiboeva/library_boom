package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.services.organization.OrganizationService;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {


    protected OrganizationController(OrganizationService service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/";
    }


    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String deletePage(@PathVariable Long id) {
        return "organization/delete";
    }

    @RequestMapping(value = "delete/", method = RequestMethod.DELETE)
    public String delete() {
        return "redirect:/";
    }


    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(@PathVariable Long id) {
        return "organization/update";
    }

    @RequestMapping(value = "update/", method = RequestMethod.PATCH)
    public String update() {
        return "redirect:/";
    }

    @RequestMapping("detail/{id}/")
    public String detail(@PathVariable Long id) {
        return "organization/detail";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll());
        return "organization/list";
    }
}