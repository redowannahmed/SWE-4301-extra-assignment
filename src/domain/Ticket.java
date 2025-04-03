package domain;

public class Ticket {
    private final int slotNumber;
    private final Car car;

    public Ticket(int slotNumber, Car car) {
        this.slotNumber = slotNumber;
        this.car = car;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Ticket: Slot Number = " + slotNumber
            + ", Registration = " + car.getRegistrationNumber()
            + ", Color = " + car.getColor();
    }
}
