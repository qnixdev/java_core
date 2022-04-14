package hw8;

public class App {
    public static void main(String[] args) {
        // task one
        String truckEngine = "T1000";
        int truckTankLimit = 250;
        int truckFuelConsumption = 20;
        int truckWeight = 15000;

        TruckCar truckCar = new TruckCar(
                truckEngine,
                truckTankLimit,
                truckFuelConsumption,
                truckWeight
        );

        System.out.println(truckCar.sayName());
        System.out.println();

        // task two
        String inputOne = "(1+(2*3)+((8)/4))+1";
        System.out.println(Solution.maxDepth(inputOne));

        String inputTwo = "(1)+((2))+(((3)))";
        System.out.println(Solution.maxDepth(inputOne));
    }
}
