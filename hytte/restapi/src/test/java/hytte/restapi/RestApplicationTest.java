package hytte.restapi;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import org.hamcrest.Matchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RestApplicationTest {
    
    private HytteSave hytteSave;

    @Test
    public void moroTest () {
        try {
            assertEquals(1, 1);
        } catch (Exception e) {
            fail();
        }
    }

}
