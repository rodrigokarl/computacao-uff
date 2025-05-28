public class Main {
    public static void main(String[] args) {
        Lampada l = new Lampada(false, "led", 60, true);
        l.acender();
        l.queimar();
        // System.out.println(l);
        Lampada l2 = new Lampada(false, "led", 80, true);
        Luminaria lumi = new Luminaria();
        lumi.adicionaLampada(l);
        lumi.adicionaLampada(l2);
        System.out.println(lumi.toString());
    }
}
