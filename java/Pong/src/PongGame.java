import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class PongGame extends JPanel implements MouseMotionListener {
    //constantes para resolução do jogo
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userScore, pcScore;
    private int bounceCount;
    private int userMouseY;

    public PongGame() {
        gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED);
        userMouseY = 0;
        userScore = 0;
        pcScore = 0;
        bounceCount = 0;

        //monitorar eventos de movimento
        addMouseMotionListener(this);
    }

    //método para desenhar os objetos
    public void paintComponent(Graphics g) {
        //desenha o plano de fundo, cor preta, preenchimento do retângulo
        g.setColor(Color.BLACK);
        g.fillRect(0,0, WINDOW_WIDTH, WINDOW_HEIGHT);

        //desenha a bola
        gameBall.paint(g);

        //desenha os Paddles
        userPaddle.paint(g);
        pcPaddle.paint(g);

        //atualiza o placar
        g.setColor(Color.WHITE);

        //o método drawString precisa de uma string e uma localização
        g.drawString("Placar - Player [ " + userScore + " ] - CPU [ " + pcScore + " ]", 250, 20);
    }

    public void gameLogic() {
        //mover a bola
        gameBall.moveBall();

        //checagem das bordas
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);

        //move o Paddle na direção do mouse
        userPaddle.moveTowards(userMouseY);

        //move o Paddle da IA na direção de y
        pcPaddle.moveTowards(gameBall.getY());

        //checagem de colisão da bola com os Paddles
        if (pcPaddle.checkCollision(gameBall) || userPaddle.checkCollision(gameBall)) {
            //reverte a direção da bola se houver colisão
            gameBall.reverseX();
            //incrementa a contagem de colisões
            bounceCount++;
        }

        //quando ocorrem 5 colisões
        if (bounceCount == 5) {
            //reseta o contador
            bounceCount = 0;
            //aumenta a velocidade
            gameBall.increaseSpeed();
        }

        //checagem de placar
        if (gameBall.getX() < 0) {
            //player levou gol
            pcScore++;
            reset();
        }
        else if (gameBall.getX() > WINDOW_WIDTH) {
            //CPU levou gol
            userScore++;
            reset();
        }
    }

    //reseta a tela após um gol
    public void reset() {
        //pausa por um segundo
        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //reseta a bola
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(3);
        bounceCount = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }
}
