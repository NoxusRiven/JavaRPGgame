package Items;

import GameLogic.Skill;

import java.awt.*;

enum EqRarity
{

    COMMON(100, 500, 0, 0.8f, null),
    RARE(500, 1000, 20 , 0.11f,new Skill[]{}),
    VERY_RARE(1000, 1500, 10, 0.07f, new Skill[]{}),
    DEMONIC(2000,3000,2,0.02f,new Skill[]{});

    final int minPrice;
    final int maxPrice;
    final Skill[] skills;
    final int skillChance;
    final float dropChance;

    EqRarity(int minPrice, int maxPrice, int skillChance, float dropChance, Skill[] skills)
    {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.skills = skills;
        this.skillChance=skillChance;
        this.dropChance=dropChance;
    }

    public int randPrice()
    {
        return minPrice + (int)(Math.random() * (maxPrice - minPrice + 1));
    }

    public Skill randSkill() //TODO: finish this method to rand 1 or more (no then 5) skills, decrement chance for next skill
    {
        int count=0;
        boolean newSkill = false;
        while(count<5)
        {
            if((int)(Math.random()*skillChance)<=skills.length)
            {
                newSkill = true;
            }
            else
            {
                break;
            }
            count++;

        }
        return null;
    }
}

public class Equipment extends Item
{
    public EqRarity rarity;
    public Skill[] skill = new Skill[5];
    public float dropChance;

    public Equipment(String name,int worldX, int worldY) //temp constr
    {
        this.name = name;
        this.worldX = worldX;
        this.worldY = worldY;
        color = Color.black;
    }

    public Equipment(){}
}
