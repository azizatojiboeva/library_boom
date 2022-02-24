package uz.elmurodov.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.services.task.TaskService;

import javax.swing.*;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskService> {


    public TaskController(TaskService service) {
        super(service);
    }


}
