import javax.swing.*;
/*TODO:
    draw rest of the sprites (IN PROCESS)
    fix moving with collision, it might be problem with HashMap of keys pressed
*/
public class Main
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame();

        window.setTitle("RPG Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GamePanel gamePanel =  new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}