package hw5;

public class Car {
    protected String engine = "V6";
    protected String color = "Black";

    protected Car() {}

    protected Car(String engine, String color) {
        if (null != engine) {
            this.engine = engine;
        }

        if (null != color) {
            this.color = color;
        }
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

    protected String getColor() {
        return this.color;
    }

    protected void setColor(String color) {
        this.color = color;
    }
}