package ui;

public interface iCommand {
    void execute(String[] tokens, ParkingLotContext context);
}