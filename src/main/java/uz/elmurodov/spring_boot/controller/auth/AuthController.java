package uz.elmurodov.spring_boot.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Axmadjonov Eliboy, Wed 7:56 PM,2/23/2022
 */
@Controller
@RequestMapping("/auth/*")
public class AuthController {
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "auth/login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logoutPage() {
        return "auth/logout";
    }


    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerPage() {
        return "auth/register";
    }

    @RequestMapping(value = "basic", method = RequestMethod.GET)
    public String indexPage() {
        return "index/index";
    }
}
