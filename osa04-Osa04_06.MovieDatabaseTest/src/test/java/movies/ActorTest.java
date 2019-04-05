package movies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/* @author sonja */

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActorTest extends org.fluentlenium.adapter.junit.FluentTest {
    
    @LocalServerPort
    private Integer port;
    
    @Test
    public void actorTest() {        
        
        goTo("http://localhost:" + port + "/actors");

        assertFalse(pageSource().contains("Uuno Turhapuro"));

        find("#name").fill().with("Uuno Turhapuro");

        find("form").first().submit();

        assertTrue(pageSource().contains("Uuno Turhapuro"));
        
        find("input[value='Remove']").click();
        
        assertFalse(pageSource().contains("Uuno Turhapuro"));
    }
}
