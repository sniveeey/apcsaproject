package pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.css.Rect;

import buildings.*;
import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import main.Hud;
import main.Main;
import main.Player;

public class Map {
    public static Player player = new Player(new SimpleIntegerProperty(0), new SimpleIntegerProperty(0), new SimpleDoubleProperty(50), new SimpleIntegerProperty(100));

    public static Scene getScene(int x, int y) {
        Pane root = new Pane();
        Image image = new Image("map.png", 1280, 960, false, false);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(1280);
        imageView.setFitHeight(960);
        root.getChildren().add(imageView);

        ImageView alex = new ImageView(new Image("alex.png", 12, 20, false, false));
        alex.setFitWidth(12);
        alex.setFitHeight(20);
        alex.setLayoutX(x);
        alex.setLayoutY(y);
        root.getChildren().add(alex);

        Scene scene = new Scene(root, 1280, 960);

        // Set to track currently pressed keys
        Set<KeyCode> pressedKeys = new HashSet<>();

        // Add key press and release handlers
        scene.setOnKeyPressed(event -> pressedKeys.add(event.getCode()));
        scene.setOnKeyReleased(event -> pressedKeys.remove(event.getCode()));

        ArrayList<Rectangle> obstacles = new ArrayList<>();
        Rectangle mcdonalds = new Rectangle(616, 634, 28, 42);
        Rectangle burgerking = new Rectangle(1072, 572, 16, 24);
        Rectangle starbucks = new Rectangle(1116, 704, 20, 40);
        Rectangle ticketbooth = new Rectangle(564, 836, 150, 40);
        Rectangle firstaid = new Rectangle(774, 660, 24, 140);
        Rectangle shop = new Rectangle(814, 480, 30, 80);
        //debugRect.setStyle("-fx-fill: rgba(255,0,0,0.3); -fx-stroke: red; -fx-stroke-width: 2;");
        //root.getChildren().add(debugRect); // Add to root so it's visible
        obstacles.add(mcdonalds);
        obstacles.add(burgerking);
        obstacles.add(starbucks);
        obstacles.add(ticketbooth);
        obstacles.add(firstaid);
        obstacles.add(shop);

        // AnimationTimer to handle movement
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int speed = 1;
                if (checkCollision(alex, obstacles) != -1) {
                    switch (checkCollision(alex, obstacles)) {
                        case 0:
                            Main.setScene(new McDonalds().getScene());
                            break;
                        case 1:
                            Main.setScene(new BurgerKing().getScene());
                            break;
                        case 2:
                            Main.setScene(new Starbucks().getScene());
                            break;
                        case 3:
                            Main.setScene(new TicketBooth().getScene());
                            break;
                        case 4:
                            Main.setScene(new FirstAid().getScene());
                            break;
                        case 5:
                            Main.setScene(new Shop().getScene());
                            break;
                    }
                }
                if (pressedKeys.contains(KeyCode.SHIFT)) {
                    speed = 2; // Increase speed when SHIFT is pressed
                    player.addTime(1);
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

        root.getChildren().add(new Hud(player).getHud());

        return scene;
    }

    private static int checkCollision(ImageView sprite, ArrayList<Rectangle> obstacles) {
        for (int i = 0; i < obstacles.size(); i++) {
            if (sprite.getBoundsInParent().intersects(obstacles.get(i).getBoundsInParent())) {
                return i;
            }
        }
        return -1;
    }
}