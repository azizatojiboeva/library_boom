package uz.elmurodov.spring_boot.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.services.task.TaskMemberService;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/task/member/*")
public class TaskMemberController extends AbstractController<TaskMemberService> {

    @Autowired
    public TaskMemberController(TaskMemberService service) {
        super(service);
    }
}
