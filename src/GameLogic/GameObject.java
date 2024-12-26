package GameLogic;

import Interactables.Gate;
import com.sun.jdi.ClassType;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class GameObject
{
    public final static ArrayList<GameObject> allGameObjects = new ArrayList<>();
    public int worldX, worldY;
    public boolean isColliding = false;

    public GameObject()
    {
        allGameObjects.add(this);
    }

    public abstract Rectangle getHitBox(GamePanel gp);

    public abstract String getClassType();
}
