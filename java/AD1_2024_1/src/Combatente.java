public abstract class Combatente {
    private String nome, matricula;
    private int idade, tempoServico, totalMortes;
    private double salarioBruto;
    final double TXGRATIFICACAO = 0.10;
    final double TXCONVERSAO = 5.00;

    //getters
    public int getTempoServico() {
        return tempoServico;
    }
    public double getSalarioBruto() {
        return salarioBruto;
    }
    public int getTotalMortes() {
        return totalMortes;
    }

    //construtor para fuzileiros e atiradores de elite
    public Combatente(String nome, int idade, String matricula, int tempoServico, double salarioBruto, int totalMortes) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.tempoServico = tempoServico;
        this.salarioBruto = salarioBruto;
        this.totalMortes = totalMortes;
    }

    public abstract double calculaSalario();

    public abstract double calculaGratificacao(int mortes);
}
