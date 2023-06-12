package WilliamTheKnight.Items;

import WilliamTheKnight.Items.Item;
import WilliamTheKnight.RefLinks;
import WilliamTheKnight.Tiles.Tile;


public class Camera {

    private float xOffset;
    private float yOffset;

    private RefLinks refLinks;


    public Camera(RefLinks refLinks, float xOffset, float yOffset) {
        this.refLinks = refLinks;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }


    public void followHero(Item hero) {
        xOffset = hero.GetX() + hero.GetWidth()/2 - refLinks.GetWidth()/2;
        yOffset = hero.GetY() + hero.GetHeight()/2 - refLinks.GetHeight()/2;
        checkCameraLimits();
    }

    public void checkCameraLimits() {

        if(xOffset < 0)
            xOffset = 0;
        else if(xOffset > refLinks.GetMap().getWidth() * Tile.TILE_WIDTH - refLinks.GetWidth())
            xOffset = refLinks.GetMap().getWidth() * Tile.TILE_WIDTH - refLinks.GetWidth();

        if(yOffset < 0)
            yOffset = 0;
        else if(yOffset > refLinks.GetMap().getHeight() * Tile.TILE_HEIGHT  - refLinks.GetHeight())
            yOffset = refLinks.GetMap().getHeight() * Tile.TILE_HEIGHT - refLinks.GetHeight();
    }


    public float GetxOffset() {
        return xOffset;
    }
    public void SetxOffset(float x)
    {
        xOffset = x;
    }

    public float GetyOffset()
    {
        return yOffset;
    }
    public void SetyOffset(float y)
    {
        yOffset = y;
    }

}