package domain;

import java.util.ArrayList;
import java.util.List;


public class ParkingLot implements IParkingLot {
    private final List<ParkingSlot> slots;


    public ParkingLot(int totalSlots) {
        if (totalSlots <= 0) {
            throw new IllegalArgumentException("Total slots must be positive.");
        }
        slots = new ArrayList<>(totalSlots);
        for (int i = 1; i <= totalSlots; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    @Override
    public Ticket parkCar(Car car) {
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                slot.assignCar(car);
                car.setAllocatedSlot(slot.getSlotNumber());
                return new Ticket(slot.getSlotNumber(), car);
            }
        }
        return null; 
    }

    @Override
    public boolean leaveSlot(int slotNumber) {
        if (slotNumber <= 0 || slotNumber > slots.size()) {
            return false;
        }
        ParkingSlot slot = slots.get(slotNumber - 1);
        if (!slot.isAvailable()) {
            slot.removeCar();
            return true;
        }
        return false;
    }

    @Override
    public List<ParkingSlot> getStatus() {
        return slots;
    }
}
