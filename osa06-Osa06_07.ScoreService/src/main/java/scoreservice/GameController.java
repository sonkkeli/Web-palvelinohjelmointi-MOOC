package scoreservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* @author sonja */

@RestController
public class GameController {
    
    @Autowired
    private GameRepository gameRepo;
    
    @GetMapping("/games")
    public List<Game> getGames() {
        return gameRepo.findAll();
    }
    
    @GetMapping("/games/{name}")
    public Game getGame(@PathVariable String name) {        
        return gameRepo.findByName(name);
    }

    @DeleteMapping("/games/{name}")
    public Game deleteGame(@PathVariable String name) {
        Game game = gameRepo.findByName(name);
        gameRepo.deleteById(game.getId());
        return game;
    }

    @PostMapping("/games")
    public Game postGame(@RequestBody Game game) {
        return gameRepo.save(game);
    }    
}
