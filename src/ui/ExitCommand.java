package ui;

public class ExitCommand implements iCommand{
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        System.out.println("Exiting system.");
        System.exit(0);
    }
}
