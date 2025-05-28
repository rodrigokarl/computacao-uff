class Phase {
    Card tasks[];
    private int nTasks = 0;

    public Phase() {
        tasks = new Card[100];
    }

    void adiciona(Card c) {
        tasks[nTasks] = c;
        nTasks++;
    }

    void remove(Card c) {
        boolean found = false;
        for (int i = 0; i < nTasks; i++) {
            if ((found) || tasks[i] == c) {
                tasks[i] = tasks[i + 1];
                found = true;
            }

        }
        if (found) {
            nTasks--;
        }

    }

    public String toString() {
        String saida = "";
        for(int i = 0; i < nTasks; i++) {
            saida += tasks[i].toString();
        }
        return saida;
    }
}
