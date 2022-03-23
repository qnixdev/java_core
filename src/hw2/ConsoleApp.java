package hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApp {
    private static final String hashtag = "#";
    private static final int percent = 17;

    public static void main(String[] args) {
        Worker worker = new Worker();

        calculateSum(worker);
        System.out.println();

        computeDeposit(worker);
        System.out.println();
    }

    private static void calculateSum(Worker worker) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(hashtag.repeat(30));
        System.out.println("# Compute sum of two number. #");
        System.out.println(hashtag.repeat(30));

        int firstNumber  = parseInteger(scanner, "Enter first number");
        int secondNumber = parseInteger(scanner, "Enter second number");

        System.out.println(
            "Sum of this two number are: "
            + worker.sumOfTwoNumber(firstNumber, secondNumber)
            + ";"
        );

        System.out.println(hashtag.repeat(30));
    }

    private static void computeDeposit(Worker worker) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(hashtag.repeat(30));
        System.out.println("# Compute your deposit.      #");
        System.out.println(hashtag.repeat(30));
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        int depositAmount = parseInteger(scanner, "Enter the deposit amount");

        System.out.print("So, " + capitalize(firstName) + ' ' + capitalize(lastName) + ", ");
        System.out.println("your deposit amount: " + depositAmount + '.');
        System.out.println(
            "For one year, the amount of the deposit will be: "
            + worker.computeDeposit(depositAmount, 1, percent)
        );
        System.out.println(
            "For five year, the amount of the deposit will be: "
            + worker.computeDeposit(depositAmount, 5, percent)
        );
        System.out.println(
            "For ten years, the amount of the deposit will be: "
            + worker.computeDeposit(depositAmount, 10, percent)
        );
    }

    private static int parseInteger(
        Scanner scanner,
        String inputText
    ) {
        while (true) {
            System.out.println(inputText + ":");

            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer number.");
                scanner.nextLine();
            }
        }
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
