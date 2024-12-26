package GameLogic;

import Entities.Entity;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CollisionChecker
{
    public GamePanel gp;
    public final List<GameObject> collidedObjects = new ArrayList<>();
    public final List<String> collidingClasses = new ArrayList<>();

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
            int tileNum1 = gp.mapManager.mapTileNum[entityLeftCol][nextTopRow];
            int tileNum2 = gp.mapManager.mapTileNum[entityRightCol][nextTopRow];
            if (gp.mapManager.tiles[tileNum1].collision || gp.mapManager.tiles[tileNum2].collision)
            {
                System.out.println("tile nums: "+tileNum1+" "+tileNum2);
                entity.collisionT = true;
            }
        }
        if (entity.direction.contains("down") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_S))
        {
            int nextBotRow = (entityBotWorldY + entity.speed) / gp.tileSize;
            int tileNum1 = gp.mapManager.mapTileNum[entityLeftCol][nextBotRow];
            int tileNum2 = gp.mapManager.mapTileNum[entityRightCol][nextBotRow];
            if (gp.mapManager.tiles[tileNum1].collision || gp.mapManager.tiles[tileNum2].collision)
            {
                System.out.println("tile nums: "+tileNum1+" "+tileNum2);

                entity.collisionB = true;
            }
        }
        if (entity.direction.contains("left") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_A))
        {
            int nextLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
            int tileNum1 = gp.mapManager.mapTileNum[nextLeftCol][entityTopRow];
            int tileNum2 = gp.mapManager.mapTileNum[nextLeftCol][entityBotRow];
            if (gp.mapManager.tiles[tileNum1].collision || gp.mapManager.tiles[tileNum2].collision)
            {
                System.out.println("tile nums: "+tileNum1+" "+tileNum2);

                entity.collisionL = true;
            }
        }
        if (entity.direction.contains("right") || entity.keyHandler.pressedKeys.contains(KeyEvent.VK_D))
        {
            int nextRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
            int tileNum1 = gp.mapManager.mapTileNum[nextRightCol][entityTopRow];
            int tileNum2 = gp.mapManager.mapTileNum[nextRightCol][entityBotRow];
            if (gp.mapManager.tiles[tileNum1].collision || gp.mapManager.tiles[tileNum2].collision)
            {
                System.out.println("tile nums: "+tileNum1+" "+tileNum2);

                entity.collisionR = true;
            }
        }
    }

    public GameObject checkGameObject(Entity entity, String class_)
    {
        for (GameObject object : GameObject.allGameObjects)
        {
            if (object != entity && entity.getHitBox(gp).intersects(object.getHitBox(gp)))
            {

                //object.isColliding = true;

                if (!collidedObjects.contains(object))
                {
                    collidedObjects.add(object);
                }

                if(!collidingClasses.contains(object.getClassType()))
                {
                    collidingClasses.add(object.getClassType());
                }

                if (object.getClassType().equals(class_))
                {
                    return object;
                }
            }
        }

        return null;
    }

    public void checkGameObject(Entity entity)
    {
        checkGameObject(entity,null);
    }

}

