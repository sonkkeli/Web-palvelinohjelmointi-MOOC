package examsandquestions;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository quRepo;

    @GetMapping("/questions")
    public String list(Model model) {
        model.addAttribute("questions", quRepo.findAll());
        return "questions";
    }
    
    @PostMapping("/questions")
    public String addQuestion(@RequestParam String title, @RequestParam String content) {
        Question q = new Question();
        q.setContent(content);
        q.setTitle(title);
        quRepo.save(q);
        return "redirect:/questions";
    }
}
