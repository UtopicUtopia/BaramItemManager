import java.util.ArrayList;

public class ItemInfo {

    ArrayList<String> values;
    public static int attributes_size = 43;
    public enum Attributes
    {
        ITEM_NO,
        ITEM_NAME,
        ITEM_OPTION,
        ITEM_WEARING_IMAGE,
        ITEM_WEARING_IMAGE_DYEING,
        ITEM_IMAGE,
        ITEM_IMAGE_DYEING,
        ITEM_MAXNUM,
        ITEM_DURABILITY,
        ITEM_COST,
        ITEM_FIX_COST,
        ITEM_NAMING_COST,
        ITEM_POWER_REQUIREMENT,
        ITEM_AGILITY_REQUIREMENT,
        ITEM_INTELLECT_REQUIREMENT,
        ITEM_JOB_RESTRICTION,
        ITEM_ADVANCEMENT_RESTRICTION,
        ITEM_LEVEL_RESTRICTION,
        ITEM_ACCURACY,
        ITEM_DAMAGE,
        ITEM_POWER,
        ITEM_AGILITY,
        ITEM_INTELLECT,
        ITEM_HEALTH,
        ITEM_MAGIC,
        ITEM_HEALTH_PERCENTAGE,
        ITEM_MAGIC_PERCENTAGE,
        ITEM_ARMED,
        ITEM_MAGIC_DEFENCE_POWER,
        ITEM_REGENERATION,
        ITEM_SMIN_DAMAGE,
        ITEM_SMAX_DAMAGE,
        ITEM_LMIN_DAMAGE,
        ITEM_LMAX_DAMAGE,
        ITEM_WIELDING_SOUND,
        ITEM_HIT_SOUND,
        ITEM_UNIT,
        ITEM_SCRIPT,
        ITEM_SCRIPT_PROBABILITY,
        ITEM_WEARING_SCRIPT,
        ITEM_WEAROFF_SCRIPT
    }

    public ItemInfo(ArrayList<String> values) {
        this.values = values;
        while(values.size() != 43)
            values.add("");
    }
    public void setAttribute(Attributes atr, String val) {values.set(atr.ordinal(), val);}
    public void setAttribute(int atr, String val) {values.set(atr, val);}
    public String getAttribute(Attributes atr) {return values.get(atr.ordinal());}
    public String getAttribute(int atr) {return values.get(atr);}

}
