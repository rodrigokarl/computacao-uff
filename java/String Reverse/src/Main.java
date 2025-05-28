import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine();
        System.out.println("O inverso da palavra '" + palavra + "' é: ");
        int x = palavra.length();
        while (x > 0) {
            System.out.print(palavra.charAt(x - 1));
            x--;
        }

    }

}