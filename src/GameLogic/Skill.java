package GameLogic;

public class Skill
{
    public String name;
    public String description;
    public enum Type
    {
        FIRE,
        COLD,
        PHYSICAL,
        MAGIC,
        POISON
    };
    public Type type;

    public Skill(String name, String description, Type type)
    {
        this.name = name;
        this.description = description;
        this.type = type;
    }
}
