public class Secretario extends Empregado {
    public Secretario(String nome, double salario, int anoContratacao) {
        super(nome, salario, anoContratacao);
    }

    @Override
    public void imprimirPapel() {
        System.out.println("Eu sou secretário(a).");
    }

}