package uz.elmurodov.spring_boot.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Axmadjonov Eliboy, Thu 2:56 PM,2/24/2022
 */

@Controller
@RequestMapping("/project/*")
public class ProjectController {


    @RequestMapping(value = "index" ,method = RequestMethod.GET)
    public  String indexPage(){
        return "index/index";
    }
    @RequestMapping(value = "project" ,method = RequestMethod.GET)
    public  String projectPage(){
        return "index/project";
    }
}
