package calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @GetMapping("/add")
    @ResponseBody
    public String add(@RequestParam Integer first, 
            @RequestParam Integer second) {
        int tulos = first+second;
        return "" + tulos;
    }
    
    @GetMapping("/multiply")
    @ResponseBody
    public String multiply(@RequestParam Integer first, 
            @RequestParam Integer second) {
        int tulos = first*second;
        return "" + tulos;
    }
}
