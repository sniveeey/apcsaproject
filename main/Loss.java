package main;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Loss {

    private String reason;

    public Loss(String reason) {
        this.reason = reason;
    }

    public Scene getScene() {
        if (reason.equals("money")) {
            StackPane root = new StackPane();
            Label label = new Label("You ran out of money!");
            label.setStyle("-fx-font-size: 24px; -fx-text-fill: red;");
            root.getChildren().add(label);
            
            Scene scene = new Scene(root, 640, 480);
            
            return scene;
        } else if (reason.equals("hunger")) {
            StackPane root = new StackPane();
            Label label = new Label("You starved!");
            label.setStyle("-fx-font-size: 24px; -fx-text-fill: red;");
            root.getChildren().add(label);
            
            Scene scene = new Scene(root, 640, 480);
            
            return scene;

        } else {
            StackPane root = new StackPane();
            // put actual video here
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/2024-12-07 17-01-20.mp4").toExternalForm()));
            mediaPlayer.setAutoPlay(true);
            MediaView mediaView = new MediaView(mediaPlayer);
            root.getChildren().add(mediaView);
            
            Scene scene = new Scene(root, 640, 480);

            return scene;
        }
    }
}
