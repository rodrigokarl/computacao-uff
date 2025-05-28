public class Ponto {
    int x, y;
    Ponto(int a, int b) {
        x=a;
        y=b;
    }
    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    double distancia(Ponto p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
