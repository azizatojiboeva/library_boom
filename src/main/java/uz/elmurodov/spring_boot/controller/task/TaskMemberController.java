package uz.elmurodov.spring_boot.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.auth.AuthUserDto;
import uz.elmurodov.spring_boot.dto.task.TaskMemberDto;
import uz.elmurodov.spring_boot.services.auth.AuthUserServiceImpl;
import uz.elmurodov.spring_boot.services.comment.CommentServiceImpl;
import uz.elmurodov.spring_boot.services.task.TaskMemberServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/task/member/*")
public class TaskMemberController extends AbstractController<TaskMemberServiceImpl> {
    private final AuthUserServiceImpl authUserService;
    private final CommentServiceImpl commentService;

    @Autowired
    public TaskMemberController(TaskMemberServiceImpl service, AuthUserServiceImpl authUserService, CommentServiceImpl commentService) {
        super(service);
        this.authUserService = authUserService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "list/{task_id}", method = RequestMethod.GET)
    public String list(@PathVariable(name = "task_id") Long id, Model model){
        List<AuthUserDto> taskMembers=new ArrayList<>();
        List<TaskMemberDto> all = service.getAll(id);
        all.forEach(taskMemberDto -> taskMembers.add(authUserService.get(taskMemberDto.getUser_id())));
        model.addAttribute("taskMembers",taskMembers);
        return "index";
    }

    @RequestMapping(value = "addTaskMember", method = RequestMethod.GET)
    public String becomeParticipant(@PathVariable(name = "task_id") Long id){
        return  null;
    }


}
