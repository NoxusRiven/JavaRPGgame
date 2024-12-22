import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyHandler implements KeyListener
{
    final Set<Integer> pressedKeys = new HashSet<>();


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W)
        {
            pressedKeys.add(KeyEvent.VK_W);
        }
        else if (keyCode == KeyEvent.VK_A)
        {
            pressedKeys.add(KeyEvent.VK_A);
        }
        else if (keyCode == KeyEvent.VK_S)
        {
            pressedKeys.add(KeyEvent.VK_S);
        }
        else if (keyCode == KeyEvent.VK_D)
        {
            pressedKeys.add(KeyEvent.VK_D);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int keyCode = e.getKeyCode();

        if(keyCode==KeyEvent.VK_W)
        {
            pressedKeys.remove(KeyEvent.VK_W);
        }
        else if(keyCode == KeyEvent.VK_A)
        {
            pressedKeys.remove(KeyEvent.VK_A);
        }
        else if(keyCode == KeyEvent.VK_S)
        {
            pressedKeys.remove(KeyEvent.VK_S);
        }
        else if(keyCode == KeyEvent.VK_D)
        {
            pressedKeys.remove(KeyEvent.VK_D);
        }
    }
}
