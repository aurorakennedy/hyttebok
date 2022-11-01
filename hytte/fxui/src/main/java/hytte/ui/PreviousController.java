package hytte.ui;

import java.time.LocalDate;

import hytte.core.Post;
import hytte.core.PostList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PreviousController {
    
    

    private Post post; 


    @FXML
    private Text postsText; //importerer tekstfeltet til plassering av innleggene 


    @FXML
    public void printPosts(){

        Post post1 = new Post("Klara", "Grilla", LocalDate.now());
        Post post2 = new Post("Aurora", "Drakk seg møkings", LocalDate.now());
        PostList postList1 = new PostList();
        postList1.addPost(post1);
        postList1.addPost(post2);

        System.out.println(postList1.getPostList().get(0).getName());

        String posts = "";

        for (Post post : postList1.getPostList()) {
            String addPost = post.postFormatted();
            posts = posts + addPost + "\n\n";
        }
        
        postsText.setText(posts);
    }

}
