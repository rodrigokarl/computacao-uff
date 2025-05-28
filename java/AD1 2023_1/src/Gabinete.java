public class Gabinete extends ItemMontado {
    public Gabinete(String descricao) {
        super(descricao);
    }

    @Override
    public void inclui(Item item) {
        if (!(item instanceof Processador || item instanceof PenteMemoria)) {
            throw new IllegalArgumentException("Item inválido na montagem do gabinete.");
        }
        super.inclui(item);
    }
}
