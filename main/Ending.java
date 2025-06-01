package main;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Ending {

    private String reason;

    public Ending(String reason) {
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
        } else if (reason.equals("tickets")) {
            StackPane root = new StackPane();
            Label label = new Label("You ran out of tickets!");
            label.setStyle("-fx-font-size: 24px; -fx-text-fill: red;");
            root.getChildren().add(label);
            
            Scene scene = new Scene(root, 640, 480);
            
            return scene;
        } else if (reason.equals("leave")) {
            StackPane root = new StackPane();
            Label label = new Label("You left the park!");
            label.setStyle("-fx-font-size: 24px; -fx-text-fill: green;");
            root.getChildren().add(label);
            
            Scene scene = new Scene(root, 640, 480);
            
            return scene;
        } else {
            StackPane root = new StackPane();
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/timeloss.mp4").toExternalForm()));
            mediaPlayer.setAutoPlay(true);
            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setFitWidth(640);
            mediaView.setFitHeight(480);
            root.getChildren().add(mediaView);

            // Close the window when the video ends
            mediaPlayer.setOnEndOfMedia(() -> {
                Main.getStage().close();
            });

            Scene scene = new Scene(root, 640, 480);
            return scene;
        }
    }
}
