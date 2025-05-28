public class PenteMemoria extends ItemAvulso {
    private final int capacidadeGb;
    protected PenteMemoria(String descricao, int capacidadeGb, double preco) {
        super(descricao, preco);
        this.capacidadeGb = capacidadeGb;
    }

    public int getCapacidadeGb() {
        return capacidadeGb;
    }

    @Override
    public String toString() {
        return this.getDescricao() + "; Capacidade: " + getCapacidadeGb() + " GB; Preço: " + getPreco();
    }
}
