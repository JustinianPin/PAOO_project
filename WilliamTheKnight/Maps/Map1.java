package WilliamTheKnight.Maps;

import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Tiles.Tile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.awt.Color.blue;
import static java.awt.Color.red;

public class Map1 extends Map{ //mostenire

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map1(RefLinks refLink) {
        this.refLink = refLink;
        LoadWorld1();
    }

    public void Update() {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    /*public void Draw(Graphics g) {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for (int y = 0; y < refLink.GetGame().GetHeight() / Tile.TILE_HEIGHT; y++) {
            for (int x = 0; x < refLink.GetGame().GetWidth() / Tile.TILE_WIDTH; x++) {
                if (GetTile(y, x).GetId() != 0)
                    GetTile(y, x).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
            }
        }
    }*/
    public void Draw(Graphics g) {
        ///Se calculeaza marginile hartii in functie de pozitia camerei
        //xStart va fi max dintre 0 si xOffset/Width pentru a preveni iesirea camerei din fereastra de joc...samd
        int xStart = (int) Math.max(0, refLink.GetGame().getCamera().GetxOffset() / Tile.TILE_WIDTH);
        int xEnd = (int) Math.min(width, (refLink.GetGame().getCamera().GetxOffset() + refLink.GetGame().GetWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, refLink.GetGame().getCamera().GetyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (refLink.GetGame().getCamera().GetyOffset() + refLink.GetGame().GetWidth()) / Tile.TILE_HEIGHT + 1);
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                if(GetTile( x, y).GetId() != 0)
                    GetTile( x, y).Draw(g,
                        (int) (x * Tile.TILE_WIDTH - refLink.GetGame().getCamera().GetxOffset()),
                        (int) (y * Tile.TILE_HEIGHT - refLink.GetGame().getCamera().GetyOffset()));

            }
        }
    }
    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.tile_normal_PE_pamantTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.tile_normal_PE_pamantTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    private void LoadWorld1() {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        width = 30;
        ///Se stabileste inaltimea hartii in numar de dale
        height = 10;
        ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        //Se incarca matricea cu coduri
        File file = new File("res/harta_lvl_1");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            String[] values = line.split(", ");
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Integer.parseInt(values[x]);
            }
        }

        //scanner.close()
    }
}