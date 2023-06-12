package WilliamTheKnight;

public class Main
{
    public static void main(String[] args)
    {
        Game WilliamTheKnight = new Game("William The Knight", 960, 480);
        RefLinks myRefLinks = RefLinks.getInstance(WilliamTheKnight); //Sablonul Singleton
        WilliamTheKnight.StartGame();
    }
}
