package buildings;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import main.Hud;
import main.Main;
import pages.Map;

public class Restaurant {

    private ArrayList<Button> menuItems = new ArrayList<>();
    private String name;
    private int x;
    private int y;

    public Restaurant(ArrayList<Button> menuItems, String name, int x, int y) {
        this.menuItems = menuItems;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public Scene getScene() {
        StackPane root = new StackPane();

        VBox vbox = new VBox();
        Label label = new Label("Welcome to " + name + "!");
        HBox items = new HBox();
        Button leave = new Button("Leave");
        items.setSpacing(10);
        items.setAlignment(javafx.geometry.Pos.CENTER);
        items.getChildren().addAll(menuItems);

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/leavingrestaurant.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);

        leave.setOnAction(e -> {
            root.getChildren().add(mediaView);
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.stop();
                root.getChildren().remove(mediaView);
                Main.setScene(Map.getScene(x, y)); // Return to the map scene after video
            });
        });

        vbox.getChildren().addAll(label, items, leave);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        vbox.setSpacing(20);

        HBox hud = new Hud(Map.player).getHud();
        hud.setMouseTransparent(true);

        root.getChildren().addAll(vbox, hud);

        Scene scene = new Scene(root, 640, 480);

        scene.windowProperty().addListener((obs, oldWin, newWin) -> {
            if (newWin != null) {
                newWin.focusedProperty().addListener((o, oldFocused, newFocused) -> {
                    if (newFocused) {
                        vbox.requestFocus();
                    }
                });
            }
        }); // Makes the window focused (sometimes doesn't work)

        return scene;
    }
}
