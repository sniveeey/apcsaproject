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

public class Shop {
    public Scene getScene() {
        StackPane root = new StackPane();

        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);
        Label label = new Label("Welcome to the Shop!");
        HBox items = new HBox();
        items.setSpacing(10);
        items.setAlignment(javafx.geometry.Pos.CENTER);
        Button leave = new Button("Leave");

        // Add media for leaving
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/leaveshop.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);

        leave.setOnAction(e -> {
            root.getChildren().add(mediaView);
            mediaPlayer.play();
            mediaPlayer.setOnEndOfMedia(() -> {
                mediaPlayer.stop();
                root.getChildren().remove(mediaView);
                Main.setScene(Map.getScene(780, 460));
            });
        });

        vbox.getChildren().addAll(label, items, leave);

        VBox tshirtBox = new VBox();
        tshirtBox.setAlignment(javafx.geometry.Pos.CENTER);
        Label tshirtLabel = new Label();
        Button tshirt = new Button("T-Shirt\n$25.00");
        tshirt.setOnAction(e -> {
            Map.player.addMoney(-25.00);
            tshirtLabel.setText("You bought a T-Shirt!");
        });
        tshirtBox.getChildren().addAll(tshirt, tshirtLabel);

        VBox plushBox = new VBox();
        plushBox.setAlignment(javafx.geometry.Pos.CENTER);
        Label plushLabel = new Label();
        Button plush = new Button("Plushie\n$20.00");
        plush.setOnAction(e -> {
            Map.player.addMoney(-20.00);
            plushLabel.setText("You bought a Plushie!");
        });
        plushBox.getChildren().addAll(plush, plushLabel);

        VBox waterbottleBox = new VBox();
        waterbottleBox.setAlignment(javafx.geometry.Pos.CENTER);
        Label waterbottleLabel = new Label();
        Button waterbottle = new Button("Water Bottle\n$15.00");
        waterbottle.setOnAction(e -> {
            Map.player.addMoney(-15.00);
            waterbottleLabel.setText("You bought a Water Bottle!");
        });
        waterbottleBox.getChildren().addAll(waterbottle, waterbottleLabel);

        VBox bubblewandBox = new VBox();
        bubblewandBox.setAlignment(javafx.geometry.Pos.CENTER);
        Label bubblewandLabel = new Label();
        Button bubblewand = new Button("Bubble Wand\n$15.00");
        bubblewand.setOnAction(e -> {
            Map.player.addMoney(-15.00);
            bubblewandLabel.setText("You bought a Bubble Wand!");
        });
        bubblewandBox.getChildren().addAll(bubblewand, bubblewandLabel);
        
        items.getChildren().addAll(tshirtBox, plushBox, waterbottleBox, bubblewandBox);

        HBox hud = new Hud(Map.player).getHud();
        hud.setMouseTransparent(true);
        root.getChildren().addAll(hud, vbox);

        Scene scene = new Scene(root, 640, 480);

        return scene;
    }
}
