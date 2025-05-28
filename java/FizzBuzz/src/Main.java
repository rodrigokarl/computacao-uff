import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Number: ");
        byte entrada = input.nextByte();

        if (entrada % 5 == 0 && entrada % 3 == 0) {
            System.out.println("FizzBuzz");
        } else if (entrada % 3 == 0) {
            System.out.println("Buzz");
        } else if (entrada % 5 == 0) {
            System.out.println("Fizz");
        }
        else {
            System.out.println(entrada);
        }
    }
}