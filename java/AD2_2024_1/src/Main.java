import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static String tmpdir = "C:\\Users\\rodri\\IdeaProjects\\AD2_2024_1\\src\\";
    public static void main(String[] args) {

        Scanner entradaInicial = new Scanner(System.in);
        Scanner entradaSecundaria = new Scanner(System.in);

        System.out.println("Seja bem-vindo(a)!");
        System.out.println("Quantas unidades serão cadastradas?");
        int num = entradaInicial.nextInt();
        String[] arquivos = new String[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Arquivo da unidade " + (i + 1) + ":");
            arquivos[i] = entradaSecundaria.nextLine();

            try {

                BufferedReader entrada = new BufferedReader(new FileReader(tmpdir + arquivos[i]));
                String linha;
                while ((linha = entrada.readLine()) != null) {

                    if (linha.contains("Unidade")) {
                        Cardapio.cardapios.add(new Cardapio(linha));
                    }
                    else {
                        String[] dados = linha.split(";");
                        for (int j = 0; j < dados.length; j++) {
                            dados[j] = dados[j].trim();
                        }
                        Cardapio.cardapios.get(Cardapio.cardapios.size() - 1).adicionaPrato(new Prato(dados[0], Float.parseFloat(dados[1]), dados[2]));
                    }

                }
                entrada.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

        boolean rodando = true;
        while (rodando) {
            Scanner entradaTres = new Scanner(System.in);
            Scanner entradaQuatro = new Scanner(System.in);

            System.out.println("Escolha uma categoria, ou digite \"0\" para encerrar: ");
            String resposta = entradaTres.nextLine();

            String info;

            switch (resposta.toLowerCase()) {
                case "0":
                    rodando = false;
                    break;
                case "entrada", "prato principal", "sobremesa":
                    System.out.println(Cardapio.buscaCardapio(resposta));
                    System.out.println("Exibir detalhes (\"s\" ou \"n\")? ");
                    info = entradaQuatro.next();
                    switch (info.toLowerCase()) {
                        case "s":
                            System.out.println(Cardapio.detalhaCardapio(resposta));
                            break;
                        case "n":
                            break;
                    }
                    break;
                default:
                    System.out.println("Categoria não encontrada.\n");
            }
        }
    }
}
