package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index/*")
public class HomeController {

    @RequestMapping(value = {"index"}, method = RequestMethod.GET)
    public String homePage() {
        return "index/index";
    }
}
