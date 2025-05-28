public class Main {
    public static void main(String[] args) {
        Secretario sec1 = new Secretario("Astolfo", 100.0, 2020);
        Gerente gen1 = new Gerente("Arnaldo", 2500.0, 2016, sec1);
        Tecnico tec1 = new Tecnico("Adonai", 2000.0, 2021);
        Tecnico tec2 = new Tecnico("Animal", 2000.0, 2020);
        Tecnico tec3 = new Tecnico("Arilson", 2000.0, 2019);
        Tecnico tec4 = new Tecnico("Apolinario", 2000.0, 2022);
        gen1.addTecnico(tec1);
        gen1.addTecnico(tec2);
        gen1.addTecnico(tec3);
        gen1.addTecnico(tec4);
        sec1.imprimirPapel();
        tec1.imprimirPapel();
        tec2.imprimirPapel();
        tec3.imprimirPapel();
        tec4.imprimirPapel();
        gen1.imprimirPapel();
    }
}