package hytte.restapi;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import org.hamcrest.Matchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.beans.Transient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestApplicationTest {
    
    private HytteSave hytteSave;
    private HytteRead hytteRead;
    private RestAppController restController;

    @BeforeEach
    public void setUp() {
        hytteSave = new HytteSave();
        hytteRead = new HytteRead();
        restController = new RestAppController();
    }

    @Test
    public void moroTest () {
        try {
            assertEquals(1, 1);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testAPI() {
        
    }

}
