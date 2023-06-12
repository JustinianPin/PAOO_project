package WilliamTheKnight.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    private BufferedImage       spriteSheet;        /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private int    tileWidth   = 48;   /*!< Latimea unei dale din sprite sheet.*/
    private int    tileHeight  = 48;   /*!< Inaltime unei dale din sprite sheet.*/

    public SpriteSheet(BufferedImage buffImg) //constructor cu tileWidth/tileHeight default
    {
        spriteSheet = buffImg;
    }

    //constructor cu parametrii, ca sa pot pune marimi pt tiles-urile care nu sunt din sheet1
    public SpriteSheet(BufferedImage buffImg, int tilewidth, int tileheight)
    {
        tileWidth = tilewidth;
        tileHeight = tileheight;
        spriteSheet = buffImg;
    }
    public BufferedImage crop(int x, int y)
    {
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
}
