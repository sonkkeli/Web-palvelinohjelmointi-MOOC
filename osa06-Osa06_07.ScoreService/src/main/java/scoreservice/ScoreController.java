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
public class ScoreController {
    
    @Autowired
    private GameRepository gameRepo;
    
    @Autowired
    private ScoreRepository scoreRepo;
    
    @PostMapping("/games/{name}/scores")
    public Score postScore(@RequestBody Score score, @PathVariable String name) {
        Game g = gameRepo.findByName(name);
        score.setGame(g);
        return scoreRepo.save(score);
    } 
    
    @GetMapping("/games/{name}/scores")
    public List<Score> getScores(@PathVariable String name) {
        return scoreRepo.findByGame(gameRepo.findByName(name));
    }
    
    @GetMapping("/games/{name}/scores/{id}")
    public Score getScore(@PathVariable String name, @PathVariable Long id) {    
        return scoreRepo.findByGameAndId(gameRepo.findByName(name), id);
    }

    @DeleteMapping("/games/{name}/scores/{id}")
    public Score deleteScore(@PathVariable String name, @PathVariable Long id) {
        Score score = scoreRepo.findByGameAndId(gameRepo.findByName(name), id);
        scoreRepo.delete(score);
        return score;
    }      
}
