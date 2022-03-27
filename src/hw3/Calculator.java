package hw3;

import java.util.Scanner;

public class Calculator {
    public void run() {
        boolean isRepeat = true;

        do {
            Scanner scannerNumber = new Scanner(System.in);
            Scanner scannerCommand = new Scanner(System.in);

            System.out.println("Input first number:");
            double number1 = scannerNumber.nextDouble();
            System.out.println("Choose command:");
            String operation = scannerCommand.nextLine();
            System.out.println("Input second number:");
            double number2 = scannerNumber.nextDouble();

            switch (operation) {
                case "+" -> System.out.println(this.sum(number1, number2));
                case "-" -> System.out.println(this.subtraction(number1, number2));
                case "*" -> System.out.println(this.multiplication(number1, number2));
                case "/" -> System.out.println(this.division(number1, number2));
                default -> {
                    System.out.println("Invalid command, in this case the addition command will be executed:");
                    System.out.println(this.sum(number1, number2));
                }
            }

            System.out.println("Input 'exit' enter to exit the calculator.");

            if (scannerCommand.hasNext("exit")) {
                isRepeat = false;
            }
        } while (isRepeat);
    }

    private double sum(double number1, double number2) {
        return number1 + number2;
    }

    private double subtraction(double number1, double number2) {
        return number1 - number2;
    }

    private double multiplication(double number1, double number2) {
        return number1 * number2;
    }

    private double division(double number1, double number2) {
        return number1 / number2;
    }
}
