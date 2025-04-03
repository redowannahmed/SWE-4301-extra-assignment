package ui;

import domain.IParkingLot;
import persistence.IFileManager;


public class ParkingLotContext {
    private IParkingLot parkingLot;
    private final IFileManager fileManager;

    public ParkingLotContext(IParkingLot parkingLot, IFileManager fileManager) {
        this.parkingLot = parkingLot;
        this.fileManager = fileManager;
    }

    public IParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(IParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public IFileManager getFileManager() {
        return fileManager;
    }
}
