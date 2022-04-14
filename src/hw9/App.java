package hw9;

public class App {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        int inputOne = 2;
        System.out.println(fibonacciSequence.simpleFibonacci(inputOne));

        int inputTwo = 3;
        System.out.println(fibonacciSequence.simpleFibonacci(inputTwo));

        int inputThree = 4;
        System.out.println(fibonacciSequence.simpleFibonacci(inputThree));

        // test long input
        int inputBigNumberOne = 64;
        System.out.println(fibonacciSequence.fibonacciWithMemorization(inputBigNumberOne));

        int inputBigNumberTwo = 100;
        System.out.println(fibonacciSequence.fibonacciWithMemorization(inputBigNumberTwo));
    }
}