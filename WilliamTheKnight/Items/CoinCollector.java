package WilliamTheKnight.Items;
import java.util.ArrayList;
import java.util.List;

public class CoinCollector {

    private ArrayList<Coin> coins = new ArrayList<>();
    private int collectedCoins = 0;

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public void removeCoin(Coin coin) {
        coins.remove(coin);
    }

    public boolean hasCoin(Coin coin) {
        return coins.contains(coin);
    }

    public void collectCoin(Coin coin) {
        if (hasCoin(coin)) {
            collectedCoins++;
            removeCoin(coin);

        }
    }

    public int getCollectedCoins() {
        return collectedCoins;
    }

}
