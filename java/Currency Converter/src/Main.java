import java.util.Objects;
import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        final double USD = 4.83;

        String moedas = "BRL, USD";

        Scanner scan = new Scanner(System.in);

        NumberFormat nf1 = NumberFormat.getCurrencyInstance();

        System.out.println("Conversor de moedas");

        System.out.print("Digite o valor: ");
        double valor = scan.nextDouble();

        System.out.print("Digite a moeda de entrada (" + moedas + "): ");
        String entrada = scan.next();

        System.out.print("Digite a moeda de saída (" + moedas + "): ");
        String saida = scan.next();

        double valorConvertido;

        if (Objects.equals(entrada, "BRL") && Objects.equals(saida, "USD")) {
            valorConvertido = valor * USD;
        }
        else {
            valorConvertido = valor / USD;
        }

        System.out.println("O valor " + nf1.format(valor) + " em " + entrada + " convertido para " + saida + " eh: " + nf1.format(valorConvertido));
    }
}