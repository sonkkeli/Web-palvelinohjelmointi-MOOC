
package jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sonja
 */

@Service
public class VoteService {    
    
    @Autowired
    private VoteRepository voteRepo;
    
    public Vote getVote(Long jokeId){
        
        if (voteRepo.findByJokeId(jokeId) == null) {
            Vote v = new Vote(jokeId, 0, 0);
            voteRepo.save(v);
        }
        
        return voteRepo.findByJokeId(jokeId);
    }
    
    public void handleVoting(Vote vote, String value){
        if ("up".equals(value)) {
            vote.setUpVotes(vote.getUpVotes() + 1);
        } else if ("down".equals(value)) {
            vote.setDownVotes(vote.getDownVotes() + 1);
        }
        voteRepo.save(vote);
    }
}
