package domain;

public class Car {
    private final String registrationNumber;
    private final String color;
    private int allocatedSlot;

    public Car(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.allocatedSlot = -1;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setAllocatedSlot(int allocatedSlot) {
        this.allocatedSlot = allocatedSlot;
    }

    public int getAllocatedSlot() {
        return allocatedSlot;
    }
}
