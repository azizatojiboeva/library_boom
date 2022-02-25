package uz.elmurodov.spring_boot.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Axmadjonov Eliboy, Fri 1:10 AM,2/25/2022
 */
@Controller
@RequestMapping("/profil/*")
public class ProfilController {

    @RequestMapping(value = "profil", method = RequestMethod.GET)
    public String profilePage(){
        return "";
    }
}
