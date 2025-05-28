public class Lampada {
    // Atributos
    // acesa e funcionando estão encapsuladas
    private boolean acesa;
    String tipo;
    int potencia;
    private boolean funcionando;

    public void acender() {
        this.acesa = true;
    }
    public void apagar() {
        this.acesa = false;
    }
    public void queimar() {
        this.funcionando = false;
    }
    public void consertar() {
        this.funcionando = true;
    }

    // Construtor (auxilia construção de objetos)
    public Lampada(boolean estado, String tipo, int potencia, boolean funcionando) {
        this.acesa = estado;
        this.tipo = tipo;
        this.potencia = potencia;
        this.funcionando = funcionando;
    }

    // Redefinição do método toString da classe Object
    public String toString() {
        return "A lâmpada está " +
                (this.acesa ? "acesa" : "apagada") +
                ", é do tipo " + this.tipo +
                ", possui potência de " + this.potencia + " watts " +
                "e" + (!this.funcionando ? " não" : "") + " está funcionando";
    }
}
