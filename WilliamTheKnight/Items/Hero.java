package WilliamTheKnight.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Graphics.Assets;
import static WilliamTheKnight.Items.Collisions.CanMoveHere;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private int sprite_cnt = 0;
    private int sprite_frame = 0;
    private boolean moving = false;
    public static final int xOffset = 18;
    public static final int yOffset = 23;
    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */


    //CONSTRUCTOR CU PARAMETRII: SI CU MARIMILE LUI:
    //(in PlayState il instantiez)
    public Hero(RefLinks refLink, float x, float y, int width, int height)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, width, height);
        ///Seteaza imaginea de start a eroului
        setDefaultPosition();
        image = Assets.heroLeft;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = (int) (x + xOffset);
        normalBounds.y = (int) (y + yOffset);
        normalBounds.width = 40;
        normalBounds.height = 45;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;
    }
    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        if(moving)
            Move();
        ///Actualizeaza imaginea
        if(refLink.GetKeyManager().left == true)
        {
            //image = Assets.v_heroleft[num];
            //4 imagini per animatie, le-am indexat practic de la 0
            if(sprite_cnt == 0) {
                image = Assets.heroLeft;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 1) {
                image = Assets.heroLeft1;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 2) {
                image = Assets.heroLeft2;
                //sprite_cnt++;
            }
            else //(sprite_cnt == 3) {
            {
                image = Assets.heroLeft3;
                //sprite_cnt = 0;
            }
        }
        if(refLink.GetKeyManager().right == true) {
            //image = Assets.heroRight;
            if(sprite_cnt == 0) {
                image = Assets.heroRight;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 1) {
                image = Assets.heroRight1;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 2) {
                image = Assets.heroRight2;
                //sprite_cnt++;
            }
            else //(sprite_cnt == 3) {
            {
                image = Assets.heroRight3;
                //sprite_cnt = 0;
            }
        }
        refLink.GetGame().getCamera().followHero(this);

       /* if(normalBounds.intersects(attackBounds))
        {
          //Avem Coliziune
        } else {
          //NU avem coliziune

        }*/
        normalBounds.x = (int) (x + xOffset);
        normalBounds.y = (int) (y + yOffset);
        if(refLink.GetMap().GetTile(((normalBounds.x + normalBounds.width / 2) / 48), (normalBounds.y + normalBounds.height / 2)/48).GetId() == 8) {
            setDefaultPosition();
            if(refLink.GetGame().id == 3)
                refLink.GetGame().setPlayState(1);
            else
                refLink.GetGame().setPlayState(++refLink.GetGame().id);
        }
    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput() {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        //Aici verific coliziunea:
        moving = false;
//        refLink.colli.checkTile(this);

            ///Verificare apasare tasta "sus"
            if (refLink.GetKeyManager().up) {
                yMove = -speed;
            }
            ///Verificare apasare tasta "jos"
            if (refLink.GetKeyManager().down) {
                yMove = speed;
            }
            ///Verificare apasare tasta "left"
            if (refLink.GetKeyManager().left) {
                xMove = -speed;
            }
            ///Verificare apasare tasta "dreapta"
            if (refLink.GetKeyManager().right) {
                xMove = speed;
            }
            if(Collisions.CanMoveHere(x + xMove + xOffset, y + yMove + yOffset, normalBounds.width, normalBounds.height, refLink)){
                moving = true;
            }
            //else
            //    System.out.println("nu se poate");
            sprite_frame++;
            if (sprite_frame > 4) { // 4 = tranzitia: potrivita: la fiecare a 4/60 * secunda
                if (sprite_cnt == 0) {
                    sprite_cnt = 1;
                } else if (sprite_cnt == 1) {
                    sprite_cnt = 2;
                } else if (sprite_cnt == 2) {
                    sprite_cnt = 3;
                } else //sprite_cnt == 0
                {
                    sprite_cnt = 0;
                }
                sprite_frame = 0;
            }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)(x - refLink.GetGame().getCamera().GetxOffset()), (int)(y - refLink.GetGame().getCamera().GetyOffset()), width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
//        g.setColor(Color.blue);
//        g.fillRect((int)(normalBounds.x - refLink.GetGame().getCamera().GetxOffset()), (int)(normalBounds.y - refLink.GetGame().getCamera().GetyOffset()), normalBounds.width, normalBounds.height);

    }
    public void setDefaultPosition() {
        x = 0;
        y = 309;
    }
}
