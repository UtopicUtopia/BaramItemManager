import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lab_kairos on 2016-08-27.
 */
public class ItemManager {
    List<ItemInfo> items;

    public List<ItemInfo> getItmes() {
        return items;
    }

    public void readItemsFile() {
        List<ItemInfo> items = new ArrayList<ItemInfo>();

        URL fileUrl = getClass().getClassLoader().getResource("item_db.txt");
        try {
            File file = new File(fileUrl.toURI());
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "euc-kr");
            BufferedReader bufferedReader = new BufferedReader(isr);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                if(line.charAt(0) == ';') {
                    continue;
                }
                items.add(parseItem(line));
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.items = items;
    }

    public void saveFile() {
        //URL fileUrl = getClass().getClassLoader().getResource("item_db_mod.txt");
        try {
            FileOutputStream fos = new FileOutputStream("item_db_mod.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"euc-kr");
            BufferedWriter bufferedWriter = new BufferedWriter(osw);

            for(int i=0;i<items.size();i++) {
                bufferedWriter.write(getItemString(items.get(i)));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            osw.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getItemString(ItemInfo item) {
        StringBuffer sb = new StringBuffer();
        sb.append(item.getNo()+",");
        sb.append(item.getName()+",");
        sb.append(item.getType()+",");
        sb.append(item.getOption()+",");
        sb.append(item.getWearingImage()+",");
        sb.append(item.getWearingImageDyeing()+",");
        sb.append(item.getImage()+",");
        sb.append(item.getImageDyeing()+",");
        sb.append(item.getMaxNumber()+",");
        sb.append(item.getDurability()+",");
        sb.append(item.getCost()+",");
        sb.append(item.getFixCost()+",");
        sb.append(item.getNamingCost()+",");
        sb.append(item.getPowerRequirement()+",");
        sb.append(item.getAfilityRequirement()+",");
        sb.append(item.getIntellictRequirement()+",");
        sb.append(item.getGenderRestriction()+",");
        sb.append(item.getJobRestriction()+":");
        sb.append(item.getAdvancementRestriction()+",");
        sb.append(item.getLevelRestriction()+",");
        sb.append(item.getAccuracy()+",");
        sb.append(item.getDamage()+",");
        sb.append(item.getPower()+",");
        sb.append(item.getAfility()+",");
        sb.append(item.getIntellict()+",");
        sb.append(item.getHealth()+",");
        sb.append(item.getMagic()+",");
        sb.append(item.getHealthPercentage()+",");
        sb.append(item.getMagicPercentage()+",");
        sb.append(item.getArmed()+",");
        sb.append(item.getsMinDamage()+",");
        sb.append(item.getsMaxDamage()+",");
        sb.append(item.getiMinDamage()+",");
        sb.append(item.getiMaxDamage()+",");
        sb.append(item.getWieldingSound()+",");
        sb.append(item.getHitSound()+",");
        sb.append(item.getUnit()+",");
        sb.append(item.getScript()+",");
        sb.append(item.getScriptProbability()+",");
        sb.append(item.getWearingScript()+",");
        sb.append(item.getWearOffScript()+",");
        return sb.toString();
    }

    public List<ItemInfo> findItemByName(String itemName) {

        List<ItemInfo> foundItems = new ArrayList<ItemInfo>();
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).getName().contains(itemName)) {
                foundItems.add(items.get(i));
            }
        }
        return foundItems;
    }

    private ItemInfo parseItem(String itemString) {
        ItemInfo itemInfo = new ItemInfo();
        String[] item = itemString.split(",");
        itemInfo.setNo(Integer.parseInt(item[0]));
        itemInfo.setName(item[1]);
        itemInfo.setType(Integer.parseInt(item[2]));
        itemInfo.setOption(Integer.parseInt(item[3]));
        itemInfo.setWearingImage(Integer.parseInt(item[4]));
        itemInfo.setWearingImageDyeing(Integer.parseInt(item[5]));
        itemInfo.setImage(Integer.parseInt(item[6]));
        itemInfo.setImageDyeing(Integer.parseInt(item[7]));
        itemInfo.setMaxNumber(Integer.parseInt(item[8]));
        itemInfo.setDurability(Integer.parseInt(item[9]));
        itemInfo.setCost(Integer.parseInt(item[10]));
        itemInfo.setFixCost(Integer.parseInt(item[11]));
        itemInfo.setNamingCost(Integer.parseInt(item[12]));
        itemInfo.setPowerRequirement(Integer.parseInt(item[13]));
        itemInfo.setAfilityRequirement(Integer.parseInt(item[14]));
        itemInfo.setIntellictRequirement(Integer.parseInt(item[15]));
        itemInfo.setGenderRestriction(Integer.parseInt(item[16]));
        itemInfo.setJobRestriction(Integer.parseInt(item[17].split(":")[0]));
        itemInfo.setAdvancementRestriction(Integer.parseInt(item[17].split(":")[1]));
        itemInfo.setLevelRestriction(Integer.parseInt(item[18]));
        itemInfo.setAccuracy(Integer.parseInt(item[19]));
        itemInfo.setDamage(Integer.parseInt(item[20]));
        itemInfo.setPower(Integer.parseInt(item[21]));
        itemInfo.setAfility(Integer.parseInt(item[22]));
        itemInfo.setIntellict(Integer.parseInt(item[23]));
        itemInfo.setHealth(Integer.parseInt(item[24]));
        itemInfo.setMagic(Integer.parseInt(item[25]));
        itemInfo.setHealthPercentage(Integer.parseInt(item[26]));
        itemInfo.setMagicPercentage(Integer.parseInt(item[27]));
        itemInfo.setArmed(Integer.parseInt(item[28]));
        itemInfo.setMagicDefencePower(Integer.parseInt(item[29]));
        itemInfo.setRegeneration(Integer.parseInt(item[30]));
        itemInfo.setsMinDamage(Integer.parseInt(item[31]));
        itemInfo.setsMaxDamage(Integer.parseInt(item[32]));
        itemInfo.setiMinDamage(Integer.parseInt(item[33]));
        itemInfo.setiMaxDamage(Integer.parseInt(item[34]));
        itemInfo.setWieldingSound(Integer.parseInt(item[35]));
        itemInfo.setHitSound(Integer.parseInt(item[36]));
        itemInfo.setUnit(item[37]);
        itemInfo.setScript(item[38]);
        try {
            itemInfo.setScriptProbability(Integer.parseInt(item[39]));
            itemInfo.setWearingScript(item[40]);
            itemInfo.setWearOffScript(item[41]);
        } catch (ArrayIndexOutOfBoundsException e) {
            itemInfo.setWearingScript("");
            itemInfo.setWearOffScript("");
        }

        return itemInfo;
    }

}
