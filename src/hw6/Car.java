package hw6;

abstract public class Car {
    protected String engine;
    protected int tankLimit;
    protected int fuelConsumption;
    protected int weight;

    protected Car(String engine, int tankLimit, int fuelConsumption, int weight) {
        this.engine = engine;
        this.tankLimit = tankLimit;
        this.fuelConsumption = fuelConsumption;
        this.weight = weight;
    }

    protected String getEngine() {
        return this.engine;
    }

    protected void setEngine(String engine) {
        if (engine.isBlank()) {
            System.out.println("Specify a car engine!");

            return;
        }

        this.engine = engine;
    }

    protected int getTankLimit() {
        return this.tankLimit;
    }

    protected void setTankLimit(int tankLimit) {
        if (tankLimit <= 0 || tankLimit == this.getTankLimit()) {
            System.out.println("Incorrect tank limit passed!");

            return;
        }

        this.tankLimit = tankLimit;
    }

    protected int getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(int fuelConsumption) {
        if (fuelConsumption <= 0 || fuelConsumption == this.getFuelConsumption()) {
            System.out.println("Incorrect tank limit passed!");

            return;
        }

        this.fuelConsumption = fuelConsumption;
    }

    protected int getWeight() {
        return this.weight;
    }

    protected void setWeight(int weight) {
        if (weight <= 0 || weight == this.getWeight()) {
            System.out.println("Incorrect weight of car passed!");

            return;
        }

        this.weight = weight;
    }

    abstract public void isEnoughFuelForDistance(int distance);
}