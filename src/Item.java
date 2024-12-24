import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Item
{
    String name;
    int price;

    boolean collision = false;
    int worldX, worldY;
    BufferedImage image;
    Color color; //temp var

    public void draw(Graphics2D g2, GamePanel gp)
    {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if(worldX > gp.player.worldX - gp.player.screenX - gp.tileSize &&
                worldX < gp.player.worldX + gp.player.screenX + gp.tileSize &&
                worldY > gp.player.worldY - gp.player.screenY - gp.tileSize &&
                worldY < gp.player.worldY + gp.player.screenY + gp.tileSize )
        {
            //g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            g2.fillRect(screenX,screenY,gp.tileSize,gp.tileSize);
        }
    }
}
