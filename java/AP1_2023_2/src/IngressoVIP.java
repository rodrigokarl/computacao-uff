public class IngressoVIP extends Ingresso {
    public IngressoVIP(double valor) {
        super(valor * 1.1);
    }

    public double getValor() {
        return valor;
    }
}
