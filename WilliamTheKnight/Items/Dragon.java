package WilliamTheKnight.Items;

import WilliamTheKnight.Graphics.Assets;
import WilliamTheKnight.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Dragon extends Character {
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/
    private int sprite_cnt = 0;
    private int sprite_frame = 0;

    private int xPos;
    private int xPosMax = 100;

    public static final int xOffset = 42;
    public static final int yOffset = 50;



    public Dragon(RefLinks refLink, float x, float y, int width, int height)
    {
        super(refLink, x,y, width, height);

        image = Assets.dragonLeft;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = (int)(x+xOffset);
        normalBounds.y = (int)(y+yOffset);
        normalBounds.width = 80;
        normalBounds.height = 100;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;
    }
    @Override
    public void Update()
    {
        if(xPos == 0)
            speed = 1.0f;
        if(xPos == xPosMax)
            speed = -1.0f;
        xPos += speed;
        x += speed;
        bounds.x = (int)(x + xOffset);
        bounds.y = (int)(y + yOffset);
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
        if(speed > 0)
        {
            //image = Assets.v_heroleft[num];
            //4 imagini per animatie, le-am indexat practic de la 0
            if(sprite_cnt == 0) {
                image = Assets.dragonLeft;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 1) {
                image = Assets.dragonLeft1;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 2) {
                image = Assets.dragonLeft2;
                //sprite_cnt++;
            }
            else //(sprite_cnt == 3) {
            {
                image = Assets.dragonLeft3;
                //sprite_cnt = 0;
            }
        }
        //if(speed < 0 )
        else {
            //image = Assets.heroRight;
            if(sprite_cnt == 0) {
                image = Assets.dragonRight;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 1) {
                image = Assets.dragonRight1;
                //sprite_cnt++;
            }
            else if(sprite_cnt == 2) {
                image = Assets.dragonRight2;
                //sprite_cnt++;
            }
            else //(sprite_cnt == 3) {
            {
                image = Assets.dragonRight3;
                //sprite_cnt = 0;
            }
        }
    }

    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)(x - refLink.GetGame().getCamera().GetxOffset()), (int)(y - refLink.GetGame().getCamera().GetyOffset()), width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
//        g.setColor(Color.blue);
//        g.drawRect((int)(normalBounds.x - refLink.GetGame().getCamera().GetxOffset()), (int)(normalBounds.y- refLink.GetGame().getCamera().GetyOffset()), normalBounds.width, normalBounds.height);

    }
}
