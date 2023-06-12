package WilliamTheKnight.Items;

import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Tiles.Tile;

import java.awt.*;

public class Collisions {
    public static boolean CanMoveHere(float x, float y, float width, float height, RefLinks refLinks) {
        if (!IsSolid(x, y, refLinks))
            if (!IsSolid(x + width, y + height, refLinks))
                if (!IsSolid(x + width, y, refLinks))
                    if (!IsSolid(x, y + height, refLinks))
                        return true;
        return false;
    }

    private static boolean IsSolid(float x, float y, RefLinks refLinks) {
        if (x < 0 || x >=  refLinks.GetMap().getWidth() * Tile.TILE_WIDTH)
            return true;
        if (y < 0 || y >= refLinks.GetMap().getHeight() * Tile.TILE_HEIGHT)
            return true;

        float xIndex = x/ Tile.TILE_WIDTH;
        float yIndex = y/ Tile.TILE_HEIGHT;


        if(refLinks.GetMap().GetTile((int) xIndex,(int) yIndex).IsSolid())

            return true;
        return false;
    }

    public static boolean boundCollision(Rectangle a, Rectangle b) {
        if(a.intersects(b))
            return true;
        return false;
    }
}