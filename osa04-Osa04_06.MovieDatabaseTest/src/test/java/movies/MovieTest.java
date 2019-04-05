package movies;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/* @author sonja */

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieTest extends org.fluentlenium.adapter.junit.FluentTest {
    @LocalServerPort
    private Integer port;
    
    @Test
    public void movieTest() {        
        
        goTo("http://localhost:" + port + "/movies");

        assertFalse(pageSource().contains("Uuno Epsanjassa"));
        assertFalse(pageSource().contains("Uuno Turhapuro"));

        find("#name").fill().with("Uuno Epsanjassa");
        find("#lengthInMinutes").fill().with("92");

        find("form").first().submit();

        assertTrue(pageSource().contains("Uuno Epsanjassa"));
        assertFalse(pageSource().contains("Uuno Turhapuro"));
        
        goTo("http://localhost:" + port + "/actors");
        assertFalse(pageSource().contains("Uuno Turhapuro"));
        
        find("#name").fill().with("Uuno Turhapuro");
        
        find("form").first().submit();
        
        assertTrue(pageSource().contains("Uuno Turhapuro"));
        
        goTo("http://localhost:" + port + "/actors/1");
        // find("a[th:text='Uuno Turhapuro']").click();
                
        find("input[id='add-to-movie']").click();
        
        goTo("http://localhost:" + port + "/movies");
        
        assertTrue(pageSource().contains("Uuno Epsanjassa"));
        assertTrue(pageSource().contains("Uuno Turhapuro"));
    }
}
