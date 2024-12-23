import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable
{
    //SCREEN SETTINGS
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize*scale; //game tile 48x48
    final int maxScreenCol = 32;
    final int maxScreenRow = 20;
    final int maxScreenWidth = tileSize*maxScreenCol;
    final int maxScreenHeight = tileSize*maxScreenRow;

    //WORLD SETTINGS
    final int maxWorldCol = 60;
    final int maxWorldRow = 50;
    final int worldWidth = tileSize*maxWorldCol;
    final int worldHeight = tileSize*maxWorldRow;

    //FPS
    final int FPS = 60;

    //CLASSES NEEDED FOR GAME
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    //CollisionChecker colliChecker = new CollisionChecker(this);
    TileManager tileManager = new TileManager(this);
    Player player = new Player(this, keyHandler);


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
        player.draw(g2);
    }
}
