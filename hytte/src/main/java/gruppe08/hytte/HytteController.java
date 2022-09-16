package gruppe08.hytte;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;


public class HytteController {

    PostList postList = new PostList();
    

    @FXML
    private TextField visitors; //importerer FXML-TextField-feltene

    @FXML
    private TextArea experience;

    @FXML
    private Button saveButton, previousPostsButton; //importerer FXML-button-feltene

    @FXML
    private DatePicker datePicker; //importerer FXML-datePicker-feltet

    public void initialize(){
        datePicker.setValue(LocalDate.now());
        //saveButton.setVisible(false);
        //previousPostsButton.setVisible(false);
    }

    //metode som lager Alert-box med IllegalArgumentException som feilmelding
    private void alert(Exception e){
        Alert feilmelding = new Alert(AlertType.ERROR); //lager ALERT-box
        feilmelding.setHeaderText(e.getMessage()); //setter header-teksten i Alert-boksen til å være IllegalArgumentExceptionen som ble utløst
        feilmelding.show(); //viser Alert-boksen
    }

    @FXML
    private void clickSave() throws IOException{
        try {
            Post post = new Post(visitors.getText(), experience.getText(), datePicker.getValue());
            postList.addPost(post);
            //Save info in JSON file
            JSONObject obj = new JSONObject();
            obj.put("name", visitors.getText());
            obj.put("experience", experience.getText());
            obj.put("date", datePicker.getValue());

            String filePath = ("hyttebok.json");

            try (FileWriter writer = new FileWriter(filePath, true)) {
                BufferedWriter buffed = new BufferedWriter(writer);
                buffed.write(obj.toString());
                buffed.newLine();
                buffed.close();
            }

            visitors.clear();
            datePicker.setValue(LocalDate.now());
            experience.clear();
        } catch (Exception e) {
            alert(e);
        }
    }

    @FXML
    private void clickRead(){
        //TODO
        //make it possible to read previous posts 
    }



}