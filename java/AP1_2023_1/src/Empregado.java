public abstract class Empregado {
    private String nome;
    private double salario;
    private int anoContratacao;

    public Empregado(String nome, double salario, int anoContratacao) {
        this.nome = nome;
        this.salario = salario;
        this.anoContratacao = anoContratacao;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setSalario(double novoSalario) {
        this.salario = novoSalario;
    }

    public void aumentarSalario(double porcentagem) {
        this.salario *= porcentagem / 100;
    };

    public abstract void imprimirPapel();
}