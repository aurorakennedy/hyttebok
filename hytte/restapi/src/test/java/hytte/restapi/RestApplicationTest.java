package hytte.restapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@WebMvcTest
public class RestApplicationTest {
    
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RestApplication restApp;
    
    @Test
    public void testApplication() {
        assertNotNull(mockMvc);
        assertNotNull(restApp);
    }

}
