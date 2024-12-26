package Entities;

import GameLogic.CollisionChecker;
import GameLogic.GameObject;
import GameLogic.GamePanel;
import GameLogic.KeyHandler;
import Interactables.Gate;
import Interactables.Interactable;

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
        getHitBox(gp);

        //COLLISION LOGIC
        colliChecker = new CollisionChecker(gp);
    }

    public Rectangle getHitBox(GamePanel gp)
    {
        hitBox = new Rectangle(this.worldX, this.worldY, this.width, this.height);
        return hitBox;
    }

    @Override
    public String getClassType() {
        return "Player";
    }

    public void update()
    {
        colliChecker.checkTile(this);
        colliChecker.checkGameObject(this);
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
        if(keyHandler.pressedKeys.contains(KeyEvent.VK_E) && !colliChecker.collidedObjects.isEmpty())
        {
            if(colliChecker.collidingClasses.contains("Gate"))
            {
                Gate gate = (Gate) colliChecker.checkGameObject(this, "Gate");
                System.out.println();
                gate.setNextMap();
            }


        }
        colliChecker.collidedObjects.clear();
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.white);
        g2.fillRect(screenX,screenY,width,height);
    }

}
