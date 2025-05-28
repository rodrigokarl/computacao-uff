//import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String... args) {
        System.out.println(inverte(1234));
    }

    public static int inverte(int num) {
        Queue<Integer> fila = new LinkedList<Integer>();

        do {
            int resto = num % 10;
            num /= 10;
            fila.offer(resto);
        } while (num > 0);

        for (int i=1; !fila.isEmpty(); i *= 10)
            num += fila.poll() * i;

        return num;
    }

}
