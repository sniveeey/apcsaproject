package main;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Hud {
    private HBox hud;

    public Hud(Player player) {
        hud = new HBox();
        Label timeLabel = new Label();
        SimpleIntegerProperty time = player.getTime();
        timeLabel.textProperty().bind(new SimpleStringProperty("Time: ").concat(time.divide(60).asString()).concat(":").concat(time.subtract(time.divide(60).multiply(60)).asString("%02d")));
        hud.getChildren().add(timeLabel);
        
        Label ticketsLabel = new Label();
        SimpleIntegerProperty tickets = player.getTickets();
        ticketsLabel.textProperty().bind(new SimpleStringProperty("Tickets: ").concat(tickets.asString()));
        hud.getChildren().add(ticketsLabel);
        
        Label moneyLabel = new Label();
        SimpleDoubleProperty money = player.getMoney();
        moneyLabel.textProperty().bind(new SimpleStringProperty("Money: $").concat(money.asString("%.2f")));
        hud.getChildren().add(moneyLabel);

        Label hungerLabel = new Label();
        SimpleIntegerProperty hunger = player.getHunger();
        hungerLabel.textProperty().bind(new SimpleStringProperty("Hunger: ").concat(hunger.asString()));
        hud.getChildren().add(hungerLabel);
        
        hud.setSpacing(10);
    }

    public HBox getHud() {
        return hud;
    }
}
