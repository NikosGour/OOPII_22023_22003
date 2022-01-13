package gr.dit.hua.it22023.it22003.GUI;

import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PersonalizedSelector extends JFrame
{
    private MainGUI main;
    private JPanel  Main_Panel;
    
    public PersonalizedSelector(String title , MainGUI mainGUI)
    {
        super(title);
        this.main = mainGUI;
        initComponents();
        this.setContentPane(Main_Panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void initComponents()
    {
        this.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                terminateMain();
            }
        });
        this.setLayout(null);
        this.setResizable(false);
    }
    
    
    private void terminateMain()
    {
        main.close();
    }
    
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
        Main_Panel = new JPanel();
        Main_Panel.setLayout(new GridLayoutManager(1 , 1 , new Insets(0 , 0 , 0 , 0) , - 1 , - 1));
    }
    
    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return Main_Panel;
    }
}
