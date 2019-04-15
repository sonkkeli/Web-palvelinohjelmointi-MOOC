package reservations;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class DefaultController {
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void init() {
        Account testAccount = new Account();
        String username = "maxwell_smart";
        String password = "kenkapuhelin";
        testAccount.setUsername(username);
        testAccount.setPassword(passwordEncoder.encode(password));
        
        Account foundAccount = accountRepository.findByUsername(username);
        if (foundAccount == null) {
            accountRepository.save(testAccount);
        }
    }

    @GetMapping("*")
    public String handleDefault() {
        return "redirect:/reservations";
    }
}
