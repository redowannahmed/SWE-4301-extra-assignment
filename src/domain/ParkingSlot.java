package domain;

public class ParkingSlot {
    private final int slotNumber;
    private Car parkedCar;

    public ParkingSlot (int slotNumber)
    {
        this.slotNumber = slotNumber;
        this.parkedCar = null;
    }

    public int getSlotNumber ()
    {
        return slotNumber;
    }

    public boolean isAvailable()
    {
        return parkedCar == null;
    }

    public void assignCar (Car car)
    {
        this.parkedCar = car;
    }

    public void removeCar ()
    {
        this.parkedCar = null;
    }

    public Car getParkedCar ()
    {
        return parkedCar;
    }
}

