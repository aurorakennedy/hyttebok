package hytte.ui;

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
    public String printPosts(PostList postList) {

        String postFormatted = "";
        String postsFormatted = "";

        for (Post post : postList.getPostList()) {
            postFormatted = post.getName() + "\n" + post.getDate() + "\n" + post.getContent() + "\n\n\n";
            postsFormatted += postFormatted;
        }

        if (postsText != null) {
            postsText.setText(postsFormatted);
        }
        return postsFormatted;
    }
}
