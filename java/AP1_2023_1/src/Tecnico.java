public class Tecnico extends Empregado {
    public Tecnico(String nome, double salario, int anoContratacao) {
        super(nome, salario, anoContratacao);
    }

    @Override
    public void imprimirPapel() {
        System.out.println("Eu sou técnico(a).");
    }

}