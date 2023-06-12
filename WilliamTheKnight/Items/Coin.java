package WilliamTheKnight.Items;

import WilliamTheKnight.Database;
import WilliamTheKnight.Graphics.Assets;
import WilliamTheKnight.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends Item {

    private BufferedImage image;    /*!< Referinta catre imaginea Coin*/
    //private int w_coin; //559
    //private int h_coin; //564
    private final static int DEFAULT_width_coin = 48;
    private final static int DEFAULT_height_coin = 48;
    private boolean colectat = false;
    private Scor scor;


    public Coin(RefLinks refLink, float x, float y) {
        super(refLink, x, y, DEFAULT_width_coin, DEFAULT_height_coin);
        image = Assets.coin;
        scor = Scor.getInstance();
        normalBounds.x = (int) x;
        normalBounds.y = (int) y;
        normalBounds.width = 48;
        normalBounds.height = 48;
    }

    public void Update() {
        if( refLink.colli.col_Hero_Coin(refLink.GetGame().GetPlayState().GetHero(), this))
        {
            //System.exit(0);
            scor.adaugaPuncte(10);  ///10 puncte per banut
           // Database.getInstance().adaugaInregistrare(scor.getScor());
            System.out.println("Scorul actual (din clasa Coin): " + scor.getScor());
        }

    }

    public void Draw(Graphics g) {
        if(!colectat)
            g.drawImage(image, (int) (x - refLink.GetGame().getCamera().GetxOffset()), (int) (y - refLink.GetGame().getCamera().GetyOffset()), width, height, null);
        g.setColor(Color.BLACK);
        g.drawRect((int) (x + normalBounds.x), (int) (y + normalBounds.y), normalBounds.width, normalBounds.height);

    }

}