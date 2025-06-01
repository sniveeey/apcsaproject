package buildings;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pages.Map;

public class McDonalds extends Restaurant {

    public McDonalds() {
        super(getMenuItems(), "McDonald's", 680, 680);
    }

    private static ArrayList<Button> getMenuItems() {
        Button bigmac = new Button("Big Mac\n$5.59", new ImageView(new Image("bigmac.png", 64, 64, true, true)));
        Button fries = new Button("Fries\n$4.19", new ImageView(new Image("fries.png", 64, 64, true, true)));
        Button mcnuggets = new Button("McNuggets\n$3.99", new ImageView(new Image("mcnuggets.png", 64, 64, true, true)));
        
        ArrayList<Button> menuItems = new ArrayList<>();
        menuItems.add(bigmac);
        menuItems.add(fries);
        menuItems.add(mcnuggets);
        
        bigmac.setPrefSize(200, 120);
        bigmac.setOnAction(e -> {
            Map.player.addMoney(-5.59);
        });
        fries.setPrefSize(200, 120);
        fries.setOnAction(e -> {
            Map.player.addMoney(-4.19);
        });
        mcnuggets.setPrefSize(200, 120);
        mcnuggets.setOnAction(e -> {
            Map.player.addMoney(-3.99);
        });

        return menuItems;
    }
}
