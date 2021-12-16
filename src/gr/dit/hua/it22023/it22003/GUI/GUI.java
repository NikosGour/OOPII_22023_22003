package gr.dit.hua.it22023.it22003.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame
{
    
    private JPanel Main_Panel;
    private JButton button1;
    private JButton button2;
    
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
        button1.setSize(new Dimension(100 , 100));
        button2.setSize(new Dimension(100 , 100));
        button1.setText("Hello");
        button2.setText("World");
   
    }
    
    public static void CreateGUI()
    {
        GUI GUI = new GUI("Travel Advisor");
        
        
    }
}
