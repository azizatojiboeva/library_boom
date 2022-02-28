package uz.elmurodov.spring_boot.controller.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.dto.comment.CommentUpdateDto;
import uz.elmurodov.spring_boot.services.comment.CommentServiceImpl;
import uz.elmurodov.spring_boot.utils.checks.BaseCheck;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/comment/*")
public class CommentController extends AbstractController<CommentServiceImpl> {

    private final BaseCheck check;

    public CommentController(CommentServiceImpl service, BaseCheck check) {
        super(service);
        this.check = check;
    }

    @RequestMapping(value = "create/{task_id}/", method = RequestMethod.GET)
    public String createPage() {
        if (!check.hasPermission("COMMENT_CREATE")) {
            return "error";
        }
        return "comment/create";
    }

    @RequestMapping(value = "create/{task_id}/", method = RequestMethod.POST)
    public String create(@ModelAttribute CommentCreateDto dto, @PathVariable(name = "task_id") Long id) {
        dto.setTaskId(id);
        service.create(dto);
        return "redirect:comment/list";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String commentList(@PathVariable(name = "task_id") Long id) {
        service.getAll(id);
        return "comment/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("dto", service.get(id));
        return "comment/update";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PATCH)
    public String update(@ModelAttribute CommentUpdateDto dto) {
        service.update(dto);
        return "comment/update";
    }


    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String deletePage(){
        return "comment/delete";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:comment/list";
    }


}
