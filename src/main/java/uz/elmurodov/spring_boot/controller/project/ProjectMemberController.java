package uz.elmurodov.spring_boot.controller.project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.project.ProjectMemberCreateDto;
import uz.elmurodov.spring_boot.services.project.ProjectMemberServiceImpl;

@Controller
@RequestMapping("/projectMember/*")
public class ProjectMemberController extends AbstractController<ProjectMemberServiceImpl> {

    @Autowired
    public ProjectMemberController(ProjectMemberServiceImpl service) {
        super(service);
    }

    @RequestMapping(value = "addMember/{user_id}/{project_id}", method = RequestMethod.GET)
    @ResponseBody
    public String addMember(@PathVariable(name = "user_id") String id , @PathVariable(name = "project_id") Long project_id){
        ProjectMemberCreateDto dto=new ProjectMemberCreateDto(project_id,Long.valueOf(id));
       service.create(dto);
       return "";
    }


}
