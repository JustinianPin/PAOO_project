package WilliamTheKnight.Tiles;

import WilliamTheKnight.Graphics.Assets;

public class Tile_normal_PE_pamantTile extends Tile{

    public Tile_normal_PE_pamantTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.tile_normal_PE_pamant, id);
        collision = true;
    }
}
