package WilliamTheKnight.States;

import WilliamTheKnight.Database;
import WilliamTheKnight.Graphics.ImageLoader;
import WilliamTheKnight.Items.Coin;
import WilliamTheKnight.Items.Dragon;
import WilliamTheKnight.Items.Hero;
import WilliamTheKnight.Maps.Map3;
import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Maps.Map1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState_lvl3 extends PlayState
{
    public PlayState_lvl3(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        ///Construieste harta jocului
        map = new Map3(refLink);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
        ///Construieste eroul
        hero = new Hero(refLink,100, 100, 80, 75);
        Coin coin1 = new Coin(refLink, 200, 330);
        Coin coin2 = new Coin(refLink, 250, 330);
        Coin coin3 = new Coin(refLink, 300, 330);
        Coin coin4 = new Coin(refLink, 500, 200);
        Coin coin5 = new Coin(refLink, 550, 180);
        Coin coin6 = new Coin(refLink, 600, 180);
        Coin coin7 = new Coin(refLink, 650, 200);
        Coin coin8 = new Coin(refLink, 850, 330);
        Coin coin9 = new Coin(refLink, 800, 330);
        Coins.add(coin1);
        Coins.add(coin2);
        Coins.add(coin3);
        Coins.add(coin4);
        Coins.add(coin5);
        Coins.add(coin6);
        Coins.add(coin7);
        Coins.add(coin8);
        Coins.add(coin9);
        dragon = new Dragon(refLink, 500, 100, 201, 162);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        BufferedImage backgroundul = ImageLoader.LoadImage("/Sprites joc William/Background3.png");
        g.drawImage(backgroundul, 0, 0, 960,480, null);
        map.Draw(g);

        for(Coin  coin : Coins )
        {
            coin.Draw(g);
        }
        hero.Draw(g);
        dragon.Draw(g);
        //Database.getInstance().afiseazaInregistrari();

    }
}
