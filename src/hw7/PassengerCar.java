package hw7;

import hw6.Car;
import hw6.Nameable;

final public class PassengerCar extends Car implements Nameable {
    public PassengerCar(String engine, int tankLimit, int fuelConsumption, int weight) {
        super(engine, tankLimit, fuelConsumption, weight);
    }

    @Override
    public void isEnoughFuelForDistance(int distance) {
        if (distance <= 0) {
            return;
        }

        int fuelSpent = distance / this.getFuelConsumption();
        int fuelRemaining = fuelSpent - this.getTankLimit();

        if (!(fuelRemaining > 0)) {
            System.out.println(DistanceAnswer.WILL_ENOUGH);
        } else {
            System.out.println(DistanceAnswer.NEED_REFUEL + ": " + fuelRemaining);
        }
    }

    @Override
    public String sayName() {
        return CarName.PASSENGER.getName() + " with '" + this.getEngine() + "' engine.";
    }
}