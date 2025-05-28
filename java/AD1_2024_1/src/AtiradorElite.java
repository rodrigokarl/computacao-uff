public class AtiradorElite extends Combatente {
    private int pontoPrecisao;

    public int getPontoPrecisao() {
        return pontoPrecisao;
    }

    public AtiradorElite(String nome, int idade, String matricula, int tempoServico, double salarioBruto, int totalMortes, int pontoPrecisao) {
        super(nome, idade, matricula, tempoServico, salarioBruto, totalMortes);
        this.pontoPrecisao = pontoPrecisao;
    }

    //calculo de salario e gratificacao conforme enunciado
    @Override
    public double calculaSalario() {
        return getSalarioBruto() + (getSalarioBruto() * getTempoServico() * 0.05) + calculaGratificacao(getTotalMortes());
    }

    @Override
    public double calculaGratificacao(int mortes) {
        return (45.00 * mortes * TXGRATIFICACAO) + (7.00 * getPontoPrecisao());
    }
}
