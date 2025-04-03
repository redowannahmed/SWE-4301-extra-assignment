package ui;

import domain.IParkingLot;
import domain.ParkingSlot;

public class SlotNumberForRegistrationNumberCommand implements iCommand{
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        if (tokens.length != 2) {
            System.out.println("Usage: slot_number_for_registration_number <registration_number>");
            return;
        }

        String queryRegNo = tokens[1];
        IParkingLot parkingLot = context.getParkingLot();
        int foundSlot = -1;

        for (ParkingSlot slot : parkingLot.getStatus()) {
            if (!slot.isAvailable() &&
                slot.getParkedCar().getRegistrationNumber().equalsIgnoreCase(queryRegNo)) {
                foundSlot = slot.getSlotNumber();
                break;
            }
        }

        if (foundSlot == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(foundSlot);
        }
    }
}
