public class Gerente extends Empregado {
    private Secretario secretario;
    Tecnico[] tecnicos = new Tecnico[50];
    int numTec = 0;
    public Gerente(String nome, double salario, int anoContratacao, Secretario secretario) {
        super(nome, salario, anoContratacao);
        this.secretario = secretario;
    }

    @Override
    public void aumentarSalario(double porcentagem) {
        if (secretario != null) {
            secretario.setSalario(secretario.getSalario() * (porcentagem / 100));
        }

        for (int i = 0; i < tecnicos.length; i++) {
            if (tecnicos[i] != null) {
                tecnicos[i].setSalario(tecnicos[i].getSalario() * (porcentagem / 100));
            }
        }
    }

    public void addTecnico(Tecnico tecnico) {
        tecnicos[numTec] = tecnico;
        numTec++;
    }

    @Override
    public void imprimirPapel() {
         System.out.println("Eu sou gerente e tenho " + this.secretario.getNome() + " como secretário(a) e mais " + numTec + " técnicos(as) sob meu comando.");
    }
}