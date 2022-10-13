package hytte.core;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class postTest {

    private Post post; 

    @BeforeEach
    // Lager en post, slik at vi kan teste at post fungerer som den skal 
    public void creatPost(){
        post = new Post("Knut", "Hei, dette er en test. Håper den funker.", LocalDate.of(2000, 11, 4)); 
    }
    
    @Test
    public void testConstructer(){
        // Sjekker om verdiene er det vi forventer 
        Assertions.assertEquals("Knut", post.getName());
        Assertions.assertEquals("Hei, dette er en test. Håper den funker.", post.getContent());
        //Assertions.assertEquals("4. nov. 2000", post.getDate()); //Denne linja fungerer ikke i gitpod, da gitpod bruker amerikansk format


        // --- Navn ---
        //Sjekker at navn ikke kan innholde tall 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Post("Klara4", "Heihei", LocalDate.of(2000, 11, 4));  
		});
        //Sjekker at navn ikke kan inneholde special characters 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Post("Trym/Aksel", "Tigergutt", LocalDate.of(2000, 11, 4)); 
		});
    }
}
