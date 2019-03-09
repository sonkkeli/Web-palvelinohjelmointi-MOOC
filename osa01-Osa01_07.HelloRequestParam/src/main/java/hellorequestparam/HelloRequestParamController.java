package hellorequestparam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloRequestParamController {
    // selaimessa esim http://localhost:8080/hello?param=Sonja
    // tulostuu Hello Sonja
    @GetMapping("/hello")
        @ResponseBody
        public String tervehdi(@RequestParam String param) {
            return "Hello " + param;
        }
}
