import java.util.Random;
public class Texto {
    private Frase conteudo[];
    private int tamanho;

    public Texto() {
        this.conteudo = new Frase[1000];
        this.tamanho = 0;
    }

    public Texto(String texto) {
        this();
        String frases[] = texto.split("\\.");
        for (String s : frases) {
            this.adicionaFrase((s + ".").trim());
        }
    }

    public Texto adicionaFrase(Frase f) {
        this.conteudo[this.tamanho] = f;
        this.tamanho++;
        return this;
    }

    public Texto adicionaFrase(String s) {
        this.adicionaFrase(new Frase(s));
        return this;
    }

    public int getQuantidadePalavras() {
        int qtdPalavras = 0;
        for(int i=0; i<this.tamanho; i++) {
            qtdPalavras += conteudo[i].getQuantidadePalavras();
        }
        return qtdPalavras;
    }

    public int getTempoEstimadoLeitura() {
        return (this.getQuantidadePalavras() / 200) + 1;
    }

    public Texto getFrasesCom(String palavra) {
        Texto texto = new Texto();
        for(int i=0; i<this.tamanho; i++) {
            if (conteudo[i].contem(palavra)) {
                texto.adicionaFrase(conteudo[i]);
            }
        }
        return texto;
    }

    public Frase getFraseAleatoria() {
        return conteudo[new Random().nextInt(this.tamanho - 1)];
    }

    public void substitui(String string, String string2) {
        for(int i=0; i<this.tamanho; i++) {
            conteudo[i].substitui(string, string2);
        }
    }

    public String toString() {
        String saida = "";
        for(int i=0; i<this.tamanho; i++) {
            saida += conteudo[i] + " ";
        }
        return saida;
    }
}
