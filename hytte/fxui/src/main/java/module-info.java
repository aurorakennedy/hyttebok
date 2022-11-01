module hytte.ui {

    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;

    requires transitive hytte.core;
    exports hytte.ui;

    opens hytte.ui to javafx.graphics, javafx.fxml;
}
