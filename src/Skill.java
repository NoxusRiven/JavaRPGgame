

public class Skill
{
    String name;
    String description;
    public enum Type
    {
        FIRE,
        COLD,
        PHYSICAL,
        MAGIC,
        POISON
    };
    Type type;

    public Skill(String name, String description, Type type)
    {
        this.name = name;
        this.description = description;
        this.type = type;
    }
}
