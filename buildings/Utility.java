package buildings;

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

public class Utility {
    
    private String name;
    private String optionName;
    private double optionPrice;
    private int optionTime;
    private int x;
    private int y;
    private String video;
    private boolean leaveorBuy = false; // true for leave, false for buy

    public Utility(String name, String optionName, double optionPrice, int optionTime, int x, int y, String video, boolean leaveorBuy) {
        this.name = name;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.optionTime = optionTime;
        this.x = x;
        this.y = y;
        this.video = video;
        this.leaveorBuy = leaveorBuy;
    }

    public Scene getScene() {
        StackPane root = new StackPane();

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        Label label = new Label(name);
        Button option = new Button(optionName + "\n$" + String.format("%.2f", optionPrice) + "\n" + optionTime + " minutes");
        Button leave = new Button("Leave");

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource(video).toExternalForm()));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);

        if (leaveorBuy) {
            leave.setOnAction(e -> {
                root.getChildren().add(mediaView);
                mediaPlayer.play();
                mediaPlayer.setOnEndOfMedia(() -> {
                    mediaPlayer.stop();
                    root.getChildren().remove(mediaView);
                    Main.setScene(Map.getScene(x, y));
                });
            });
            option.setOnAction(e -> {
                buyOption();
            });
        } else {
            leave.setOnAction(e -> {
                Main.setScene(Map.getScene(x, y));
            });
            option.setOnAction(e -> {
                buyOption();
                root.getChildren().add(mediaView);
                mediaPlayer.play();
                mediaPlayer.setOnEndOfMedia(() -> {
                    mediaPlayer.stop();
                    root.getChildren().remove(mediaView);
                });
            });
        }

        vbox.getChildren().addAll(label, option, leave);

        HBox hud = new Hud(Map.player).getHud();
        hud.setMouseTransparent(true);
        root.getChildren().addAll(hud, vbox);

        Scene scene = new Scene(root, 640, 480);

        return scene;
    }

    public void buyOption() {
        Map.player.addTime(optionTime);
        Map.player.addMoney(-optionPrice);
    }
}
