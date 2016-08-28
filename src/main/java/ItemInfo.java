/**
 * Created by Lab_kairos on 2016-08-27.
 */
public class ItemInfo {
    private int No;
    private String name;
    private int type;
    private int option;
    private int wearingImage;
    private int wearingImageDyeing;
    private int image;
    private int imageDyeing;
    private int maxNumber;
    private int durability;
    private int cost;
    private int fixCost;
    private int namingCost;
    private int powerRequirement;
    private int afilityRequirement;
    private int intellictRequirement;
    private int genderRestriction;
    private int jobRestriction;
    private int advancementRestriction;
    private int levelRestriction;
    private int accuracy;
    private int damage;
    private int power;
    private int afility;
    private int intellict;
    private int health;
    private int magic;
    private int healthPercentage;
    private int magicPercentage;
    private int armed;
    private int magicDefencePower;
    private int Regeneration;
    private int sMinDamage;
    private int sMaxDamage;
    private int iMinDamage;
    private int iMaxDamage;
    private int wieldingSound;
    private int hitSound;
    private String unit;
    private String script;
    private int scriptProbability;
    private String wearingScript;
    private String wearOffScript;

    public ItemInfo() {
        initialize();
    }

    private void initialize() {
        No=0;
        name="";
        type=0;
        option=0;
        wearingImage=0;
        wearingImageDyeing=0;
        image=0;
        imageDyeing=0;
        maxNumber=0;
        durability=0;
        cost=0;
        fixCost=0;
        namingCost=0;
        powerRequirement=0;
        afilityRequirement=0;
        intellictRequirement=0;
        genderRestriction=0;
        jobRestriction=0;
        advancementRestriction=0;
        levelRestriction=0;
        accuracy=0;
        damage=0;
        power=0;
        afility=0;
        intellict=0;
        health=0;
        magic=0;
        healthPercentage=0;
        magicPercentage=0;
        armed=0;
        magicDefencePower=0;
        Regeneration=0;
        sMinDamage=0;
        sMaxDamage=0;
        iMinDamage=0;
        iMaxDamage=0;
        wieldingSound=0;
        hitSound=0;
        unit="";
        script="";
        scriptProbability=0;
        wearingScript="";
        wearOffScript="";
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getWearingImage() {
        return wearingImage;
    }

    public void setWearingImage(int wearingImage) {
        this.wearingImage = wearingImage;
    }

    public int getWearingImageDyeing() {
        return wearingImageDyeing;
    }

    public void setWearingImageDyeing(int wearingImageDyeing) {
        this.wearingImageDyeing = wearingImageDyeing;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageDyeing() {
        return imageDyeing;
    }

    public void setImageDyeing(int imageDyeing) {
        this.imageDyeing = imageDyeing;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getFixCost() {
        return fixCost;
    }

    public void setFixCost(int fixCost) {
        this.fixCost = fixCost;
    }

    public int getNamingCost() {
        return namingCost;
    }

    public void setNamingCost(int namingCost) {
        this.namingCost = namingCost;
    }

    public int getPowerRequirement() {
        return powerRequirement;
    }

    public void setPowerRequirement(int powerRequirement) {
        this.powerRequirement = powerRequirement;
    }

    public int getAfilityRequirement() {
        return afilityRequirement;
    }

    public void setAfilityRequirement(int afilityRequirement) {
        this.afilityRequirement = afilityRequirement;
    }

    public int getIntellictRequirement() {
        return intellictRequirement;
    }

    public void setIntellictRequirement(int intellictRequirement) {
        this.intellictRequirement = intellictRequirement;
    }

    public int getGenderRestriction() {
        return genderRestriction;
    }

    public void setGenderRestriction(int genderRestriction) {
        this.genderRestriction = genderRestriction;
    }

    public int getJobRestriction() {
        return jobRestriction;
    }

    public void setJobRestriction(int jobRestriction) {
        this.jobRestriction = jobRestriction;
    }

    public int getAdvancementRestriction() {
        return advancementRestriction;
    }

    public void setAdvancementRestriction(int advancementRestriction) {
        this.advancementRestriction = advancementRestriction;
    }

    public int getLevelRestriction() {
        return levelRestriction;
    }

    public void setLevelRestriction(int levelRestriction) {
        this.levelRestriction = levelRestriction;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAfility() {
        return afility;
    }

    public void setAfility(int afility) {
        this.afility = afility;
    }

    public int getIntellict() {
        return intellict;
    }

    public void setIntellict(int intellict) {
        this.intellict = intellict;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getHealthPercentage() {
        return healthPercentage;
    }

    public void setHealthPercentage(int healthPercentage) {
        this.healthPercentage = healthPercentage;
    }

    public int getMagicPercentage() {
        return magicPercentage;
    }

    public void setMagicPercentage(int magicPercentage) {
        this.magicPercentage = magicPercentage;
    }

    public int getArmed() {
        return armed;
    }

    public void setArmed(int armed) {
        this.armed = armed;
    }

    public int getMagicDefencePower() {
        return magicDefencePower;
    }

    public void setMagicDefencePower(int magicDefencePower) {
        this.magicDefencePower = magicDefencePower;
    }

    public int getRegeneration() {
        return Regeneration;
    }

    public void setRegeneration(int regeneration) {
        Regeneration = regeneration;
    }

    public int getsMinDamage() {
        return sMinDamage;
    }

    public void setsMinDamage(int sMinDamage) {
        this.sMinDamage = sMinDamage;
    }

    public int getsMaxDamage() {
        return sMaxDamage;
    }

    public void setsMaxDamage(int sMaxDamage) {
        this.sMaxDamage = sMaxDamage;
    }

    public int getiMinDamage() {
        return iMinDamage;
    }

    public void setiMinDamage(int iMinDamage) {
        this.iMinDamage = iMinDamage;
    }

    public int getiMaxDamage() {
        return iMaxDamage;
    }

    public void setiMaxDamage(int iMaxDamage) {
        this.iMaxDamage = iMaxDamage;
    }

    public int getWieldingSound() {
        return wieldingSound;
    }

    public void setWieldingSound(int wieldingSound) {
        this.wieldingSound = wieldingSound;
    }

    public int getHitSound() {
        return hitSound;
    }

    public void setHitSound(int hitSound) {
        this.hitSound = hitSound;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public int getScriptProbability() {
        return scriptProbability;
    }

    public void setScriptProbability(int scriptProbability) {
        this.scriptProbability = scriptProbability;
    }

    public String getWearingScript() {
        return wearingScript;
    }

    public void setWearingScript(String wearingScript) {
        this.wearingScript = wearingScript;
    }

    public String getWearOffScript() {
        return wearOffScript;
    }

    public void setWearOffScript(String wearOffScript) {
        this.wearOffScript = wearOffScript;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemInfo itemInfo = (ItemInfo) o;

        if (No != itemInfo.No) return false;
        if (type != itemInfo.type) return false;
        if (option != itemInfo.option) return false;
        if (wearingImage != itemInfo.wearingImage) return false;
        if (wearingImageDyeing != itemInfo.wearingImageDyeing) return false;
        if (image != itemInfo.image) return false;
        if (imageDyeing != itemInfo.imageDyeing) return false;
        if (maxNumber != itemInfo.maxNumber) return false;
        if (durability != itemInfo.durability) return false;
        if (cost != itemInfo.cost) return false;
        if (fixCost != itemInfo.fixCost) return false;
        if (namingCost != itemInfo.namingCost) return false;
        if (powerRequirement != itemInfo.powerRequirement) return false;
        if (afilityRequirement != itemInfo.afilityRequirement) return false;
        if (intellictRequirement != itemInfo.intellictRequirement) return false;
        if (genderRestriction != itemInfo.genderRestriction) return false;
        if (jobRestriction != itemInfo.jobRestriction) return false;
        if (advancementRestriction != itemInfo.advancementRestriction) return false;
        if (levelRestriction != itemInfo.levelRestriction) return false;
        if (accuracy != itemInfo.accuracy) return false;
        if (damage != itemInfo.damage) return false;
        if (power != itemInfo.power) return false;
        if (afility != itemInfo.afility) return false;
        if (intellict != itemInfo.intellict) return false;
        if (health != itemInfo.health) return false;
        if (magic != itemInfo.magic) return false;
        if (healthPercentage != itemInfo.healthPercentage) return false;
        if (magicPercentage != itemInfo.magicPercentage) return false;
        if (armed != itemInfo.armed) return false;
        if (magicDefencePower != itemInfo.magicDefencePower) return false;
        if (Regeneration != itemInfo.Regeneration) return false;
        if (sMinDamage != itemInfo.sMinDamage) return false;
        if (sMaxDamage != itemInfo.sMaxDamage) return false;
        if (iMinDamage != itemInfo.iMinDamage) return false;
        if (iMaxDamage != itemInfo.iMaxDamage) return false;
        if (wieldingSound != itemInfo.wieldingSound) return false;
        if (hitSound != itemInfo.hitSound) return false;
        if (scriptProbability != itemInfo.scriptProbability) return false;
        if (!name.equals(itemInfo.name)) return false;
        if (unit != null ? !unit.equals(itemInfo.unit) : itemInfo.unit != null) return false;
        if (script != null ? !script.equals(itemInfo.script) : itemInfo.script != null) return false;
        if (wearingScript != null ? !wearingScript.equals(itemInfo.wearingScript) : itemInfo.wearingScript != null)
            return false;
        return wearOffScript != null ? wearOffScript.equals(itemInfo.wearOffScript) : itemInfo.wearOffScript == null;

    }

    @Override
    public int hashCode() {
        int result = No;
        result = 31 * result + name.hashCode();
        result = 31 * result + type;
        result = 31 * result + option;
        result = 31 * result + wearingImage;
        result = 31 * result + wearingImageDyeing;
        result = 31 * result + image;
        result = 31 * result + imageDyeing;
        result = 31 * result + maxNumber;
        result = 31 * result + durability;
        result = 31 * result + cost;
        result = 31 * result + fixCost;
        result = 31 * result + namingCost;
        result = 31 * result + powerRequirement;
        result = 31 * result + afilityRequirement;
        result = 31 * result + intellictRequirement;
        result = 31 * result + genderRestriction;
        result = 31 * result + jobRestriction;
        result = 31 * result + advancementRestriction;
        result = 31 * result + levelRestriction;
        result = 31 * result + accuracy;
        result = 31 * result + damage;
        result = 31 * result + power;
        result = 31 * result + afility;
        result = 31 * result + intellict;
        result = 31 * result + health;
        result = 31 * result + magic;
        result = 31 * result + healthPercentage;
        result = 31 * result + magicPercentage;
        result = 31 * result + armed;
        result = 31 * result + magicDefencePower;
        result = 31 * result + Regeneration;
        result = 31 * result + sMinDamage;
        result = 31 * result + sMaxDamage;
        result = 31 * result + iMinDamage;
        result = 31 * result + iMaxDamage;
        result = 31 * result + wieldingSound;
        result = 31 * result + hitSound;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (script != null ? script.hashCode() : 0);
        result = 31 * result + scriptProbability;
        result = 31 * result + (wearingScript != null ? wearingScript.hashCode() : 0);
        result = 31 * result + (wearOffScript != null ? wearOffScript.hashCode() : 0);
        return result;
    }
}
