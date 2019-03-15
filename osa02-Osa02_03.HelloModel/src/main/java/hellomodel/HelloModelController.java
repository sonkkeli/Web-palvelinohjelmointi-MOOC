package hellomodel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloModelController {
    
    /*
    http://localhost:8080/?title=Ota%20Tai%20Jata&person=Sonja 
    */
    
    @GetMapping("/")
    public String home(@RequestParam String title, 
            @RequestParam String person, 
            Model model){
        
        model.addAttribute("person", person);
        model.addAttribute("title", title);
        return "index";
    }
}
