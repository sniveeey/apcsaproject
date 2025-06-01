package buildings;

import pages.Map;

public class TicketBooth extends Utility {
    public TicketBooth() {
        super("Ticket Booth", "Buy Ticket", 10.0, 5, 640, 800);
    }

    // unfortunately needs to be public
    @Override
    public void buyOption() {
        super.buyOption();
        Map.player.addTickets(1);
    }
}
