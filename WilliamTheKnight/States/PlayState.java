package WilliamTheKnight.States;

import WilliamTheKnight.Database;
import WilliamTheKnight.Graphics.ImageLoader;
import WilliamTheKnight.Items.*;
import WilliamTheKnight.Maps.Map;
import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Maps.Map1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    protected Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    protected Map map;    /*!< Referinta catre harta curenta.*/
    protected ArrayList<Coin> Coins = new ArrayList<>();
    protected Dragon dragon;
    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        hero.Update();
        map.Update();

        for(Coin  coin : Coins )
        {
            coin.Update();
        }
        dragon.Update();
        for(int i = 0; i < Coins.size(); i++) //  coin : Coins )
        {
            if(Collisions.boundCollision(hero.getRectangle(), Coins.get(i).getRectangle()))
            {
                // sa scot banutii
                System.out.println("am atins banut");
                Coins.remove(i);
                i--;
                Database.getInstance().adaugaInregistrare(10);
            }
        }
        if(Collisions.boundCollision(hero.getRectangle(), dragon.getRectangle())) {
            hero.setDefaultPosition();
        }
    }

    @Override
    public void Draw(Graphics g)
    {
        //la fiecare level fac Draw specific

    }
    public Hero GetHero(){
        return hero;
    }

    public Map getMap() {
        return map;
    }
}

