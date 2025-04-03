package domain;

import java.util.List;

public interface IParkingLot {
    Ticket parkCar(Car car);

    boolean leaveSlot(int slotNumber);

    List<ParkingSlot> getStatus();
}
