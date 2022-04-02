package hw4;

public class Main {
    public static void main(String[] args) {
        // Task one
        ArrayComparison comparison = new ArrayComparison();

        String[] word1 = new String[] {"ab", "c"};
        String[] word2 = new String[] {"a", "bc"};
        System.out.println(comparison.isArraysAreEqual(word1, word2));

        String[] word3 = new String[] {"a", "cb"};
        String[] word4 = new String[] {"ab", "c"};
        System.out.println(comparison.isArraysAreEqual(word3, word4));

        String[] word5 = new String[] {"abc", "d", "defg"};
        String[] word6 = new String[] {"abcddefg"};
        System.out.println(comparison.isArraysAreEqual(word5, word6));
        System.out.println();

        // Task two
        Car unnamedCar = new Car();
        System.out.println(unnamedCar.getTankLimit());
        System.out.println();

        String formulaEngine = "V8";
        String formulaColor = "Red";
        int formulaTankLimit = 45;
        int formulaFuelConsumption = 10;

        Car sportCar = new Car(
            formulaEngine,
            formulaColor,
            formulaTankLimit,
            formulaFuelConsumption
        );

        int distance = 800;
        sportCar.isEnoughFuelForDistance(distance);
        sportCar.setTankLimit(80);
        System.out.println();
        sportCar.isEnoughFuelForDistance(distance);
        System.out.println();
    }
}