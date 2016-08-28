import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Lab_kairos on 2016-08-28.
 */
public class MainFrame {
    ItemManager im  = new ItemManager();

    JFrame frame = new JFrame("Item Manager - by kairos");
    JPanel topPanel = new JPanel();
    JPanel searchListPanel = new JPanel();
    JPanel attributePanel = new JPanel();

    Map<String,Component> components = new HashMap<String, Component>();

    private void createTopPanel() {
        JPanel searchPanel = new JPanel();
        JPanel saveLoadPanel = new JPanel();

        JTextField searchBox = new JTextField("검색",18);
        JButton searchButton = new JButton("검색");

        JButton loadButton = new JButton("불러오기");
        JButton savaButton = new JButton("저장");

        components.put("searchBox",searchBox);
        components.put("searchButton",searchButton);
        components.put("loadButton",loadButton);
        components.put("saveButton", savaButton);

        searchBox.selectAll();


        searchPanel.add(searchBox);
        searchPanel.add(searchButton);

        saveLoadPanel.add(savaButton);
        saveLoadPanel.add(loadButton);

        topPanel.setLayout(new GridLayout(1,2));
        topPanel.add(searchPanel);
        topPanel.add(saveLoadPanel);
    }

    private void createSearchListPanel(List<ItemInfo> itemList) {

        List<String> itemNames = new ArrayList<String>();
        for(ItemInfo i : itemList){
            itemNames.add(i.getName());
        }

        JScrollPane scrollPane = new JScrollPane();
        JList list = new JList(itemNames.toArray());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setPreferredSize(new Dimension(290,510));

        scrollPane.setViewportView(list);

        searchListPanel.add(scrollPane);

    }

    private void createAttributePanel() {
        attributePanel.setSize(290,510);
        attributePanel.setLayout(new GridLayout(15,0));

        JPanel healthPanel = new JPanel();
        JPanel magicPanel = new JPanel();

        JLabel healthLabel = new JLabel("체력 : ");
        JTextField healthField = new JTextField("",20);
        JLabel magicLabel = new JLabel("마력 : ");
        JTextField magicField = new JTextField("",20);

        healthField.setText("");
        magicField.setText("");

        healthPanel.add(healthLabel);
        healthPanel.add(healthField);

        magicPanel.add(magicLabel);
        magicPanel.add(magicField);

        attributePanel.add(healthPanel);
        attributePanel.add(magicPanel);
    }


    public void createFrame() {
        im.readItemsFile();

        createTopPanel();
        createSearchListPanel(im.getItmes());
        createAttributePanel();

        frame.setLayout(new BorderLayout());
        Container container = frame.getContentPane();

        container.add(topPanel,BorderLayout.NORTH);
        container.add(searchListPanel,BorderLayout.WEST);
        container.add(attributePanel,BorderLayout.EAST);

        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        mainFrame.createFrame();
    }

    private class JListHandler implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            JTextField health = (JTextField)((JPanel)(attributePanel.getComponent(0))).getComponent(1);
            JTextField magic = (JTextField)((JPanel)(attributePanel.getComponent(1))).getComponent(1);

            health.setText();
        }
    }
}
