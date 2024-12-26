package Items;

enum MatRarity //TODO: finish this enum
{
    COMMON,
    RARE,
    VERY_RARE
}

public class Material extends Item
{
    public int count;

    @Override
    public String getClassType() {
        return "Material";
    }
}
