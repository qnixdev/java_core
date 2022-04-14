package hw6;

final public class PassengerCar extends Car implements Nameable {
    public PassengerCar(String engine, int tankLimit, int fuelConsumption, int weight) {
        super(engine, tankLimit, fuelConsumption, weight);
    }

    @Override
    public void isEnoughFuelForDistance(int distance) {
        if (distance <= 0) {
            System.out.println("Incorrect distance: '" + distance + "'");

            return;
        }

        int fuelSpent = distance / this.getFuelConsumption();
        int fuelRemaining = fuelSpent - this.getTankLimit();

        if (!(fuelRemaining > 0)) {
            System.out.println("There will be enough fuel in the tank.");
        } else {
            System.out.println("Will need to refuel: " + fuelRemaining + " liters.");
        }
    }

    @Override
    public String sayName() {
        return "Passenger car with " + this.getEngine() + " engine.";
    }
}