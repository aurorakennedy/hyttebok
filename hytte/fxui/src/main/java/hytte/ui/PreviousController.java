package hytte.ui;

import java.time.LocalDate;

import hytte.core.Post;
import hytte.core.PostList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PreviousController {
    

    @FXML
    private Text postsText; //importerer tekstfeltet til plassering av innleggene 
    @FXML
    private Text scrollPane; //importerer tekstfeltet til plassering av innleggene 



    @FXML
    public void printPosts(){

        Post post1 = new Post("Klara og Aurora", "Grillet, gikk turer og så på Love is Blind. Kost oss masse!", LocalDate.now());
        Post post2 = new Post("Aksel Trym og mamma", "Spilt playstation og drukket vin. Elsker hytta<3", LocalDate.now());
        PostList postList1 = new PostList();
        postList1.addPost(post1);
        postList1.addPost(post2);

        String postFormatted = "";
        String postsFormatted = "";

        for (Post post : postList1.getPostList()) {
            postFormatted = post.getName() + "\n" + post.getDate() + "\n" + post.getContent() + "\n\n\n";
            postsFormatted+=postFormatted;
        }

        postsText.setText(postsFormatted);


    }

}
