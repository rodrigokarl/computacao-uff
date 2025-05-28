public class Main {
    public static void main(String[] args) {
        Ingresso ingresso1 = new Ingresso(120.0);
        IngressoVIP vip1 = new IngressoVIP(120.0);
        System.out.println("Valores dos ingressos: \n Comum: " + ingresso1.valor + "\n VIP: " + vip1.getValor());
    }
}