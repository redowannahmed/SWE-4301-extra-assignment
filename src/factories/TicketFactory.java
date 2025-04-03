package factories;
import domain.Car;
import domain.Ticket;

public class TicketFactory {
    public static Ticket createTicket(int slotNumber, Car car) {
        return new Ticket(slotNumber, car);
    }
}