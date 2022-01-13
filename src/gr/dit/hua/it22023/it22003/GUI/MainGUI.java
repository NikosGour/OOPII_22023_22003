package gr.dit.hua.it22023.it22003.GUI;

//region Imports
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import gr.dit.hua.it22023.it22003.Utils.Utils;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Locale;
//endregion

public class MainGUI extends JFrame
{
    private JPanel    MainPanel;
    public  JTextPane recommendCitiesTextPane;
    
    private final JMenuBar menuBar = new JMenuBar();
    
    
    public MainGUI(String title) throws HeadlessException
    {
        
        super(title);
        initComponents();
        this.setJMenuBar(menuBar);
        this.setContentPane(MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        new AgeSelectionWindow("Travel Advisor" , this);
    }
    
    
    private void initComponents()
    {
        
        this.setLayout(null);
        this.setPreferredSize(new Dimension(500 , 500));
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                try
                {
                    Utils.writeJSON();
                } catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
        
        
        //
        // recommendCitiesTextPane
        //
        StyledDocument doc = recommendCitiesTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center , StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0 , doc.getLength() , center , false);
        //
        //  menuBar
        //
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);
        
        JMenuItem item_EnterNewAge = new JMenuItem("Age Selection");
        JMenuItem item_PersonaliseRecommendation = new JMenuItem("Personalize interests");
        
        item_EnterNewAge.addActionListener(e -> openAgeSelectionWindow());
        item_PersonaliseRecommendation.addActionListener(e -> openPersonalizedSelector());
        
        menu.add(item_EnterNewAge);
        menu.add(item_PersonaliseRecommendation);
        
        JMenu secondary_menu = new JMenu("Help");
        secondary_menu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(secondary_menu);
        
        
    }
    
    private void openAgeSelectionWindow()
    {
        new AgeSelectionWindow(this.getTitle() , this);
        this.setVisible(false);
    }
    
    private void openPersonalizedSelector()
    {
        new PersonalizedSelector(this.getTitle() , this);
        this.setVisible(false);
    }
    public static void CreateGUI()
    {
        @SuppressWarnings("unused") MainGUI GUI = new MainGUI("Travel Advisor");
    }
    
    public void close()
    {
        this.dispatchEvent(new WindowEvent(this , WindowEvent.WINDOW_CLOSING));
    }
    
    
    //region
    
    {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }
    
    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayoutManager(1 , 1 , new Insets(0 , 0 , 0 , 0) , - 1 , - 1));
        MainPanel.setForeground(new Color(- 257));
        recommendCitiesTextPane = new JTextPane();
        recommendCitiesTextPane.setBackground(new Color(- 1118482));
        recommendCitiesTextPane.setEditable(false);
        Font recommendCitiesTextPaneFont =
                this.$$$getFont$$$("JetBrains Mono" , Font.PLAIN , 22 , recommendCitiesTextPane.getFont());
        if (recommendCitiesTextPaneFont != null) recommendCitiesTextPane.setFont(recommendCitiesTextPaneFont);
        recommendCitiesTextPane.setForeground(new Color(- 16777216));
        MainPanel.add(recommendCitiesTextPane , new GridConstraints(0 , 0 , 1 , 1 , GridConstraints.ANCHOR_NORTH , GridConstraints.FILL_HORIZONTAL , GridConstraints.SIZEPOLICY_WANT_GROW , GridConstraints.SIZEPOLICY_WANT_GROW , null , new Dimension(150 , 50) , null , 0 , false));
    }
    
    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName , int style , int size , Font currentFont)
    {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null)
        {
            resultName = currentFont.getName();
        } else
        {
            Font testFont = new Font(fontName , Font.PLAIN , 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1'))
            {
                resultName = fontName;
            } else
            {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName , style >= 0 ? style : currentFont.getStyle() , size >=
                                                                                        0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name" , "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback =
                isMac ? new Font(font.getFamily() , font.getStyle() , font.getSize()) : new StyleContext().getFont(font.getFamily() , font.getStyle() , font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }
    
    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return MainPanel;
    }
    
}
