public class Main {
    public static void main(String[] args) {
        Processador cpu1 = new Processador("Intel Core i5", 790.0);
        Processador cpu2 = new Processador("Intel Core i7", 1599.99);
        Processador cpu3 = new Processador("AMD Ryzen 5", 489.90);
        PenteMemoria mem1 = new PenteMemoria("Kingston", 8, 109.0);
        PenteMemoria mem2 = new PenteMemoria("Corsair", 32, 449.99);
        PenteMemoria mem3 = new PenteMemoria("Corsair", 32, 449.99);
        MonitorVideo mon1 = new MonitorVideo("Monitor LED", 17.0, 379.0);
        MonitorVideo mon2 = new MonitorVideo("Philips", 19.5, 590.0);
        Teclado tec1 = new Teclado("Teclado USB", 30.0);
        Teclado tec2 = new Teclado("Teclado Bluetooth", 99.99);

        Gabinete gab1 = new Gabinete("Super Dragon");
        Gabinete gab2 = new Gabinete("Power Gamer");

        Computador com1 = new Computador("Super Dragon Completo");
        Computador com2 = new Computador("Power Gamer Completo");

        gab1.inclui(cpu1);
        gab1.inclui(mem1);
        gab1.inclui(mem2);
        gab2.inclui(cpu2);
        gab2.inclui(mem3);

        com1.inclui(gab1);
        com1.inclui(mon1);
        com2.inclui(gab2);
        com2.inclui(mon2);
        com2.inclui(tec2);

        System.out.println(com1);

        System.out.println(com2);

    }
}