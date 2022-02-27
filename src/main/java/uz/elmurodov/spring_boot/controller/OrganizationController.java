package uz.elmurodov.spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.organization.OrganizationCreateDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationDto;
import uz.elmurodov.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.elmurodov.spring_boot.services.organization.OrganizationService;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {


    @Autowired
    public OrganizationController(OrganizationService service) {
        super(service);
    }



    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "organization/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/home/";
    }


    @RequestMapping(value = "detail/{org_id}" , method = RequestMethod.GET)
    public String detailPage(@PathVariable(name = "org_id") Long id, Model model){
        OrganizationDto organizationDto = service.get(id);
        model.addAttribute("org",organizationDto);
        return "organization/detail";
    }


    @RequestMapping(value = "update/{org_id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "org_id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(  @PathVariable(name = "id") Long id,  @ModelAttribute OrganizationUpdateDto dto) {
        dto.setId(id);
        service.update(dto);
        return "redirect:/home/";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", service.get(id));
        return "organization/delete";
    }
    @RequestMapping(value = "delete/{id}" , method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/home/";
    }


}
