package airports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;
    @Autowired
    private AirportRepository airportRepository;

    @GetMapping("/aircrafts")
    public String list(Model model) {
        model.addAttribute("aircrafts", aircraftRepository.findAll());
        model.addAttribute("airports", airportRepository.findAll());

        return "aircrafts";
    }

    @PostMapping("/aircrafts")
    public String create(@RequestParam String name) {
        Aircraft a = new Aircraft();
        a.setName(name);
        
        aircraftRepository.save(a);
        return "redirect:/aircrafts";
    }
    
    @PostMapping("/aircrafts/{aircraftId}/airports")
    public String assignAirport(
            @RequestParam Long airportId, @PathVariable Long aircraftId){
        // hae pyynnössä saatuja tunnuksia käyttäen lentokone ja lentokenttä
        Aircraft ac = aircraftRepository.getOne(aircraftId);
        Airport ap = airportRepository.getOne(airportId);
        
        // aseta lentokoneelle lentokenttä ja lentokentälle lentokone
        ac.setAirport(ap);
        ap.getAircrafts().add(ac);
        
        // tallenna lentokone
        airportRepository.save(ap);
        return "redirect:/aircrafts";
    }

}
