package hytte.ui;

import hytte.core.PostList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PreviousController {
    
    String postsFormatted;

    private PostList postList = new PostList();


    @FXML
    private Text postsText; //importerer tekstfeltet til plassering av innleggene 


    @FXML
    void printPosts(){
        postsText.setText("test");
         //Oppdaterer postList med tidligere innlegg i hytteboken
        HytteRead read = new HytteRead();
        if (read.read("hyttebok.json") != null) {
            postList = read.read("hyttebok.json");
        }
        postsText.setText("test");
        /*for (Post post : postList.getPostList()) {
            postsFormatted+=(post.postFormatted()+"\n\n");
        }*/
    }

}
