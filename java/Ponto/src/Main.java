public class Main {
    public static void main(String[] args) {
        Ponto p1 = new Ponto(0, 0);
        Ponto p2 = new Ponto(10, 20);
        p1.move(3, 25);
        p2.move(1, 14);
        System.out.println(p1.distancia(p2));
    }
}