import java.util.*;

public class Luminaria {
    List<Lampada> lampadas;

    public void adicionaLampada(Lampada l) {
        lampadas.add(l);
    }

    public String toString() {
        String saida = "Esta luminária possui " + lampadas.size() +
                "lâmpadas e seus estados são:";
        for (Lampada l : lampadas)
            saida = saida + l.toString() + "\n";
        return saida;
    }

    public Luminaria() {
        lampadas = new ArrayList();
    }
}
