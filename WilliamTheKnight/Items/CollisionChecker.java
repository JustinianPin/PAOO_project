package WilliamTheKnight.Items;

import WilliamTheKnight.RefLinks;

import java.awt.*;

public class CollisionChecker {
    RefLinks ref;
    public CollisionChecker(RefLinks refLink)
    {
        ref = refLink; //are toate informatiile necesare, mapa etc.
    }
    public void checkTile(Character personaj)
    {
        int pers_Left = (int) (personaj.GetX() + personaj.normalBounds.x);
        int pers_Right =  (int) (personaj.GetX() + personaj.normalBounds.x + personaj.normalBounds.width);
        int pers_Up = (int) (personaj.GetY() + personaj.normalBounds.y);
        int pers_Down = (int) (personaj.GetY() + personaj.normalBounds.y + personaj.normalBounds.height);

        // "Inlocuieste"
        int persLeftCol = (int) ((pers_Left - personaj.speed) / 48);
        int persRightCol = (int) ((pers_Right - personaj.speed) / 48);
        int persUpCol = (int) ((pers_Up - personaj.speed) / 48);
        int persDownCol = (int) ((pers_Down - personaj.speed) / 48);

        if(ref.GetKeyManager().up) {
            if(ref.GetMap().GetTile(persUpCol, persLeftCol).IsSolid() && ref.GetMap().GetTile(persUpCol, persRightCol).IsSolid()) {
                personaj.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().down) {
            if (ref.GetMap().GetTile(persDownCol, persLeftCol).IsSolid() && ref.GetMap().GetTile(persDownCol, persRightCol).IsSolid()) {
                personaj.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().right) {
            if (ref.GetMap().GetTile(persUpCol, persRightCol).IsSolid() && ref.GetMap().GetTile(persDownCol, persRightCol).IsSolid()) {
                personaj.collisionOn = true;
            }
        }
        if (ref.GetKeyManager().left) {
            if (ref.GetMap().GetTile(persUpCol, persLeftCol).IsSolid() && ref.GetMap().GetTile(persDownCol, persLeftCol).IsSolid()) {
                personaj.collisionOn = true;
            }
        }
    }
    public static boolean col_Hero_Coin(Character personaj, Coin coin)
    {
        int pers_Left = (int) (personaj.GetX() + personaj.normalBounds.x);
        int pers_Right =  (int) (personaj.GetX() + personaj.normalBounds.x + personaj.normalBounds.width);
        int pers_Up = (int) (personaj.GetY() + personaj.normalBounds.y);
        int pers_Down = (int) (personaj.GetY() + personaj.normalBounds.y + personaj.normalBounds.height);

        // "Inlocuieste"
        int persLeftCol = (int) ((pers_Left - personaj.speed));
        int persRightCol = (int) ((pers_Right - personaj.speed));
        int persUpCol = (int) ((pers_Up - personaj.speed));
        int persDownCol = (int) ((pers_Down - personaj.speed));

        int coin_Left = (int) (coin.GetX() + coin.normalBounds.x);
        int coin_Right =  (int) (coin.GetX() + coin.normalBounds.x + coin.normalBounds.width);
        int coin_Up = (int) (coin.GetY() + coin.normalBounds.y);
        int coin_Down = (int) (coin.GetY() + coin.normalBounds.y + coin.normalBounds.height);


        Rectangle personajRectangle = new Rectangle(persLeftCol, persUpCol, (persRightCol -persLeftCol), (persDownCol-persUpCol) );
        Rectangle coinRectangle = new Rectangle(coin_Left, coin_Up , coin_Right-coin_Left, coin_Down - coin_Up);
       // System.out.println(personajRectangle);
       // System.out.println(coinRectangle);
        return personajRectangle.intersects(coinRectangle);
    }
    public static boolean bounds_collision(Rectangle a, Rectangle b)
    {
        if(a.intersects(b))
        {
            return true;
        }
        return false;
    }
}

