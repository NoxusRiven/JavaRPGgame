import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager
{
    GamePanel gp;
    Tile[] tiles;
    int[][] mapTileNum;

    public TileManager(GamePanel gp)
    {
        this.gp = gp;

        tiles = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTiles();

        loadMap("mainMap.txt");
    }

    public void getTiles() //TODO - make this an actual image (IN PROCESS)
    {
        /*TODO:
            Idea make it a hell grinder where there will be 7 maps as layers of hell (add some heroes based on that, maybe some heaven part to heroes and maps
        */
        tiles[0] = new Tile(); //grass
        tiles[1] = new Tile(); //brick
        tiles[2] = new Tile(); //rock
        tiles[3] = new Tile(); //mineral

        //SET COLLISION
        tiles[1].collision = true;

        //DRAW IMAGES
        try
        {
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Blocks/grass tile.png"));
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/Sprites/Blocks/brick tile.png"));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //tiles[2].color = Color.gray; //rock

        //tiles[3].color = new Color(90,100,150); //mineral


    }

    public void update()
    {

    }

    public void loadMap(String map)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(map);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine();

                while(col < gp.maxWorldCol)
                {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();

        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }

    public void draw(Graphics2D g2)
    {
        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow<gp.maxWorldRow)
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;

            if(worldX > gp.player.worldX - gp.player.screenX - gp.tileSize &&
               worldX < gp.player.worldX + gp.player.screenX + gp.tileSize &&
               worldY > gp.player.worldY - gp.player.screenY - gp.tileSize &&
               worldY < gp.player.worldY + gp.player.screenY + gp.tileSize )
            {
                g2.drawImage(tiles[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            worldCol++;

            if(worldCol == gp.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
