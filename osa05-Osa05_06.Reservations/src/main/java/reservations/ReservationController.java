package reservations;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/reservations")
    public String view(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }
    
    @PostMapping("/reservations")
    public String addReservation(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationFrom,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationTo) {
        
        List<Reservation> ress = reservationRepository.findAll();
        System.out.println(ress);
        
        boolean booked = false; 
        
        for (Reservation r : ress){
            // jos ei toteuta ehtoa että molemmat jälkeen tai molemmat ennen -> 
            // on niiden välissä eli jonkun tilauksen päällä
            if (!(( reservationFrom.isAfter(r.getReservationTo()) && 
                    reservationTo.isAfter(r.getReservationTo()) ) ||  
                    ( reservationFrom.isBefore(r.getReservationTo()) && 
                    reservationTo.isBefore(r.getReservationTo())) ) ){
                booked = true;
            }

        }
        if (! booked){
            Reservation res = new Reservation();
            res.setReservationFrom(reservationFrom);
            res.setReservationTo(reservationTo);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String username = auth.getName();
            res.setUser(accountRepository.findByUsername(username));
            reservationRepository.save(res);
        }
        
        return "redirect:/reservations";
    }
}
