package pages;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Map {
    public static Scene getScene() {
        VBox root = new VBox();
        Image image = new Image("map.png", 1280, 960, false, false);
        // idk why but doubling it got rid of the smoothing
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(640);
        imageView.setFitHeight(480);
        root.getChildren().add(imageView);
        return new Scene(root, 640, 480);
    }
}