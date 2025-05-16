package pages;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Map {
    public static Scene getScene() {
        return new Scene(new VBox(), 640, 480);
    }
}