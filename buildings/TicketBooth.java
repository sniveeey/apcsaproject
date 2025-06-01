package buildings;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import main.Ending;
import main.Main;
import pages.Map;

public class TicketBooth extends Utility {
    public TicketBooth() {
        super("Ticket Booth", "Buy Ticket", 10.0, 5, 640, 800, "/ticketbuy.mp4", false);
    }

    // unfortunately needs to be public
    @Override
    public void buyOption() {
        super.buyOption();
        Map.player.addTickets(1);
    }

    @Override
    public Scene getScene() {
        // Very scuffed, but it works
        Scene scene = super.getScene();
        StackPane root = (StackPane) scene.getRoot();
        Button leavePark = new Button("Leave Park");
        leavePark.setOnAction(e -> {
            Main.setScene(new Ending("leave").getScene());
        });
        javafx.scene.layout.VBox vbox = (javafx.scene.layout.VBox) root.getChildren().get(1);
        vbox.getChildren().add(leavePark);

        return scene;
    }
}
