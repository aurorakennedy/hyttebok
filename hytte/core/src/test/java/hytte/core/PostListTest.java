package hytte.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostListTest {
    
//private PostList postList;
PostList postList = new PostList(); 

private List<Post> testListe = new ArrayList<Post>();

//private List<Post> postListTest = new ArrayList<Post>();

@BeforeEach
private void creatPostList(){
    Post post1 = new Post("Trude", "Vakker dag på hytta med sol og blå himmel", LocalDate.of(2022, 8, 15));
    Post post2 = new Post("Reidar ", "Nådde nye høyder, og var på Galdepiggen idag", LocalDate.of(2010, 4, 11));
    Post post3 = new Post("Guro", "Masse regn denne turen så ble mye kortspill", LocalDate.of(2022, 11, 3));

    // Legger til post i listen i postList
    postList.addPost(post1);
    postList.addPost(post2);
    postList.addPost(post3);

    // Legger til posts i liseten testListe 
    testListe.add(post1);
    testListe.add(post2);
    testListe.add(post3);

}



@Test
public void test(){
    // Sjekker at listen i utgangspunkte har riktig antall element
    Assertions.assertEquals(3, ((List<Post>) postList.getPostList()).size());

    // Ny post
    Post post4 = new Post("Sandra", "Masse regn denne turen så ble mye kortspill", LocalDate.of(2021, 9, 25));
    
    // Sjekker at man kan adde post til liste 
    postList.addPost(post4);
    Assertions.assertEquals(4, postList.getPostList().size());

    // Sjekker at man kan fjerne en post 
    postList.removePost(post4);
    Assertions.assertEquals(3, ((List<Post>) postList.getPostList()).size());


    //Sjekker at postList er lik testlisten vår
    Assertions.assertEquals(postList.getPostList(), testListe); 

    }
}
