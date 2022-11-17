package hytte.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import hytte.core.Post;
import hytte.core.PostList;

public class PreviousControllerTest {
    private PostList postList = new PostList();
    private Post post;
    private PreviousController previousController = new PreviousController();

    @Test
    public void testPrintPosts() {
        post = new Post("Ola", "Gikk på ski", LocalDate.now());
        post.setDateRead("17. nov. 2022");
        postList.addPost(post);
        assertEquals("Ola" + "\n" + "17. nov. 2022" + "\n" + "Gikk på ski" + "\n\n\n", previousController.printPosts(postList));
    }

/* 
    @Test
    public void isNull(){
        assertEquals(0,  postList.getPostList().size());
    }*/

    /*@Test
    public void isNotNull(){
        Post post1 = new Post("Helle", "Gøy med kort spill!", LocalDate.of(2022, 5, 30));
        //Post post2 = new Post("Karl", "Gikk Lang tur!", LocalDate.of(2022, 10, 4));
        
        postList.addPost(post1);
        //postList.addPost(post2);

        assertNotNull(postList);
    }

    @Test
    public void isEqual(){

        List<Post> testList = new ArrayList<>();
        Post post1 = new Post("Helle", "Gøy med kort spill!", LocalDate.of(2022, 5, 30));
        testList.add(post1);
        
        assertEquals(postList.getPostList(), testList);
    }*/
}