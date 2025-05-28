public class MonitorVideo extends ItemAvulso {
    private final double resolucaoPol;
    public MonitorVideo(String descricao, double resolucaoPol, double preco) {
        super(descricao, preco);
        this.resolucaoPol = resolucaoPol;
    }

    public double getResolucaoPol() {
        return resolucaoPol;
    }

    @Override
    public String toString() {
        return this.getDescricao() + "; Resolução: " + getResolucaoPol() + "\"; Preço: " + getPreco();
    }
}
