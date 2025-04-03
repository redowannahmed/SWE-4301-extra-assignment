package ui;

import domain.Car;
import domain.IParkingLot;
import factories.CarFactory;

public class ParkCommand implements iCommand {
    @Override
    public void execute(String[] tokens, ParkingLotContext context) {
        if (tokens.length != 3) {
            System.out.println("Usage: park <registration_number> <color>");
            return;
        }
        String regNo = tokens[1];
        String color = tokens[2];
        Car car = CarFactory.createCar(regNo, color);

        IParkingLot parkingLot = context.getParkingLot();
        if (parkingLot == null) {
            System.out.println("No parking lot found. Please use create_parking_lot <n> first.");
            return;
        }

        if (parkingLot.parkCar(car) != null) {
            System.out.println("Allocated slot number: " + car.getAllocatedSlot());
            context.getFileManager().saveState(parkingLot);
        } else {
            System.out.println("Sorry, parking lot is full");
        }
    }
}
