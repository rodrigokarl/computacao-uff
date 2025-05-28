public class Frase {
    private String conteudo;
    public Frase(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getQuantidadePalavras() {
        return this.conteudo.split("\\s").length;
    }

    public boolean contem(String palavra) {
        return this.conteudo.contains(palavra);
    }

    public void substitui(String string, String string2) {
        this.conteudo = this.conteudo.replace(string, string2);
    }

    public String toString() {
        return this.conteudo;
    }

}
