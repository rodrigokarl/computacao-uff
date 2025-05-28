import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//https://kevinsguides.com/guides/code/java/javaprojs/simple-2d-pong

public class Main {

    //declarar e inicializar o frame
    static JFrame f = new JFrame("Pong");

    public static void main(String[] args) {
        //fazer o programa terminar ao fechar a janela
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //o tamanho do JFrame deverá ser um pouco maior que o do jogo
        f.setSize(670, 510);

        //instanciar o novo PongGame
        PongGame game = new PongGame();

        //adicionar o jogo ao JFrame
        f.add(game);

        //mostrar a janela
        f.setVisible(true);

        //criar um Timer
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lógica do jogo
                game.gameLogic();

                //pintar a tela
                game.repaint();
            }
        });

        //inicia o timer
        timer.start();
    }
}