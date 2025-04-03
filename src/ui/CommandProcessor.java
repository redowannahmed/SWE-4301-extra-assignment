package ui;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcessor {
    private final Scanner scanner;
    private final Map<String, iCommand> commandRegistry;

    public CommandProcessor(ParkingLotContext context) {
        this.scanner = new Scanner(System.in);
        this.commandRegistry = new HashMap<>();

        commandRegistry.put("create_parking_lot", new CreateParkingLotCommand());
        commandRegistry.put("park", new ParkCommand());
        commandRegistry.put("leave", new LeaveCommand());
        commandRegistry.put("status", new StatusCommand());
        commandRegistry.put("registration_numbers_for_cars_with_colour",
                new RegistrationNumbersForCarsWithColourCommand());
        commandRegistry.put("slot_number_for_registration_number",
                new SlotNumberForRegistrationNumberCommand());
        commandRegistry.put("slot_numbers_for_cars_with_colour",
                new SlotNumbersForCarsWithColourCommand());
        commandRegistry.put("exit", new ExitCommand());
    }

    public void processCommands(ParkingLotContext context) {
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input == null || input.trim().isEmpty()) {
                continue;
            }

            String[] tokens = input.trim().split("\\s+");
            String commandName = tokens[0].toLowerCase();

            iCommand command = commandRegistry.getOrDefault(commandName, new UnknownCommand());
            command.execute(tokens, context);
        }
    }
}
