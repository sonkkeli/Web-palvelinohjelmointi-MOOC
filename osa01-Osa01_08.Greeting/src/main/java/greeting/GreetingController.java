package greeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
    // http://localhost:8080/greet?greeting=Moro&name=Sonja
    @GetMapping("/greet")
    @ResponseBody
    public String greet(@RequestParam String name,
                         @RequestParam String greeting) {
        return greeting + ", " + name;
    }
}
