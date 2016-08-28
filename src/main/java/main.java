import java.util.List;
import java.util.Scanner;

/**
 * Created by Lab_kairos on 2016-08-27.
 */
public class main {


    public static void main(String[] args) {
        ItemManager im = new ItemManager();
        im.readItemsFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- 아이템 관리자 ----------");
        System.out.println("00000 입력시 종료");
        boolean exitFlag = false;
        List<ItemInfo> item;
        while (!exitFlag) {
            System.out.print("찾을 아이템 이름 : ");
            String input = scanner.nextLine();
            if (input.equals("00000")) {
                exitFlag = true;
            } else {

                item = im.findItemByName(input);
                if (item == null) {
                    System.out.println("아이템이 없습니다.");
                    continue;
                }

                System.out.print("체력과 마력을 수정합니다. 수정값 : ");
                int val = scanner.nextInt();
                //item.setHealth(item.getHealth() + val*10000);
               // item.setMagic(item.getMagic() + val*10000);
            }
        }

        im.saveFile();

    }
}
