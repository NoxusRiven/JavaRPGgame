package Interactables;

import GameLogic.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Gate extends Interactable
{
    GamePanel gp;
    public String targetMap;
    public BufferedImage image;

    public Gate(int worldX, int worldY, String targetMap, BufferedImage image)
    {
        this.gp = gp;
        this.image = image;
        this.targetMap = targetMap;
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public Gate(int worldX, int worldY, String targetMap, Color color, GamePanel gp) //temp constr
    {
        this.gp = gp;
        this.color=color;
        this.targetMap = targetMap;
        this.worldX = worldX;
        this.worldY = worldY;
    }

    public void setNextMap()
    {
        gp.mapManager.mapPath=targetMap;
    }

    @Override
    public String getClassType()
    {
        return "Gate";
    }
}
