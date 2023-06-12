package WilliamTheKnight.Maps;

import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Tiles.Tile;

import java.awt.*;

abstract public class Map {
    protected RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    protected int width;          /*!< Latimea hartii in numar de dale.*/
    protected int height;         /*!< Inaltimea hartii in numar de dale.*/
    protected int[][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/

    abstract public void Update();

    abstract public void Draw(Graphics g);

    abstract public Tile GetTile(int persUpCol, int persLeftCol);

    public int getWidth() { return width;
    }

    public int getHeight() { return height;
    }
}
