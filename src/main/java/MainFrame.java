import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by Lab_kairos on 2016-08-28.
 */
public class MainFrame implements ListSelectionListener{
    ItemManager im  = new ItemManager();
    List<String> itemNames = new ArrayList<String>();
    JFrame frame = new JFrame("Item Manager - by kairos & paganinist");
    JPanel topPanel = new JPanel();
    JPanel searchListPanel = new JPanel();
    JPanel attributePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel titleLabel = new JLabel();
    JList list = new JList();
    Map<String,Component> components = new HashMap<String, Component>();

    private void createTopPanel() {
        JPanel searchPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        JTextField searchBox = new JTextField("검색",18);
        JButton searchButton = new JButton("검색");
        components.put("searchBox",searchBox);
        components.put("searchButton",searchButton);
        searchBox.selectAll();
        searchPanel.add(searchBox);
        searchPanel.add(searchButton);
        titlePanel.add(titleLabel);
        topPanel.setLayout(new GridLayout(1,2));
        topPanel.add(searchPanel);
        topPanel.add(titlePanel);
    }

    private void createBottomPanel() {
        JPanel saveLoadPanel = new JPanel();
        JButton loadButton = new JButton("불러오기");
        JButton saveButton = new JButton("저장");

        components.put("loadButton",loadButton);
        components.put("saveButton", saveButton);

        saveLoadPanel.add(saveButton);
        saveLoadPanel.add(loadButton);

        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.add(new JPanel());
        bottomPanel.add(saveLoadPanel);
    }
    private void createSearchListPanel(List<ItemInfo> itemList) {
        for(ItemInfo i : itemList){
            itemNames.add(i.getName());
        }

        JScrollPane scrollPane = new JScrollPane();
        list = new JList(itemNames.toArray());
        list.addListSelectionListener(this);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        scrollPane.setPreferredSize(new Dimension(290,510));
        scrollPane.setViewportView(list);
        searchListPanel.add(scrollPane);

    }

    private void createAttributePanel() {
        attributePanel.setSize(290,510);

        JScrollPane scrollPane = new JScrollPane();
        JPanel scrollPane_inner = new JPanel();
        scrollPane_inner.setLayout(new BoxLayout(scrollPane_inner, BoxLayout.Y_AXIS));
        URL fileUrl = getClass().getClassLoader().getResource("attribute_list.txt");

        try {
            String line;
            File file = new File(fileUrl.toURI());
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
            while((line = bis.readLine()) != null)
            {
                System.out.println(line);
                JPanel attPanel = new JPanel();
                JLabel attLabel = new JLabel(line + " : ");
                JTextField attField = new JTextField("",20);
                attField.setText("");
                attPanel.add(attLabel);
                attPanel.add(attField);
                scrollPane_inner.add(attPanel);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }catch(URISyntaxException e)
        {
            e.printStackTrace();
        }

        scrollPane.setMinimumSize(new Dimension(290, 510));
        scrollPane.setPreferredSize(new Dimension(290, 510));
        scrollPane.setViewportView(scrollPane_inner);
        attributePanel.add(scrollPane, BorderLayout.CENTER);
    }


    public void createFrame() {
        im.readItemsFile();

        createTopPanel();
        createBottomPanel();
        createSearchListPanel(im.getItmes());
        createAttributePanel();

        frame.setLayout(new BorderLayout());
        Container container = frame.getContentPane();

        container.add(topPanel,BorderLayout.NORTH);
        container.add(bottomPanel,BorderLayout.SOUTH);
        container.add(searchListPanel,BorderLayout.WEST);
        container.add(attributePanel,BorderLayout.EAST);

        frame.setSize(600,610);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        mainFrame.createFrame();
    }

    public void valueChanged(ListSelectionEvent e) {
        if(!e.getValueIsAdjusting()) {
            System.out.println(e.getFirstIndex());
            titleLabel.setText(list.getSelectedValue().toString());
        }
    }

}
