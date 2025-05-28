import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n > 1){
            PeneiraEratosthenes(n);
            n = sc.nextInt();
        }
        sc.close();
    }
    public static void PeneiraEratosthenes (int n){
        int i, j, div;
        int tam = n-1;
        int[] vet = new int[tam];

        for(i=0; i<tam; i++) {
            vet[i] = i + 2;
        }

        for(i=0; i<tam; i++) {
            if(vet[i]>0) {
                div = vet[i];
                for (j=i+1;j<tam;j++) {
                    if(vet[j] % div == 0) {
                        vet[j] = 0;
                    }
                }
            }
        }

        for(i=0;i<tam;i++) {
            if(vet[i] != 0) {
                System.out.print(vet[i] + " ");
            }
        }

    }
}