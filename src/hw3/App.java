package hw3;

public class App {
    public static void main(String[] args) {
        Reverse reverse = new Reverse("ZюукяДZіботZ,ежобZощZяZенZ!ьлаксом");
        System.out.println("Task one:");
        System.out.println(reverse.reverseString());
        System.out.println();
        Calculator calculator = new Calculator();
        System.out.println("Task two:");
        calculator.run();
    }
}
