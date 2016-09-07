import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        }
        catch (URISyntaxException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
        catch (NullPointerException e) {e.printStackTrace();}

        this.items = items;
    }

    public void saveFile() {
        //URL fileUrl = getClass().getClassLoader().getResource("item_db_mod.txt");
        try {
            FileOutputStream fos = new FileOutputStream("item_db_mod.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos,"euc-kr");
            BufferedWriter bufferedWriter = new BufferedWriter(osw);

            for(ItemInfo item:items) {
                bufferedWriter.write(getItemString(item));
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
        for(String value: item.values) sb.append(value+",");
        return sb.toString();
    }

    public List<ItemInfo> findItemByName(String itemName) {
        List<ItemInfo> foundItems = new ArrayList<ItemInfo>();
        return foundItems;
    }

    private ItemInfo parseItem(String itemString) {return new ItemInfo(new ArrayList<String>(Arrays.asList(itemString.split(","))));}

}
