package pages;

import java.util.HashSet;
import java.util.Set;

import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Map {
    public static IntegerProperty time = new SimpleIntegerProperty(320);

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
                int speed = 1;
                if (pressedKeys.contains(KeyCode.SHIFT)) {
                    speed = 2; // Increase speed when SHIFT is pressed
                    time.set(time.get() + 1);
                }
                if (pressedKeys.contains(KeyCode.UP)) {
                    alex.setLayoutY(alex.getLayoutY() - speed); // Move up
                }
                if (pressedKeys.contains(KeyCode.DOWN)) {
                    alex.setLayoutY(alex.getLayoutY() + speed); // Move down
                }
                if (pressedKeys.contains(KeyCode.LEFT)) {
                    alex.setLayoutX(alex.getLayoutX() - speed); // Move left
                }
                if (pressedKeys.contains(KeyCode.RIGHT)) {
                    alex.setLayoutX(alex.getLayoutX() + speed); // Move right
                }
            }
        };
        timer.start();

        VBox hud = new VBox();
        Label timeLabel = new Label();
        timeLabel.textProperty().bind(new SimpleStringProperty("Time: ").concat(time.divide(60).asString()).concat(":").concat(time.subtract(time.divide(60).multiply(60)).asString("%02d")));
        hud.getChildren().add(timeLabel);
        root.getChildren().add(hud);

        return scene;
    }
}