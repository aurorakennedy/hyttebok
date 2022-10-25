package hytte.ui;

import java.io.IOException;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class HytteController {

    //Nytt vindu for å kunne lese innlegg
    @FXML
    private Button seePreviousPostsButton; 

    @FXML
    private ScrollPane scrollPane; //brukes til å sende tidligere innlegg til pane

    @FXML
    void seePreviousPosts(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("previousPosts.fxml")); //lager en ny FXML loader som laster inn innholdet i previousPosts.fxml
            Parent root1 = (Parent) fxmlLoader.load(); //setter parent/rot til den nye filen previousPosts.html
            Stage stage = new Stage(); //lager nytt vindu
            stage.initStyle(StageStyle.TRANSPARENT); //setter vindu-lukke og minimerknappen til transparent
            stage.setTitle("Posts"); //setter tittelen til selve vinduet til "Posts"
            stage.setScene(new Scene(root1)); //lager ny scene i roten
            stage.show(); //viser nye vinduet
        } catch (Exception e){
            System.out.println("Can not load new window.");
        }
    }





    private PostList postList = new PostList();

    @FXML
    private TextField visitors; //importerer FXML-TextField-feltene

    @FXML
    private TextArea experience;

    @FXML
    private Button saveButton; //importerer FXML-button-feltene

    @FXML
    private DatePicker datePicker; //importerer FXML-datePicker-feltet

    public void initialize() {
        datePicker.setValue(LocalDate.now());
        //saveButton.setVisible(false);
        //previousPostsButton.setVisible(false);

        //Oppdaterer postList med tidligere innlegg i hytteboken
        HytteRead read = new HytteRead();
        if (read.read("hyttebok.json") != null) {
            postList = read.read("hyttebok.json");
        }
    }

    //metode som lager Alert-box med IllegalArgumentException som feilmelding
    private void alert(Exception e) {
        Alert feilmelding = new Alert(AlertType.ERROR); //lager ALERT-box
        feilmelding.setHeaderText(e.getMessage()); //setter header-teksten i Alert-boksen til å være IllegalArgumentExceptionen som ble utløst
        feilmelding.show(); //viser Alert-boksen
    }

    @FXML
    private void clickSave() throws IOException {
        try {
            Post post = new Post(visitors.getText(), experience.getText(), datePicker.getValue());
            postList.addPost(post);
            HytteSave save = new HytteSave();
            save.commitSave(postList, "hyttebok.json");
            visitors.clear();
            datePicker.setValue(LocalDate.now());
            experience.clear();
        } catch (Exception e) {
            alert(e);
        }
    }

    @FXML
    private void clickRead() {
        //TODO
        //make it possible to read previous posts
    }
}
