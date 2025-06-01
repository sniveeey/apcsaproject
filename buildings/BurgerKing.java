package buildings;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pages.Map;

public class BurgerKing extends Restaurant {
    
    public BurgerKing() {
        super(getMenuItems(), "Burger King", 1040, 590);
    }

    public static ArrayList<Button> getMenuItems() {
        Button whopper = new Button("Whopper\n$6.19", new ImageView(new Image("whopper.png", 64, 64, true, true)));
        Button fries = new Button("Fries\n$3.29", new ImageView(new Image("bkfries.png", 64, 64, true, true)));
        Button onionRings = new Button("Onion Rings\n$3.29", new ImageView(new Image("onionrings.png", 64, 64, true, true)));

        ArrayList<Button> menuItems = new ArrayList<>();
        menuItems.add(whopper);
        menuItems.add(fries);
        menuItems.add(onionRings);

        whopper.setPrefSize(200, 120);
        whopper.setOnAction(e -> {
            Map.player.addMoney(-6.19);
        });
        fries.setPrefSize(200, 120);
        fries.setOnAction(e -> {
            Map.player.addMoney(-3.29);
        });
        onionRings.setPrefSize(200, 120);
        onionRings.setOnAction(e -> {
            Map.player.addMoney(-3.29);
        });

        return menuItems;
    }
}
