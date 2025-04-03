package ui;

import java.util.ArrayList;
import java.util.List;

import domain.IParkingLot;
import domain.ParkingSlot;

public class RegistrationNumbersForCarsWithColourCommand implements iCommand{
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        if (tokens.length != 2) {
            System.out.println("Usage: registration_numbers_for_cars_with_colour <color>");
            return;
        }

        String queryColor = tokens[1];
        IParkingLot parkingLot = context.getParkingLot();
        List<String> registrations = new ArrayList<>();

        for (ParkingSlot slot : parkingLot.getStatus()) {
            if (!slot.isAvailable() &&
                slot.getParkedCar().getColor().equalsIgnoreCase(queryColor)) {
                registrations.add(slot.getParkedCar().getRegistrationNumber());
            }
        }

        if (registrations.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println(String.join(", ", registrations));
        }
    }
}
