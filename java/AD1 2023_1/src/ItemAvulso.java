public abstract class ItemAvulso extends Item {
    private double preco;
    protected ItemAvulso(String descricao, double preco) {
        super(descricao);
        this.setPreco(preco);
    }
    @Override
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return this.getDescricao() + "; Preço: " + getPreco();
    }
}
