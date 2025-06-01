package main;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Player {
    
    private final SimpleIntegerProperty time;
    private final SimpleIntegerProperty tickets;
    private final SimpleDoubleProperty money;
    private final SimpleIntegerProperty hunger;

    public Player(SimpleIntegerProperty time, SimpleIntegerProperty tickets, SimpleDoubleProperty money, SimpleIntegerProperty hunger) {
        this.time = time;
        this.tickets = tickets;
        this.money = money;
        this.hunger = hunger;
    }

    public void setTime(int amount) {
        time.set(amount);
    }

    public void addTime(int amount) {
        time.set(time.get() + amount);
        if (time.get() >= 1440) {
            Main.setScene(new Loss("time").getScene());
        }
        addHunger(amount / 10);
    }

    public SimpleIntegerProperty getTime() {
        return time;
    }

    public void setTickets(int amount) {
        tickets.set(amount);
    }

    public void addTickets(int amount) {
        tickets.set(tickets.get() + amount);
    }

    public SimpleIntegerProperty getTickets() {
        return tickets;
    }

    public void setMoney(double amount) {
        money.set(amount);
    }

    public void addMoney(double amount) {
        money.set(money.get() + amount);
        if (money.get() < 0) {
            Main.setScene(new Loss("money").getScene());
        }
    }

    public SimpleDoubleProperty getMoney() {
        return money;
    }

    public void setHunger(int amount) {
        hunger.set(amount);
    }

    public void addHunger(int amount) {
        hunger.set(hunger.get() + amount);
        if (hunger.get() <= 0) {
            Main.setScene(new Loss("hunger").getScene());
        }
    }

    public SimpleIntegerProperty getHunger() {
        return hunger;
    }
}
