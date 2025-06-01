package buildings;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pages.Map;

public class Starbucks extends Restaurant {

    public Starbucks() {
        super(getMenuItems(), "Starbucks", 1060, 720);
    }

    private static ArrayList<Button> getMenuItems() {
        Button coffee = new Button("Coffee\n$2.65\n5 hunger", new ImageView(new Image("coffee.png", 64, 64, true, true)));
        Button latte = new Button("Latte\n$4.25\n5 hunger", new ImageView(new Image("latte.png", 64, 64, true, true)));
        Button cakepop = new Button("Cake Pop\n$2.25\n5 hunger", new ImageView(new Image("cakepop.png", 64, 64, true, true)));

        ArrayList<Button> menuItems = new ArrayList<>();
        menuItems.add(coffee);
        menuItems.add(latte);
        menuItems.add(cakepop);

        coffee.setPrefSize(200, 120);
        coffee.setOnAction(e -> {
            Map.player.addMoney(-2.65);
            Map.player.addHunger(5);
        });
        latte.setPrefSize(200, 120);
        latte.setOnAction(e -> {
            Map.player.addMoney(-4.25);
            Map.player.addHunger(5);
        });
        cakepop.setPrefSize(200, 120);
        cakepop.setOnAction(e -> {
            Map.player.addMoney(-2.25);
            Map.player.addHunger(5);
        });

        return menuItems;
    }
    
}
