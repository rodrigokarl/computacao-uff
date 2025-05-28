import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // definição de constantes
        final byte MESES_NO_ANO = 12;
        final byte PORCENTO = 100;

        // instanciando o scanner
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal ($1K - $1M): ");
        int valor;
        while (true) {
            valor = scanner.nextInt();
            if (valor >= 1_000 && valor <= 1_000_000) {
                break;
            }
            else {
                System.out.println("Enter a number between 1.000 and 1.000.000");
            }
        }

        System.out.print("Annual Interest Rate: ");
        double jurosAnual;
        while (true) {
            jurosAnual = scanner.nextDouble();
            if (jurosAnual > 0 && jurosAnual <= 30) {
                break;
            }
            else {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            }
        }

        double jurosMensal = jurosAnual / PORCENTO / MESES_NO_ANO;

        System.out.print("Period (Years): ");
        byte anos;
        while (true) {
            anos = scanner.nextByte();
            if (anos > 1 && anos <= 30) {
                break;
            }
            else {
                System.out.println("Enter a value between 1 and 30.");
            }
        }

        int numeroParcelas = anos * MESES_NO_ANO;

        // calculando os juros compostos
        double hipoteca = valor * (jurosMensal * Math.pow(1 + jurosMensal, numeroParcelas)) / (Math.pow(1 + jurosMensal, numeroParcelas) - 1);

        String hipotecaFormatada = NumberFormat.getCurrencyInstance().format(hipoteca);

        System.out.println("Mortgage: " + hipotecaFormatada);
    }
}