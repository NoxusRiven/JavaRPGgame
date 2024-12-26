package Interactables;

import GameLogic.GameObject;
import GameLogic.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Interactable extends GameObject //TODO finish this interactable
{
    public boolean collision = true;
    public BufferedImage image;
    public Color color;

    public Rectangle getHitBox(GamePanel gp)
    {
        return new Rectangle(worldX,worldY,gp.tileSize,gp.tileSize);
    }
}