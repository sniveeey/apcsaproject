package pages;

import java.util.HashSet;
import java.util.Set;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class Map {
    public static Scene getScene() {
        Pane root = new Pane();
        Image image = new Image("map.png", 1280, 960, false, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(960);
        root.getChildren().add(imageView);

        ImageView alex = new ImageView(new Image("alex.png", 12, 20, false, false));
        alex.setFitWidth(12);
        alex.setFitHeight(20);
        alex.setLayoutX(640); // Start at the center of the screen
        alex.setLayoutY(480);
        root.getChildren().add(alex);

        Scene scene = new Scene(root, 1280, 960);

        // Set to track currently pressed keys
        Set<KeyCode> pressedKeys = new HashSet<>();

        // Add key press and release handlers
        scene.setOnKeyPressed(event -> pressedKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));

        // AnimationTimer to handle movement
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pressedKeys.contains(KeyCode.UP)) {
                    alex.setLayoutY(alex.getLayoutY() - 5); // Move up
                }
                if (pressedKeys.contains(KeyCode.DOWN)) {
                    alex.setLayoutY(alex.getLayoutY() + 5); // Move down
                }
                if (pressedKeys.contains(KeyCode.LEFT)) {
                    alex.setLayoutX(alex.getLayoutX() - 5); // Move left
                }
                if (pressedKeys.contains(KeyCode.RIGHT)) {
                    alex.setLayoutX(alex.getLayoutX() + 5); // Move right
                }
            }
        };
        timer.start();

        return scene;
    }
}