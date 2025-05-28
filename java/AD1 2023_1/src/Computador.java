public class Computador extends ItemMontado {
    public Computador(String descricao) {
        super(descricao);
    }

    @Override
    public void inclui(Item item) {
        if (!(item instanceof Gabinete || item instanceof MonitorVideo || item instanceof Teclado)) {
            throw new IllegalArgumentException("Item invalido na montagem de um computador.");
        }
        super.inclui(item);
    }
}
