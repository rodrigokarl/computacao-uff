import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int resposta = (int)(Math.random() * 10) + 1;
        Scanner scan = new Scanner(System.in);

        for (int i=5; i>0; i--) {
            System.out.print("Bem vindo ao jogo\nDigite um número inteiro entre 1 e 10.\nVocê tem " + i + " tentativas.");
            int tentativa = scan.nextInt();
            if (tentativa == resposta) {
                System.out.println("Parabéns, você acertou!");
                break;
            }
            else if (tentativa > resposta) {
                System.out.println("O número digitado é maior do que a resposta.");
            }
            else {
                System.out.println("O número digitado é menor do que a resposta.");
            }
        }
    }
}