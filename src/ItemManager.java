public class ItemManager
{
    GamePanel gp;
    Item itemToDraw;

    public ItemManager(GamePanel gp)
    {
        this.gp = gp;
    }

    public void setObject(int worldX, int worldY)
    {
        itemToDraw = new Equipment("First Sword",worldX*gp.tileSize,worldY*gp.tileSize);
    }
}
