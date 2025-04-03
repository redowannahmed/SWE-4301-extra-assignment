package ui;

import domain.IParkingLot;
import persistence.FileManager;
import persistence.IFileManager;

public class Main {
        public static void main(String[] args) {
            IFileManager fileManager = new FileManager("parking_state.txt");

            IParkingLot loadedLot = fileManager.loadState();
    
            ParkingLotContext context = new ParkingLotContext(loadedLot, fileManager);
    
            CommandProcessor commandProcessor = new CommandProcessor(context);
    
            commandProcessor.processCommands(context);
    }
}

