package hw7;

public class App {
    public static void main(String[] args) {
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
    }
}