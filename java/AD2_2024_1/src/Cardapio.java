import java.util.ArrayList;

public class Cardapio {
    public static ArrayList<Cardapio> cardapios = new ArrayList<>();
    public ArrayList<Prato> pratos = new ArrayList<>();
    public String nomeUnidade;

    public Cardapio(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public void adicionaPrato(Prato novoPrato) {
        pratos.add(novoPrato);
    }

    public static String buscaCardapio(String categoria) {
        String saida = "";
        int totalItem = 0;
        float totalPreco = 0;

        for (Cardapio cardapio : Cardapio.cardapios) {
            int countItem = 0;
            float countPreco = 0;

            for (Prato item : cardapio.pratos) {
                if (item.getCategoria().equalsIgnoreCase(categoria)) {
                    countItem++;
                    countPreco += item.getPreco();
                }
            }

            totalItem += countItem;
            totalPreco += countPreco;
            saida += cardapio.nomeUnidade + ": Quantidade = " + countItem + ", Preço = R$ " + countPreco + "\n";

        }
        saida += "Total: Quantidade = " + totalItem + ", Preço = R$ " + totalPreco + "\n";
        return saida;
    }

    public static String detalhaCardapio(String categoria) {
        String saida = "";

        for (Cardapio cardapio : Cardapio.cardapios) {

            saida += cardapio.nomeUnidade + ":\n";

            for (Prato prato : cardapio.pratos) {
                if (prato.getCategoria().equalsIgnoreCase(categoria)) {
                    saida += prato.exibePrato() + "\n";
                }

            }
            saida += "\n";
        }
        return saida;
    }
}
