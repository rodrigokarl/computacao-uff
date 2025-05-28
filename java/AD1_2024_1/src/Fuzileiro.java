public class Fuzileiro extends Combatente {
    public Fuzileiro(String nome, int idade, String matricula, int tempoServico, double salarioBruto, int totalMortes) {
        super(nome, idade, matricula, tempoServico, salarioBruto, totalMortes);
    }

    //calculo de salario e gratificacao conforme enunciado
    @Override
    public double calculaSalario() {
        return getSalarioBruto() + (getSalarioBruto() * getTempoServico() * 0.03) + calculaGratificacao(getTotalMortes());
    }

    @Override
    public double calculaGratificacao(int mortes) {
        return (45.00 * mortes * TXGRATIFICACAO);
    }

}
