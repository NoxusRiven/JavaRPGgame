import java.awt.*;

public abstract class Entity
{
    int worldX,worldY,width, height;
    int speed;
    String direction = "";
    //TODO add sprites of this class (BufferedImage; spriteCount, spriteNum[int])
    Rectangle hitBox;
    boolean collisionOn = false;
}
