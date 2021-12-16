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
    }
    
    public GUI() throws HeadlessException
    {
        super();
        initComponents();
        this.setSize(new Dimension(500,500));
        this.setContentPane(Main_Panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void initComponents()
    {
        button1.setSize(new Dimension(100,100));
        button2.setSize(new Dimension(100,100));
        button1.setText("Hello");
        button2.setText("World");
        this.add(button1);
        this.add(button2);
    }
    
    public static void CreateGUI()
    {
        GUI GUI = new GUI("Travel Advisor");
        GUI.setVisible(true);

  
    }
}
