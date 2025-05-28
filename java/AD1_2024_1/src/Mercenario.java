public class Mercenario extends Combatente {

    public Mercenario(String nome, int idade, String matricula, int tempoServico, double salarioBruto, int totalMortes) {
        super(nome, idade, matricula, tempoServico, salarioBruto, totalMortes);
    }

    //calculo de salario e gratificacao conforme enunciado
    //Considerando que Mercenario nao possui salario fixo
    @Override
    public double calculaSalario() {
        return calculaGratificacao(getTotalMortes());
    }

    @Override
    public double calculaGratificacao(int mortes) {
        return (30.00 * TXCONVERSAO * TXGRATIFICACAO * mortes);
    }

}
