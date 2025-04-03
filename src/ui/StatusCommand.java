package ui;

import domain.IParkingLot;
import domain.ParkingSlot;

public class StatusCommand implements iCommand {
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        IParkingLot parkingLot = context.getParkingLot();
        if (parkingLot == null) {
            System.out.println("No parking lot data available. Please create a parking lot first.");
            return;
        }

        for (ParkingSlot slot : parkingLot.getStatus()) {
            if (!slot.isAvailable()) {
                System.out.println("Slot " + slot.getSlotNumber() + " => "
                    + slot.getParkedCar().getRegistrationNumber() + " "
                    + slot.getParkedCar().getColor());
            }
        }
    }
}
