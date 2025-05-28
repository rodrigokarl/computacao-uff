public abstract class Item {
    private final String descricao;
    protected Item(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract double getPreco();
}
