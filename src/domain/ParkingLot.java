package domain;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance = null;
    private final List<ParkingSlot> slots;

    private ParkingLot (int totalSlots)
    {
        slots = new ArrayList<>(totalSlots);

        for (int i = 1; i<= totalSlots; i++)
        {
            slots.add(new ParkingSlot(i));
        }
    }

    public static ParkingLot getInstance (int totalSlots)
    {
        if (instance == null)
        {
            instance = new ParkingLot(totalSlots);
        }
        return instance;
    }

    public static void resetInstance()
    {
        instance = null;
    }

    public Ticket parkCar (Car car)
    {
        for (ParkingSlot slot: slots)
        {
            if (slot.isAvailable())
            {
                slot.assignCar(car);
                return new Ticket(slot.getSlotNumber(), car);
            }
        }

        return null;
    }

    public boolean leaveSlot (int slotNumber)
    {
        if (slotNumber <= 0 || slotNumber > slots.size())
        {
            return false;
        }

        ParkingSlot slot = slots.get(slotNumber - 1);
        if (!slot.isAvailable())
        {
            slot.removeCar();
            return true;
        }

        return false;
    }

    public List<ParkingSlot> getStatus ()
    {
        return slots;
    }
}
