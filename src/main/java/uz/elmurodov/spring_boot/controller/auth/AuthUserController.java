package uz.elmurodov.spring_boot.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.auth.AuthUserCreateDto;
import uz.elmurodov.spring_boot.services.auth.AuthUserService;

@Controller
@RequestMapping("/user/*")
public class AuthUserController extends AbstractController<AuthUserService> {
    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @RequestMapping(value = "create/", method = RequestMethod.GET)
    public String createPage() {
        return "user/create";
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute AuthUserCreateDto dto) {
        service.create(dto);
        return "user/create";
    }

}