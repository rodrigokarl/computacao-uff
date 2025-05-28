class Card {
    int id;
    private static int nCards = 0;
    String card;
    public Card(String s) {
        this.card = s;
        id = nCards;
        nCards++;
    }

    public String toString() {
        return id + " " + card + "\n";
    }
}
