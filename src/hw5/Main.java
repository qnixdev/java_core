package hw5;

public class Main {
    public static void main(String[] args) {
        // task one
        String carEngine = "V8";
        String carColor = "Blue";

        Car car = new Car(
            carEngine,
            carColor
        );

        String newCarColor = "   ";

        System.out.println("Default car color: " + car.getColor() + ".");
        car.setColor(newCarColor);
        System.out.println("Car color: " + car.getColor() + ".");
        System.out.println();

        int formulaTankLimit = 25;
        int formulaFuelConsumption = 12;

        SportCar formulaOne = new SportCar(
            formulaTankLimit,
            formulaFuelConsumption
        );

        System.out.println("Default car color: " + formulaOne.getColor() + ".");
        formulaOne.setColor(newCarColor);
        System.out.println("New car color: " + formulaOne.getColor() + ".");
        System.out.println();
    }
}