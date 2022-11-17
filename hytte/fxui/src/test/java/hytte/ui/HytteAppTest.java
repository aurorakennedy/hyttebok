package hytte.ui;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import hytte.core.Post;
import hytte.core.PostList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HytteAppTest extends ApplicationTest{
    
    private HytteController controller;
    private PostList postList;
    private Post post;

    @Override
    public void start(final Stage stage) throws Exception{
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("hytte.fxml"));
    final Parent root = loader.load();
    this.controller = loader.getController();
    stage.setScene(new Scene(root));
    stage.show();
    }

    @BeforeEach
    public void setupPostList() {
        post = new Post("Placeholder", "Placeholder", LocalDate.now());
        postList = new PostList();
        postList.addPost(post);
    }

    @Test
    public void testController() {
        assertNotNull(controller);
    }

    @Test
    public void visitor() {
      String newVisitor = "Aurora";
      String newExperience = "Vi koste oss masse på hytta<33";

      clickOn("#visitors").write(newVisitor);
      clickOn("#experience").write(newExperience);

      clickOn("#saveButton");

    }

    @Test
    public void readPreviousPost() {
        Post post1 = new Post("Klara", "Gikk lang tur i skogen! møtte på en elg", LocalDate.of(2022, 8, 15));
        Post post2 = new Post("Trym og Aksel", "Vi bada i fjellvann", LocalDate.of(2022, 5, 30));
        postList.addPost(post1);
        postList.addPost(post2);
        clickOn("#seePreviousPostsButton");
    }

}


 
   

    
