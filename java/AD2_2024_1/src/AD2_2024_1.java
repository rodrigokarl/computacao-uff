import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AD2_2024_1 {

    public static void main(String[] args) {

        String tmpdir = "C:\\Users\\rodri\\IdeaProjects\\AD2_2024_1\\src\\";

        String[] arquivos = {"cardapio1.txt", "cardapio2.txt", "cardapio3.txt"};

        for (int i = 0; i < arquivos.length; i++) {

            try {

                BufferedReader entrada = new BufferedReader(new FileReader(tmpdir + arquivos[i]));
                String linha;
                while ((linha = entrada.readLine()) != null) {

                    if (linha.contains("Unidade")) {
                        Cardapio.cardapios.add(new Cardapio(linha));
                    } else {
                        String[] dados = linha.split(";");
                        for (int j = 0; j < dados.length; j++) {
                            dados[j] = dados[j].trim();
                        }
                        Cardapio.cardapios.get(Cardapio.cardapios.size() - 1).adicionaPrato(new Prato(dados[0], Float.parseFloat(dados[1]), dados[2]));
                    }

                }
                entrada.close();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        System.out.println(Cardapio.buscaCardapio("Prato Principal"));
        System.out.println(Cardapio.detalhaCardapio("Prato Principal"));

    }

}
