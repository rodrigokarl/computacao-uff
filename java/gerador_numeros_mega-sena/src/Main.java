import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        SecureRandom rand = new SecureRandom();
        int teto = 61;
        int[] numeros = new int[6];

        for(int i=0; i<6; i++) {
            int num = rand.nextInt(teto);
            if(num != 0) {
                numeros[i] = num;
            }
        }

        Arrays.sort(numeros);

        for(int j=0; j<numeros.length; j++) {
            System.out.println(numeros[j]);
        }

    }
}