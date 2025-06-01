package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import main.Main;

public class TitleScreen {
    public static Scene getScene() {
        VBox root = new VBox();
        Label l = new Label("Theme Park Project");
        Button b = new Button("Start Game");
        b.setOnAction(e -> {
            Main.setScene(Map.getScene(640, 800));
        });
        root.setAlignment(javafx.geometry.Pos.CENTER);
        root.getChildren().addAll(l, b);
        return(new Scene(root, 640, 480));
    }
}
