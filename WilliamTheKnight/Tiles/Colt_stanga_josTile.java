package WilliamTheKnight.Tiles;

import WilliamTheKnight.Graphics.Assets;

public class Colt_stanga_josTile extends Tile{
    public Colt_stanga_josTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.colt_stanga_jos, id);
        collision = true;
    }
}
