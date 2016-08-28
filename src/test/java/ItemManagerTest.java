import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lab_kairos on 2016-08-27.
 */
public class ItemManagerTest {
    @Test
    public void readItemsFile() throws Exception {
        ItemManager im = new ItemManager();
        im.readItemsFile();
        System.out.println(im.items);
    }

}