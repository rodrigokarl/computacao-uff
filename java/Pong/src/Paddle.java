import java.awt.*;
public class Paddle {
    //variáveis de instância
    private int height, x, y, speed;
    private Color color;

    //constante
    static final int PADDLE_WIDTH = 15;

    //construtor
    public Paddle(int x, int y, int height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    //pintar o retângulo
    public void paint(Graphics g) {
        //pinta o retângulo do jogador
        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, height);
    }

    //movimentação dos Paddles
    public void moveTowards(int moveToY) {
        //achar as coordenadas do centro do Paddle
        int centerY = y + height / 2;

        //determinar se é necessário mover mais do que a velocidade
        if (Math.abs(centerY - moveToY) > speed) {
            //se o centro do Paddle estiver abaixo
            if (centerY > moveToY) {
                //movimentar o Paddle para cima
                y -= speed;
            }
            //se o centro do Paddle estiver acima
            if (centerY < moveToY) {
                //movimentar o Paddle para baixo
                y += speed;
            }
        }
    }

    //retorna true se for detectada colisão com a bola b
    public boolean checkCollision(Ball b) {
        int rightX = x + PADDLE_WIDTH;
        int bottomY = y + height;

        //checar se a bola está entre os valores de x
        if (b.getX() > (x - b.getSize()) && b.getX() < rightX) {
            //checar se a bola está entre os valores de y
            if (b.getY() > y && b.getY() < bottomY) {
                //se chegamos até aqui existiu a colisão
                return true;
            }
        }

        //se chegamos até aqui, não houve colisão
        return false;
    }
}
