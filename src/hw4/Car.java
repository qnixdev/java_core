package hw4;

public class Car {
    private String engine = "V6";
    private String color = "Black";
    private int tankLimit = 50;
    private int fuelConsumption = 8;

    public Car() {}

    public Car(String engine, String color, int tankLimit, int fuelConsumption) {
        this.engine = engine;
        this.color = color;
        this.tankLimit = tankLimit;
        this.fuelConsumption = fuelConsumption;
    }

    public String getEngine() {
        return this.engine;
    }

    public void setEngine(String engine) {
        if (engine.isBlank()) {
            System.out.println("Invalid value passed!");

            return;
        }

        this.engine = engine;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        if (color.isBlank()) {
            System.out.println("Invalid value passed!");

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
            System.out.println("Incorrect distance traveled: '" + distance + "'");

            return;
        }

        int fuelSpent = distance / this.getFuelConsumption();
        boolean isEnoughFuel = fuelSpent - this.getTankLimit() > 0;

        if (!isEnoughFuel) {
            System.out.println("There will be enough fuel in the tank.");
        } else {
            System.out.println("Will need to refuel: " + (fuelSpent - this.getTankLimit()) + " liters.");
        }
    }
}