package Items;

import GameLogic.GamePanel;

public class ItemManager
{
    public GamePanel gp;
    public Item itemToDraw;

    public ItemManager(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject(int worldX, int worldY)
    {
        itemToDraw = new Equipment("First Sword",worldX*gp.tileSize,worldY*gp.tileSize);
    }
}
