package WilliamTheKnight.Graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.
    /*
    public static BufferedImage soil;
    public static BufferedImage grass;
    public static BufferedImage mountain;
    public static BufferedImage townGrass;
    public static BufferedImage townGrassDestroyed;
    public static BufferedImage townSoil;
    public static BufferedImage water;
    public static BufferedImage rockUp;
    public static BufferedImage rockDown;
    public static BufferedImage rockLeft;
    public static BufferedImage rockRight;
    public static BufferedImage tree;
*/
    //Ale mele:
    //Tiles:
    public static BufferedImage colt_stanga_jos;
    public static BufferedImage tile_normal_PE_pamant;
    public static BufferedImage colt_dreapta_jos;
    public static BufferedImage pamant;
    public static BufferedImage transparent_tile;
    public static BufferedImage albastru_next_lvl;

    //Hero:
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage heroLeft1;
    public static BufferedImage heroLeft2;
    public static BufferedImage heroLeft3;
    public static BufferedImage heroRight1;
    public static BufferedImage heroRight2;
    public static BufferedImage heroRight3;

    //Banut:
    public static BufferedImage coin;

    //Dragon:
    public static BufferedImage dragonLeft;
    public static BufferedImage dragonRight;
    public static BufferedImage dragonLeft1;
    public static BufferedImage dragonLeft2;
    public static BufferedImage dragonLeft3;
    public static BufferedImage dragonRight1;
    public static BufferedImage dragonRight2;
    public static BufferedImage dragonRight3;


 /*   public static BufferedImage [] v_heroleft;
    public static BufferedImage imag;
*/
    //public static BufferedImage
    //public static BufferedImage transparent_tile;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
        /*BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("res/textures/sif.png"));
            BufferedImage sifAnimations = new BufferedImage[17][18];
            for (int j = 0; j < sifAnimations.length; j++) {
                for (int i = 0; i < sifAnimations[j].length; i++) {
                    sifAnimations[j][i] = img.getSubimage(i * 900, j * 900, 900, 900);
                }
            }

          BufferedImage soil = ImageIO.read(new File("res/level_1/Platformer/Ground_11.png"));




        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        //SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));
        //SpriteSheet backgroundul = new SpriteSheet(ImageLoader.LoadImage("/Sprites joc William/Background1.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("/Sprites joc William/Tileset.png"));  //nu decupeaza, e exact 48 x48
        SpriteSheet sheet_calaret = new SpriteSheet(ImageLoader.LoadImage("/Sprites joc William/calaret_sprites_sheet.png"),80,75);
        SpriteSheet sheet_transparent = new SpriteSheet(ImageLoader.LoadImage("/Sprites joc William/transparent_tile_48.png")); //nu decupeaza, e exact 48 x48
        SpriteSheet sheet_dragon = new SpriteSheet(ImageLoader.LoadImage("/Sprites joc William/dragon_sprite_actualizat.png"),201,162);
        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        // Ale mele:
        //Tiles:
        colt_stanga_jos = sheet1.crop(0,0);
        colt_dreapta_jos = sheet1.crop(2,0);
        tile_normal_PE_pamant = sheet1.crop(1,0);
        pamant = sheet1.crop(1,1);
        transparent_tile = sheet_transparent.crop(0,0);
        albastru_next_lvl = sheet1.crop(9, 5);

        //Hero:

        heroLeft = sheet_calaret.crop(0, 2);
        heroRight = sheet_calaret.crop(0, 0);

        heroLeft1 = sheet_calaret.crop(0, 3);
        heroLeft2 = sheet_calaret.crop(1, 3);
        heroLeft3 = sheet_calaret.crop(2, 3);
        heroRight1 = sheet_calaret.crop(0,1);
        heroRight2 = sheet_calaret.crop(1,1);
        heroRight3 = sheet_calaret.crop(2,1);

        //Coin:
        coin = ImageLoader.LoadImage("/Sprites joc William/Gold_22.png");

        //Dragon:
        dragonLeft = sheet_dragon.crop(0, 1);
        dragonRight = sheet_dragon.crop(0, 0);

        dragonLeft1 = sheet_dragon.crop(1, 1);
        dragonLeft2 = sheet_dragon.crop(2, 1);
        dragonLeft3 = sheet_dragon.crop(3, 1);

        dragonRight1 = sheet_dragon.crop(1, 0);
        dragonRight2 = sheet_dragon.crop(2, 0);
        dragonRight3 = sheet_dragon.crop(3, 0);

 /*       try {
            imag = ImageIO.read(new File("C:\\Users\\Justinian Pintilie\\Desktop\\Sprite uri\\Sprites joc William\\calaret_sprites_sheet.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i=0; i<8; i++)
        {
                System.out.println(imag.getSubimage(0*i, 2, 80, 75));
                v_heroleft[i] = imag.getSubimage(0*i,2, 80,75 );
        }
*/

        //SpriteSheet sheet_pt_transparentTile = new SpriteSheet(ImageLoader.LoadImage("/Sprites joc William/dragon_sprite_sheet.png"),80,75);
        //transparent_tile = sheet_pt_transparentTile.crop();
    }
}
