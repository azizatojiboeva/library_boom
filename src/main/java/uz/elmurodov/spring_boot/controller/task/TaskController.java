package uz.elmurodov.spring_boot.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.config.annotations.HasAdminRole;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.services.task.TaskService;


/**
 * @author Axmadjonov Eliboy, Thu 3:36 PM,2/24/2022
 */

@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService> {

    private final AuditAwareImpl auditAware;


    @Autowired
    public TaskController(AuditAwareImpl auditAware, TaskService taskService) {
        super(taskService);
        this.auditAware = auditAware;
    }

    @RequestMapping(value = "list" , method = RequestMethod.GET)
    public String taskPage(@PathVariable(name = "column_id") Long id){

        return "index/index3";
    }








}
