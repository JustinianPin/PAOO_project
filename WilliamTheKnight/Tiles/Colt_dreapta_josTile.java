package WilliamTheKnight.Tiles;

import WilliamTheKnight.Graphics.Assets;

public class Colt_dreapta_josTile extends Tile{

    public Colt_dreapta_josTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.colt_dreapta_jos, id);
        collision = true;
    }

}