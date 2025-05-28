import java.awt.*;
public class Ball {
    //declaração das variáveis instanciadas
    private int x, y, cx, cy, speed, size;
    private Color color;

    static final int MAX_SPEED = 7;

    //construtor da classe Ball atribui valor às variáveis instanciadas
    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }

    public void paint(Graphics g) {
        //define a cor da bola
        g.setColor(color);

        //preenche a bola com a cor
        g.fillOval(x, y, size, size);
    }

    public void moveBall() {
        x += cx;
        y += cy;
    }

    public void bounceOffEdges(int top, int bottom) {
        //valor do y na parte de baixo da tela
        if (y > bottom - size) {
            reverseY();
        }
        //valor de y na parte de cima da tela
        else if (y < top) {
            reverseY();
        }
    }

    //método para aumentar a velocidade
    public void increaseSpeed() {
        //verificar se a velocidade atual é menor que a velocidade
        //máxima, antes de aumentar
        if (speed < MAX_SPEED) {
            //aumenta a velocidade em 1
            speed++;

            //atualiza os valores de cy e cx
            cx = (cx / Math.abs(cx) * speed);
            cy = (cy / Math.abs(cy) * speed);
        }
    }

    //reverte a posição da bola no eixo x
    public void reverseX() {
        cx *= -1;
    }

    //reverte a posição da bola no eixo y
    public void reverseY() {
        cy *= -1;
    }

    //getter da posição Y da bola
    public int getY() {
        return y;
    }

    //getter da posição X da bola
    public int getX() {
        return x;
    }

    //setters da bola
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setCx(int cx) {
        this.cx = cx;
    }
    public void setCy(int cy) {
        this.cy = cy;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //getter do tamanho size da bola
    public int getSize() {
        return size;
    }
}
