package Entities;

import GameLogic.CollisionChecker;
import GameLogic.GameObject;
import GameLogic.GamePanel;
import GameLogic.KeyHandler;

import java.awt.*;

public abstract class Entity extends GameObject
{
    public GamePanel gp;
    public int width, height;
    public int speed;
    public String direction;
    public KeyHandler keyHandler;
    //TODO add sprites of this class (BufferedImage; spriteCount, spriteNum[int])
    public Rectangle hitBox;
    public boolean collisionT = false;
    public boolean collisionB = false;
    public boolean collisionL = false;
    public boolean collisionR = false;
    public CollisionChecker colliChecker;

    public Entity()
    {
        getHitBox(gp);
    }

    public Rectangle getHitBox(GamePanel gp)
    {
        hitBox = new Rectangle(worldX, worldY, width, height);
        return hitBox;
    }

    @Override
    public String getClassType() {
        return "Entity";
    }
}
