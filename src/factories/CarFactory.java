package factories;
import domain.Car;


public class CarFactory {
    public static Car createCar(String registrationNumber, String color) {
        return new Car(registrationNumber, color);
    }
}
