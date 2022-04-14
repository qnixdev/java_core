package hw8;

public enum CarName {
    PASSENGER("Passenger car"),
    TRUCK("Truck car");

    private final String name;

    CarName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}