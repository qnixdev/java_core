package hw5;

import java.util.Arrays;

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

        // task two
        Solution solution = new Solution();

        int[] numsOne = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.runningSum(numsOne)));

        int[] numsTwo = {1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution.runningSum(numsTwo)));

        int[] numsThree = {3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(solution.runningSum(numsThree)));
    }
}