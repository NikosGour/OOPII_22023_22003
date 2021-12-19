package gr.dit.hua.it22023.it22003.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    
    private JPanel Main_Panel;
    
    public GUI(String title) throws HeadlessException
    {
        super(title);
        initComponents();
        this.setPreferredSize(new Dimension(500, 500));
        this.setContentPane(Main_Panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    
    private void initComponents()
    {
   
    }
    
    public static void CreateGUI()
    {
        GUI GUI = new GUI("Travel Advisor");
        
        
    }
}
