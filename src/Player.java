import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity
{
    //PLAYERS DEFAULT STATISTICS
    GamePanel gp;
    final KeyHandler keyHandler;
    final int screenX, screenY;

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
        int hitBoxDiffW = width-diff;
        int hitBoxDiffH = height-diff;
        hitBox =  new Rectangle(diff, diff, hitBoxDiffW, hitBoxDiffH);

        //COLLISION LOGIC
        collisionOn = false;
        gp.colliChecker.checkTile(this);
    }

    public void update()
    {
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_W))
        {
            direction = "up";
        }
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_S))
        {
            direction = "down";
        }
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_A))
        {
            direction = "left";
        }
        if (keyHandler.pressedKeys.contains(KeyEvent.VK_D))
        {
            direction = "right";
        }

        if(!collisionOn) //if there is no collision - move
        {
            switch(direction)
            {
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;

            }
        }
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.white);
        g2.fillRect(screenX,screenY,width,height);
    }

}
