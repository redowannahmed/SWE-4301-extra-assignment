package persistence;

import domain.IParkingLot;

public interface IFileManager {
    public IParkingLot loadState();
    void saveState(IParkingLot parkingLot);
}
