package Entities;

import GameLogic.CollisionChecker;
import GameLogic.KeyHandler;

import java.awt.*;

public abstract class Entity
{
    public int worldX,worldY,width, height;
    public int speed;
    public String direction = "";
    public KeyHandler keyHandler;
    //TODO add sprites of this class (BufferedImage; spriteCount, spriteNum[int])
    public Rectangle hitBox;
    public boolean collisionT = false;
    public boolean collisionB = false;
    public boolean collisionL = false;
    public boolean collisionR = false;
    public CollisionChecker colliChecker;
}
