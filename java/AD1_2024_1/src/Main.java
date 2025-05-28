import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //input do menu
        Scanner scan = new Scanner(System.in);

        //input interno das opcoes
        Scanner innerScan = new Scanner(System.in);

        //array de objetos
        Combatente[] soldierTotal = new Combatente[100];

        //para controle dos objetos do array
        int soldierCount = 0;

        //quantidade de zumbis mortos
        int qtdZombiesKilled = 0;
        int qtdZombiesKilledMerc = 0;

        //resposta dos parametros de criacao para fuzileiro e atirador de elite
        String[] param;

        //valor total a ser pago
        double totalPagamento = 0;

        //boolean para sair do loop
        boolean rodando = true;

        //implementacao do menu
        while (rodando) {

            System.out.println("Bem vindo ao sistema de gestão de Combatentes");
            System.out.println("Digite uma opção");
            System.out.println("1 - Cadastrar Fuzileiro");
            System.out.println("2 - Cadastrar Atirador de Elite");
            System.out.println("3 - Cadastrar Mercenário");
            System.out.println("4 - Consultar número de zumbis abatidos");
            System.out.println("5 - Calcular folha de pagamento");
            System.out.println("0 - Sair do programa");

            //resposta da opcao do menu
            int resposta = scan.nextInt();

            /* Nao implementei try/catch nas respostas do menu pois achei que iria tornar
            mais complexo o codigo, possivelmente usando estruturas de fora do conteudo
            desta primeira avaliacao. Tratamento de excessoes encontra-se na aula 10 */

            switch (resposta) {
                case 0:
                    //sair do programa
                    rodando = false;
                    break;
                case 1:
                    //adicionar fuzileiro
                    System.out.println("Digite as informações sobre o Fuzileiro (separados por vírgula)");
                    System.out.println("Nome (string), idade (inteiro), matrícula (string), tempo de serviço (inteiro), salário bruto (double) e número de zumbis mortos (inteiro)");
                    param = innerScan.nextLine().trim().split("\\s*,\\s*");
                    soldierTotal[soldierCount] = new Fuzileiro(param[0], Integer.parseInt(param[1]), param[2], Integer.parseInt(param[3]), Double.parseDouble(param[4]), Integer.parseInt(param[5]));
                    soldierCount++;
                    break;
                case 2:
                    //adicionar atirador de elite
                    System.out.println("Digite as informações sobre o Atirador de Elite (separados por vírgula)");
                    System.out.println("Nome (string), idade (inteiro), matrícula (string), tempo de serviço (inteiro), salário bruto (double), número de zumbis mortos (inteiro) e ponto de precisão (inteiro)");
                    param = innerScan.nextLine().trim().split("\\s*,\\s*");
                    soldierTotal[soldierCount] = new AtiradorElite(param[0], Integer.parseInt(param[1]), param[2], Integer.parseInt(param[3]), Double.parseDouble(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6]));
                    soldierCount++;
                    break;
                case 3:
                    //adicionar mercenário
                    System.out.println("Nome (string), idade (inteiro), matrícula (string), tempo de serviço (inteiro), salário bruto (double) e número de zumbis mortos (inteiro)");
                    param = innerScan.nextLine().trim().split("\\s*,\\s*");
                    soldierTotal[soldierCount] = new Mercenario(param[0], Integer.parseInt(param[1]), param[2], Integer.parseInt(param[3]), Double.parseDouble(param[4]), Integer.parseInt(param[5]));
                    soldierCount++;
                    break;
                case 4:
                    //retorna o total de zumbis mortos por cada combatente cadastrado
                    for (int j=0; j<soldierTotal.length; j++) {
                        if (soldierTotal[j] != null) {
                            if (soldierTotal[j].getClass() == Mercenario.class) {
                                qtdZombiesKilledMerc += soldierTotal[j].getTotalMortes();
                            }
                            else {
                                qtdZombiesKilled += soldierTotal[j].getTotalMortes();
                            }
                        }
                    }
                    System.out.println("Número atual de abates de zumbis:\nSoldados brasileiros mataram " + qtdZombiesKilled + " zumbis\nMercenários mataram " + qtdZombiesKilledMerc + " zumbis");
                    break;
                case 5:
                    //calcular folha de pagamento
                    for (int i=0; i<soldierTotal.length; i++) {
                        if (soldierTotal[i] != null) {
                            totalPagamento += soldierTotal[i].calculaSalario();
                        }
                    }
                    System.out.println("Após o fechamento da folha, o total a ser pago é: R$: " + totalPagamento);
                    rodando = false;
                    break;
            }
        }
    }
}