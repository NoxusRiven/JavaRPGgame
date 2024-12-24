package Entities;

import GameLogic.CollisionChecker;
import GameLogic.GamePanel;
import GameLogic.KeyHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity
{
    //PLAYERS DEFAULT STATISTICS
    public GamePanel gp;
    public final int screenX, screenY;

    public Player(GamePanel gp, KeyHandler keyHandler)
    {
        this.gp = gp;
        this.keyHandler = keyHandler;

        //PLAYER MAP STARTING POSITION
        worldX=11*gp.tileSize;
        worldY=11*gp.tileSize;
        direction = "down";

        //PLAYER SIZE
        width = gp.tileSize;
        height = gp.tileSize;

        //PLAYER STATS (for now only speed)
        speed = 5;

        //CENTER PLAYER ON THE SCREEN
        screenX = gp.maxScreenWidth/2 - (gp.tileSize/2);
        screenY = gp.maxScreenHeight/2 - (gp.tileSize/2);

        //PLAYER HITBOX
        int diff = 4;
        int hitBoxDiffW = width-diff*2;
        int hitBoxDiffH = height-diff*2;
        hitBox =  new Rectangle(diff, diff, hitBoxDiffW, hitBoxDiffH);

        //COLLISION LOGIC
        colliChecker = new CollisionChecker(gp);
    }

    public void update()
    {
        colliChecker.checkTile(this);
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_W) && !collisionT)
        {
            direction = "up";
            worldY -= speed;
        }
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_S) && !collisionB)
        {
            direction = "down";
            worldY += speed;
        }
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_A) && !collisionL)
        {
            direction = "left";
            worldX -= speed;
        }
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_D) && !collisionR)
        {
            direction = "right";
            worldX += speed;
        }
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.white);
        g2.fillRect(screenX,screenY,width,height);
    }

}
