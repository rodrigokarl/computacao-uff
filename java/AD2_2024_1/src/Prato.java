public class Prato {
    private String nome, categoria;
    private float preco;
    public Prato(String nome, float preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }
    public String getNome() {
        return nome;
    }
    public float getPreco() {
        return preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public String exibePrato() {
        return this.getCategoria() + " " + this.getNome() + " -> R$ " + this.getPreco();
    }
}
