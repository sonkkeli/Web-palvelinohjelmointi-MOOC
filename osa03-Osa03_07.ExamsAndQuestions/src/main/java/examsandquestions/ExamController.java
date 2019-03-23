package examsandquestions;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {
    @Autowired
    private ExamRepository exRepo;
    @Autowired
    private QuestionRepository quRepo;

    @GetMapping("/exams")
    public String listExams(Model model) {
        model.addAttribute("exams", exRepo.findAll(Sort.by("examDate").descending()));        
        return "exams";
    }

    @GetMapping("/exams/{id}")
    public String viewExam(Model model, @PathVariable Long id) {
        model.addAttribute("exam", exRepo.getOne(id));
        model.addAttribute("questions", quRepo.findAll());
        return "exam";
    }

    @PostMapping("/exams")
    public String addExam(@RequestParam String subject,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate examDate) {
        Exam e = new Exam();
        e.setExamDate(examDate);
        e.setSubject(subject);
        exRepo.save(e);
        return "redirect:/exams";
    }

    @PostMapping("/exams/{examId}/questions/{questionId}")
    @Transactional
    public String addQuestionToExam(@PathVariable Long examId, @PathVariable Long questionId) {
        Exam e = exRepo.getOne(examId);
        Question q = quRepo.getOne(questionId);
        q.getExams().add(e);
        e.getQuestions().add(q);
        
        return "redirect:/exams/" + examId;
    }
}
