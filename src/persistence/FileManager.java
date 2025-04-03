package persistence;

import domain.Car;
import domain.IParkingLot;
import domain.ParkingLot;
import domain.ParkingSlot;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class FileManager implements IFileManager {
    private final String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public IParkingLot loadState() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("No previous parking lot state found (file missing or unreadable).");
            return null;
        }

        if (lines.isEmpty()) {
            return null;
        }

        try {
            int totalSlots = Integer.parseInt(lines.get(0).trim());
            IParkingLot parkingLot = new ParkingLot(totalSlots);

            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                int slotNumber = Integer.parseInt(parts[0].trim());

                if (parts.length == 2 && "EMPTY".equalsIgnoreCase(parts[1].trim())) {
                    continue;
                }
                String registration = parts[1].trim();
                String color = parts[2].trim();

                Car car = new Car(registration, color);
                car.setAllocatedSlot(slotNumber);

                ParkingSlot slot = parkingLot.getStatus().get(slotNumber - 1);
                slot.assignCar(car);
            }
            return parkingLot;

        } catch (NumberFormatException e) {
            System.out.println("Corrupted state file: " + e.getMessage());
            return null;
        }
    }


    @Override
    public void saveState(IParkingLot parkingLot) {
        if (parkingLot == null) {
            System.out.println("No parking lot to save.");
            return;
        }
        List<String> lines = new ArrayList<>();

        int totalSlots = parkingLot.getStatus().size();
        lines.add(String.valueOf(totalSlots));

        for (ParkingSlot slot : parkingLot.getStatus()) {
            if (slot.isAvailable()) {
                lines.add(slot.getSlotNumber() + ",EMPTY");
            } else {
                lines.add(
                    slot.getSlotNumber() + "," +
                    slot.getParkedCar().getRegistrationNumber() + "," +
                    slot.getParkedCar().getColor()
                );
            }
        }

        try {
            Files.write(
                Paths.get(filePath),
                lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }
}
