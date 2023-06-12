package WilliamTheKnight.Tiles;

import WilliamTheKnight.Graphics.Assets;

public class PamantTile extends Tile{

    public PamantTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.pamant, id);
        collision = true;
    }
}
