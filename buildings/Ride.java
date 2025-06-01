package buildings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import main.Hud;
import main.Main;
import pages.Map;

public class Ride {
    private String name;
    private int tickets;
    private int time;
    private String video;
    private int x;
    private int y;

    public Ride(String name, int tickets, int time, String video, int x, int y) {
        this.name = name;
        this.tickets = tickets;
        this.time = time;
        this.video = video;
        this.x = x;
        this.y = y;
    }

    public Scene getScene() {
        StackPane root = new StackPane();

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        Button experience = new Button(name + "\n" + tickets + " tickets\n" + time + " minutes");
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource(video).toExternalForm()));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);
        experience.setOnAction(e -> {
            Map.player.addTime(time);
            Map.player.addTickets(-tickets);
            root.getChildren().add(mediaView);
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.stop();
                root.getChildren().remove(mediaView);
                Main.setScene(Map.getScene(x, y));
            });
        });
        Button leave = new Button("Leave");
        leave.setOnAction(e -> {
            Main.setScene(Map.getScene(x, y));
        });
        HBox hud = new Hud(Map.player).getHud();
        hud.setMouseTransparent(true);
        vbox.getChildren().addAll(experience, leave);
        root.getChildren().addAll(vbox, hud);

        Scene scene = new Scene(root, 640, 480);

        return scene;
    }
}
