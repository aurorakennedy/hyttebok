module hytte.ui {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;

    requires hytte.core;

    opens hytte.ui to javafx.graphics, javafx.fxml;
}
