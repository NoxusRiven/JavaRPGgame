package GameLogic;

import Entities.Player;
import Items.ItemManager;
import Maps.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    //SCREEN SETTINGS
    public final int originalTileSize = 16; //16x16 tile
    public final int scale = 3;

    public final int tileSize = originalTileSize*scale; //game tile 48x48
    public final int maxScreenCol = 32;
    public final int maxScreenRow = 20;
    public final int maxScreenWidth = tileSize*maxScreenCol;
    public final int maxScreenHeight = tileSize*maxScreenRow;

    //WORLD SETTINGS
    public final int maxWorldCol = 60;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;

    //FPS
    public final int FPS = 60;

    //CLASSES NEEDED FOR GAME
    public KeyHandler keyHandler = new KeyHandler();
    public Thread gameThread;
    public ItemManager itemManager = new ItemManager(this);
    public TileManager tileManager = new TileManager(this);
    public Player player = new Player(this, keyHandler);


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(maxScreenWidth,maxScreenHeight));
        this.setBackground(new Color(255,70,90)); //TODO make it same as ground image (or we will fill it with some [maybe hell] art)
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        System.out.println();
        gameThread.start();
    }

    //MAIN GAME LOOP
    @Override
    public void run()
    {
        double drawInterval = (double)1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread!=null)
        {
            //set time in nanoseconds
            currentTime = System.nanoTime();

            //increase delta by fraction every iteration
            delta += (currentTime-lastTime)/drawInterval;

            //current time will go up so this is now lastTime
            lastTime = currentTime;

            //if delta is more then 1 then it means that game ran 60 frames in sec so it can update
            if(delta >= 1)
            {
                //update abstract position of a player
                player.update();

                //draw updated position of all sprites
                repaint();

                //reset delta so process will start all over again
                delta--;
            }

        }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileManager.draw(g2);

        itemManager.itemToDraw.draw(g2,this);

        player.draw(g2);
    }
}
