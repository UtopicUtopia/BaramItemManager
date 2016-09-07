import com.sun.istack.internal.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class MainFrame implements ListSelectionListener, KeyEventDispatcher{
    private ItemManager im  = new ItemManager();
    private List<String> itemNames = new ArrayList<String>();
    private JFrame frame = new JFrame("Item Manager - by kairos & paganinist");
    private JPanel topPanel = new JPanel();
    private JPanel searchListPanel = new JPanel();
    private JPanel attributePanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JLabel titleLabel = new JLabel();
    private JList list = new JList();

    private JTextField attFields[] = new JTextField[ItemInfo.attributes_size];
    private int currentAmending = 0;
    private Map<String,Component> components = new HashMap<String, Component>();
    private boolean controlKeyPressed = false, shiftKeyPressed = false;
    private boolean contextSaved = true; // does last attribute amendation saved
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
        JButton saveButton = new JButton("저장");
        JButton resetButton = new JButton("리셋");
        saveButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {save();}});
        resetButton.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {reset();}});
        components.put("saveButton", saveButton);
        saveLoadPanel.add(saveButton);
        saveLoadPanel.add(resetButton);
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.add(new JPanel());
        bottomPanel.add(saveLoadPanel);
    }
    private void createSearchListPanel(List<ItemInfo> itemList) {
        for(ItemInfo i : itemList){
            itemNames.add(i.getAttribute(ItemInfo.Attributes.ITEM_NAME));
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

            File file = new File(fileUrl.toURI());
            FileInputStream fis = new FileInputStream(file);
            BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
            for(int l = 0; l < ItemInfo.attributes_size; l++)
            {
                JPanel attPanel = new JPanel();
                JLabel attLabel = new JLabel(bis.readLine() + " : ");
                attFields[l] = new JTextField("",20);
                attFields[l].getDocument().addDocumentListener(new DocumentListener() {
                    public void insertUpdate(DocumentEvent e) {
                        contextSaved = false;
                        titleLabel.setForeground(Color.BLUE);
                    }

                    public void removeUpdate(DocumentEvent e) {
                        contextSaved = false;
                        titleLabel.setForeground(Color.BLUE);
                    }

                    public void changedUpdate(DocumentEvent e) {

                    }
                });
                attPanel.add(attLabel);
                attPanel.add(attFields[l]);
                scrollPane_inner.add(attPanel);
            }
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        catch(IOException e) {e.printStackTrace();}
        catch(URISyntaxException e) {e.printStackTrace();}

        scrollPane.setMinimumSize(new Dimension(290, 510));
        scrollPane.setPreferredSize(new Dimension(290, 510));
        scrollPane.setViewportView(scrollPane_inner);
        attributePanel.add(scrollPane, BorderLayout.CENTER);
    }


    private void createFrame() {
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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventDispatcher(this);

    }

    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        mainFrame.createFrame();

    }

    public void valueChanged(ListSelectionEvent e) {

        final int YES = 0;
        final int NO = 1;
        final int CANCLE = 2;
        int answer = 1;
        ItemInfo ii;
        if(!contextSaved)
            answer = JOptionPane.showConfirmDialog(null, "저장되지 않은 변경사항이 있습니다. 어떻게 하시겠습니까?");

        switch(answer) {
            case YES:
                save();
            case NO:


                ii = im.getItmes().get(list.getSelectedIndex());
                for (int l = 0; l < ItemInfo.attributes_size; l++)
                    attFields[l].setText(ii.getAttribute(l));

                contextSaved = true;
                titleLabel.setText(list.getSelectedValue().toString());
                titleLabel.setForeground(Color.BLACK);
                currentAmending = list.getSelectedIndex();
                break;
            case CANCLE:

                break;

        }


    }

    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_CONTROL:
                    controlKeyPressed = true;
                    break;
                case KeyEvent.VK_SHIFT:
                    shiftKeyPressed = true;
            }

            if(controlKeyPressed)
            {
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_S:
                        save();
                        break;
                }

            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            switch(e.getKeyCode())
            {
                case KeyEvent.VK_CONTROL:
                    controlKeyPressed = false;
                    break;
                case KeyEvent.VK_SHIFT:
                    shiftKeyPressed = false;
            }
        }
        return false;
    }

    private void save()
    {
        contextSaved = true;
        System.out.println("Save");
        ItemInfo target = im.getItmes().get(currentAmending);
        for(int l = 0; l < ItemInfo.attributes_size; l++)
            target.setAttribute(l, attFields[l].getText());
        im.getItmes().set(currentAmending, target);
        im.saveFile();
        titleLabel.setForeground(Color.BLACK);
    }

    private void reset()
    {
        contextSaved = true;
        System.out.println("Reset");
        ItemInfo target = im.getItmes().get(currentAmending);
        for(int l = 0; l < ItemInfo.attributes_size; l++)
            attFields[l].setText(target.getAttribute(l));
        titleLabel.setForeground(Color.BLACK);
    }
}
