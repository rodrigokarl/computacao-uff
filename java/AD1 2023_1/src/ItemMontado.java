import java.util.ArrayList;

public abstract class ItemMontado extends Item {
    private final ArrayList<Item> partes;
    protected ItemMontado(String descricao) {
        super(descricao);
        this.partes = new ArrayList<>();
    }

    @Override
    public double getPreco() {
        double soma = 0.0;
        for(int i=0; i < partes.size(); i++) {
            soma += partes.get(i).getPreco();
        }

        return soma;
    }

    public void inclui(Item item) {
        this.partes.add(item);
    }

    @Override
    public String toString() {
        String txt = this.getDescricao() + "; Preço: " + getPreco() + "\nPartes:";
        for(int i=0; i < partes.size(); i++) {
            txt += "\n" + partes.get(i);
        }
        return txt;
    }
}
