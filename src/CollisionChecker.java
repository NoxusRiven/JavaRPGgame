import java.awt.event.KeyEvent;
import java.util.*;

public class CollisionChecker
{
    GamePanel gp;

    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }

    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.hitBox.x;
        int entityRightWorldX = entity.worldX + entity.hitBox.x + entity.hitBox.width;
        int entityTopWorldY = entity.worldY + entity.hitBox.y;
        int entityBotWorldY = entity.worldY + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBotRow = entityBotWorldY / gp.tileSize;

        entity.collisionT = false;
        entity.collisionB = false;
        entity.collisionL = false;
        entity.collisionR = false;

        //Checking based on direction or key pressed
        if (entity.direction.contains("up") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_W))
        {
            int nextTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
            int tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][nextTopRow];
            int tileNum2 = gp.tileManager.mapTileNum[entityRightCol][nextTopRow];
            if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision)
            {
                entity.collisionT = true;
            }
        }
        if (entity.direction.contains("down") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_S))
        {
            int nextBotRow = (entityBotWorldY + entity.speed) / gp.tileSize;
            int tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][nextBotRow];
            int tileNum2 = gp.tileManager.mapTileNum[entityRightCol][nextBotRow];
            if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision)
            {
                entity.collisionB = true;
            }
        }
        if (entity.direction.contains("left") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_A))
        {
            int nextLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
            int tileNum1 = gp.tileManager.mapTileNum[nextLeftCol][entityTopRow];
            int tileNum2 = gp.tileManager.mapTileNum[nextLeftCol][entityBotRow];
            if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision)
            {
                entity.collisionL = true;
            }
        }
        if (entity.direction.contains("right") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_D))
        {
            int nextRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
            int tileNum1 = gp.tileManager.mapTileNum[nextRightCol][entityTopRow];
            int tileNum2 = gp.tileManager.mapTileNum[nextRightCol][entityBotRow];
            if (gp.tileManager.tiles[tileNum1].collision || gp.tileManager.tiles[tileNum2].collision)
            {
                entity.collisionR = true;
            }
        }
    }

}

