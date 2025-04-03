package ui;

import domain.IParkingLot;
import domain.ParkingLot;
import persistence.IFileManager;

public class CreateParkingLotCommand implements iCommand{
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        IFileManager fileManager = context.getFileManager();
        if (tokens.length != 2) {
            System.out.println("Usage: create_parking_lot <n>");
            fileManager.saveState(context.getParkingLot());
            return;
        }
        String nStr = tokens[1].replaceAll("[<>]", "");
        int n = Integer.parseInt(nStr);

        IParkingLot newParkingLot = new ParkingLot(n);
        context.setParkingLot(newParkingLot);

        System.out.println("Created a parking lot with " + n + " slots");
        fileManager.saveState(newParkingLot);
    }
}
