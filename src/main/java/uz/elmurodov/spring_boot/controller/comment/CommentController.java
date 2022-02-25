package uz.elmurodov.spring_boot.controller.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.dto.comment.CommentCreateDto;
import uz.elmurodov.spring_boot.services.comment.CommentService;

/**
 * @Author Aziza Tojiboyeva
 */
@Controller
@RequestMapping("/comment/*")
public class CommentController extends AbstractController<CommentService> {


    public CommentController(CommentService service) {
        super(service);
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(){
        return "create";
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public String create(@ModelAttribute CommentCreateDto dto){
        return null;
    }


}
