package hw5;

public class SportCar extends Car {
    private int tankLimit = 50;
    private int fuelConsumption = 6;

    public SportCar() {}

    public SportCar(int tankLimit, int fuelConsumption) {
        this(null, null, tankLimit, fuelConsumption);
    }

    public SportCar(String engine, String color, int tankLimit, int fuelConsumption) {
        super(engine, color);

        this.tankLimit = tankLimit;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void setColor(String color) {
        if (color.isBlank()) {
            System.out.println("Specify a car color!");

            return;
        }

        this.color = color;
    }

    public int getTankLimit() {
        return this.tankLimit;
    }

    public void setTankLimit(int tankLimit) {
        if (tankLimit <= 0 || tankLimit == this.getTankLimit()) {
            System.out.println("Incorrect tank limit passed!");
        }

        this.tankLimit = tankLimit;
    }

    public int getFuelConsumption() {
        return this.fuelConsumption;
    }

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
}