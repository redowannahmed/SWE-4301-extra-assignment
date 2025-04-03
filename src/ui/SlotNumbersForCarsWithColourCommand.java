package ui;

import java.util.ArrayList;
import java.util.List;

import domain.IParkingLot;
import domain.ParkingSlot;

public class SlotNumbersForCarsWithColourCommand implements iCommand{
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        if (tokens.length != 2) {
            System.out.println("Usage: slot_numbers_for_cars_with_colour <color>");
            return;
        }

        String colorQuery = tokens[1];
        IParkingLot parkingLot = context.getParkingLot();
        List<String> slotNumbers = new ArrayList<>();

        for (ParkingSlot slot : parkingLot.getStatus()) {
            if (!slot.isAvailable() && 
                slot.getParkedCar().getColor().equalsIgnoreCase(colorQuery)) {
                slotNumbers.add(String.valueOf(slot.getSlotNumber()));
            }
        }

        if (slotNumbers.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println(String.join(", ", slotNumbers));
        }
    }
}
