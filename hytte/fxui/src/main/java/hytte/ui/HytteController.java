package hytte.ui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;

import hytte.core.Post;
import hytte.core.PostList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class HytteController {

    private PostList postList = new PostList();

    private HytteRequests requester = new HytteRequests();

    //input-fields
    @FXML
    private DatePicker datePicker; //importerer FXML-datePicker-feltet

    @FXML
    private TextField visitors; //importerer FXML-TextField-feltene

    @FXML
    private TextArea experience;


    //button-fields
    @FXML
    private Button saveButton;

    @FXML
    private Button seePreviousPostsButton;



    public void initialize() {
        datePicker.setValue(LocalDate.now());
        getPosts();
    }

    /**
     * Sends a GET-request to Spring Boot server, using HytteRequests.
     * Updates postList with server response.
     */
    private void getPosts() {
        try {
            PostList getPostList = requester.getRequest();  //Oppdaterer postList med tidligere innlegg fra rest-serveren
            if (getPostList != null) { //Oppdaterer kun hvis det er tidligere innlegg
                this.postList = getPostList;
            }

        } catch (Exception e) {
            Exception e2 = new Exception("Unable to retrieve PostList from server. Probably not running.", e);
            alert(e2);
        }
    }

    /**
     * Opens an Alert-box with IllegalArgumentException as error.
     * @param e Exception to inform user about.
     */
    private void alert(Exception e) {
        Alert feilmelding = new Alert(AlertType.ERROR); //lager ALERT-box
        feilmelding.setHeaderText(e.getMessage()); //setter header-teksten i Alert-boksen til å være IllegalArgumentExceptionen som ble utløst
        feilmelding.show(); //viser Alert-boksen
    }


    /**
     * Sends the updated postList to Spring Boot server, using HytteRequests.
     */
    @FXML
    private void clickSave() {
        try {
            Post post = new Post(visitors.getText(), experience.getText(), datePicker.getValue());
            postList.addPost(post);
            requester.postRequest(postList); //sender oppdatert PostList til rest-serveren
            visitors.clear();
            datePicker.setValue(LocalDate.now());
            experience.clear();
        } catch (Exception e) {
            Exception e1 = new Exception("Unable to post to server. Probably not running.", e);
            alert(e1);
        }
    }



    /**
     * Opens new window with previous posts from the HytteBok. Uses getPosts() to retrieve them.
     * @param event The click that executed the method.
     * @throws URISyntaxException
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    void openWindow(ActionEvent event) throws URISyntaxException, IOException, InterruptedException {
        //lager og åpner et nytt vindu

        getPosts();
        if (postList.getPostList().size() == 0) {
            alert(new IllegalArgumentException("There are no previous posts"));
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("previousPosts.fxml")); //lager en ny FXML loader som laster inn innholdet i previousPosts.fxml
                Parent root1 = (Parent) fxmlLoader.load(); //setter parent/rot til den nye filen previousPosts.html
                PreviousController previousController = fxmlLoader.getController(); //kobler sammen det nye vinduet med en egen kontroller
                Stage stage = new Stage(); //lager nytt vindu
                stage.setTitle("Posts"); //setter tittelen til selve vinduet til "Posts"
                stage.setScene(new Scene(root1)); //lager ny scene i roten
                stage.show(); //viser nye vinduet

                //kaller på metode i kontroller i andre vinduet
                previousController.printPosts(postList);

            } catch (Exception e) {
                alert(e);
            }
        }
    }

}
