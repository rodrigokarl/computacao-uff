import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {

            BufferedReader entrada = new BufferedReader(new FileReader(args[0]));
            String linha;

            while ((linha = entrada.readLine()) != null) {
                String[] dados = linha.split("/");
                BufferedWriter saida = new BufferedWriter(new FileWriter(dados[1] + ".txt", true));
                try {
                    saida.write(dados[0] + "\n");
                }
                finally {
                    saida.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}