package uz.elmurodov.spring_boot.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.project.ProjectColumnCreateDto;
import uz.elmurodov.spring_boot.services.project.ProjectColumnService;

@Controller
@RequestMapping("/column/*")
public class ProjectColumnController extends AbstractController<ProjectColumnService> {

    @Autowired
    public ProjectColumnController(ProjectColumnService service) {
        super(service);
    }


    @RequestMapping(value = "create" ,method = RequestMethod.GET)
    public String columnPage(){
        return "column/create";
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String columnCreate(@ModelAttribute ProjectColumnCreateDto dto){
        service.create(dto);
        return "redirect:/home/";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String getAll(){
        return "";

    }
}
