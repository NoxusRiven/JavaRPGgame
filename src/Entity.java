import java.awt.*;

public abstract class Entity
{
    int worldX,worldY,width, height;
    int speed;
    String direction = "";
    KeyHandler keyHandler;
    //TODO add sprites of this class (BufferedImage; spriteCount, spriteNum[int])
    Rectangle hitBox;
    boolean collisionT = false;
    boolean collisionB = false;
    boolean collisionL = false;
    boolean collisionR = false;
    CollisionChecker colliChecker;
}
