package hw2;

public class Worker {
    private static final int daysInYear = 365;

    public int sumOfTwoNumber(
        int firstNumber,
        int secondNumber
    ) {
        return firstNumber + secondNumber;
    }

    public double computeDeposit(
        double depositAmount,
        int numberOfYears,
        int percentByYear
    ) {
        final int countDays = numberOfYears * daysInYear;
        final double percentByDay = (double) percentByYear / 100 / daysInYear;
        depositAmount += (depositAmount * percentByDay) * countDays;

        return depositAmount;
    }
}