package WilliamTheKnight.Items;

public class Scor {
    private static Scor instance;
    private int scor;

    private Scor() {
        // Constructor privat pentru a preveni crearea de instanțe din exterior
        scor = 0;
    }

    public static Scor getInstance() {
        if (instance == null) {
            synchronized (Scor.class) {
                if (instance == null) {
                    instance = new Scor();
                }
            }
        }
        return instance;
    }

    public int getScor() {
        return scor;
    }

    public void adaugaPuncte(int puncte) {
        scor += puncte;
    }

    public void reseteazaScor() {
        scor = 0;
    }
}
