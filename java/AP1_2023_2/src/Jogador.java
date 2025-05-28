import java.util.Calendar;

public class Jogador {
    private String nome;
    private String posicao;
    private Calendar nascimento;
    private String nacionalidade;
    private int altura;
    private int peso;

    public Jogador(String nome, String posicao, Calendar nascimento, String nacionalidade, int altura, int peso) {
        this.nome = nome;
        this.posicao = posicao;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
        this.altura = altura;
        this.peso = peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public void imprimir() {
        System.out.println("Nome: " + getNome() + ", posição: " + getPosicao() + ", nascimento: " + getNascimento() + ", nacionalidade: " + getNacionalidade() + ", altura: " + getAltura() + ", peso: " + getPeso() + ".");
    }

    public int getIdade() {
        Calendar hoje = Calendar.getInstance();
        return hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
    }

    public int calculoAposentadoria() {
        switch (posicao.toLowerCase()) {
            case "defesa" -> {
                return 40 - getIdade();
            }
            case "meio-campo" -> {
                return 38 - getIdade();
            }
            case "atacante" -> {
                return 35 - getIdade();
            }
        }
        return 0;
    }
}
