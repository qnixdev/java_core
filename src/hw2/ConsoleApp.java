package hw2;

import java.util.Scanner;

public class ConsoleApp {
    public static void main(String[] args) {
        String reportText = "the amount of the deposit will be:";
        Scanner scanner = new Scanner(System.in);

        System.out.println("** Compute your deposit. **");

        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter the deposit amount:");
        double depositAmount = scanner.nextDouble();

        System.out.print("So, " + capitalize(firstName) + ' ' + capitalize(lastName) + ", ");
        System.out.println("your deposit amount: " + depositAmount + '.');
        System.out.println(
            "For one year, "
            + reportText
            + computeDeposit(depositAmount, 1)
        );
        System.out.println(
            "For five year, "
            + reportText
            + computeDeposit(depositAmount, 5)
        );
        System.out.println(
            "For ten years, "
            + reportText
            + computeDeposit(depositAmount, 10)
        );

        System.out.println();
    }

    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private static double computeDeposit(
        double depositAmount,
        int numberOfYears
    ) {
        final int countDays = numberOfYears * 365;
        final double percentByDay = 0.17 / 365;
        depositAmount += (depositAmount * percentByDay) * countDays;

        return depositAmount;
    }
}
