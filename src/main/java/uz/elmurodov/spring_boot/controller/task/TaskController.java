package uz.elmurodov.spring_boot.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.task.TaskCreateDto;
import uz.elmurodov.spring_boot.dto.task.TaskDto;
import uz.elmurodov.spring_boot.services.comment.CommentServiceImpl;
import uz.elmurodov.spring_boot.services.task.TaskMemberServiceImpl;
import uz.elmurodov.spring_boot.services.task.TaskServiceImpl;
import uz.elmurodov.spring_boot.utils.checks.BaseCheck;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Axmadjonov Eliboy, Thu 3:36 PM,2/24/2022
 */
@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskServiceImpl> {

    private final BaseCheck check;
    private final TaskMemberServiceImpl taskMemberService;
    private final CommentServiceImpl commentService;

    @Autowired
    public TaskController(TaskServiceImpl taskService, BaseCheck check,
                          TaskMemberServiceImpl taskMemberService,
                          CommentServiceImpl commentService) {
        super(taskService);
        this.check = check;
        this.taskMemberService = taskMemberService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "task")
    public String list(){
        return "index/task";
    }
    @RequestMapping(value = "/{column_id}", method = RequestMethod.GET)
    public String taskList(@PathVariable(name = "column_id") Long column_id, Model model) {
        List<TaskDto> tasks = service.getAll(column_id);
        tasks.forEach(taskDto -> taskDto.setMemberDtos(taskMemberService.getAll(taskDto.getId())));
        tasks.forEach(taskDto -> taskDto.setCommentDtos(commentService.getAll(taskDto.getId())));
        model.addAttribute("tasks",tasks);
        return "index/index3";
    }

    @RequestMapping(value = "create/{project_id}/", method = RequestMethod.GET)
    public String createPage() {
       /* if (!check.hasPermission("TASK_CREATE")) {
            return "error";
        }*/
        return "task/create";
    }

    @RequestMapping(value = "create/{project_id}", method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCreateDto dto, @PathVariable(name = "project_id") Long id,
                         @RequestParam(name = "finishDate") String date, HttpServletRequest request) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime deadline = LocalDateTime.parse(date, format);
        dto.setDeadline(deadline);
        dto.setProjectId(id);
        service.create(dto);
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "delete/{task_id}/", method = RequestMethod.GET)
    public String deletePage(@PathVariable(name = "task_id") Long id, Model model){
        model.addAttribute(service.get(id));
        return "task/delete";
    }

    @RequestMapping(value = "delete/{task_id}/", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "task_id") Long id){
        service.delete(id);
        return "redirect:task/list";
    }

    @RequestMapping(value = "changePriority/{task_id}/", method = RequestMethod.POST)
    public String changePriority(String priority, @PathVariable(name = "task_id") Long id){
        service.changePriority(id, priority);
        return "redirect:task/list";
    }

    @RequestMapping(value = "changeLevel/{task_id}/", method = RequestMethod.POST)
    public String changeLevel(@RequestParam(name = "level") String level, @PathVariable(name = "task_id") Long id){
        service.changeLevel(id, level);
        return "redirect:task/list";
    }







}
