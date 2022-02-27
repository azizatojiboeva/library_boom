package uz.elmurodov.spring_boot.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.auth.AuthUserCreateDto;
import uz.elmurodov.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.elmurodov.spring_boot.services.auth.AuthUserService;

@Controller
@RequestMapping("/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {
    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "auth/register";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute AuthUserCreateDto dto) {
        service.create(dto);
        return "redirect:/index/index";
    }

    @RequestMapping("detail/{id}/")
    public String detail(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("user", service.get(id));
        return "user/detail";
    }

    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("users", service.getAll(1L));
        return "auth/users";
    }
    @RequestMapping(value = "users/{organization_id}", method = RequestMethod.GET)
    public String listPage(@PathVariable(name = "organization_id")Long id, Model model) {
        model.addAttribute("users", service.getAll(id));
        return "auth/users";
    }


    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "user/update";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.PATCH)
    public String update(@ModelAttribute AuthUserUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deletePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("user", service.get(id));
        return "user/delete";
    }



}
