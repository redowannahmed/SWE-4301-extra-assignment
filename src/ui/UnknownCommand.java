package ui;

public class UnknownCommand implements iCommand{
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        System.out.println("Unknown command. Please try again.");
    }
}
