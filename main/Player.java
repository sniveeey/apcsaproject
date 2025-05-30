package main;

import javafx.beans.property.SimpleIntegerProperty;

public class Player {
    
    private final SimpleIntegerProperty time;

    public Player(SimpleIntegerProperty time) {
        this.time = time;
    }

    public void setTime(int amount) {
        time.set(amount);
    }

    public void addTime(int amount) {
        time.set(time.get() + amount);
    }

    public SimpleIntegerProperty getTime() {
        return time;
    }
}
