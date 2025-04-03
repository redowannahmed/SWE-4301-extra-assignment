package ui;

import domain.IParkingLot;

public class LeaveCommand implements iCommand {
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        if (tokens.length != 2) {
            System.out.println("Usage: leave <slot_number>");
            return;
        }
        int slotNumber;
        try {
            slotNumber = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid slot number format.");
            return;
        }

        IParkingLot parkingLot = context.getParkingLot();
        if (parkingLot == null) {
            System.out.println("No parking lot found. Please use create_parking_lot <n> first.");
            return;
        }

        if (parkingLot.leaveSlot(slotNumber)) {
            System.out.println("Slot number " + slotNumber + " is free");
            context.getFileManager().saveState(parkingLot);
        } else {
            System.out.println("Invalid slot or slot already empty");
        }
    }
}
