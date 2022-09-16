module gruppe08.hytte {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    opens gruppe08.hytte to javafx.graphics, javafx.fxml;
}
