package gr.dit.hua.it22023.it22003.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gr.dit.hua.it22023.it22003.Exceptions.IncorrectArgumentException;
import gr.dit.hua.it22023.it22003.Models.OpenData.weather.Main;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class AgeSelectionWindow extends JFrame
{
    
    private JPanel Main_Panel;
    private JTextField ageTextField;
    private JButton confirmButton;
    private JLabel ageLabel;
    private final MainGUI main;
    private final KeyListener keyListener = new KeyListener();
    
    public AgeSelectionWindow(String title , MainGUI main) throws HeadlessException
    {
        super(title);
        this.main = main;
        main.setVisible(false);
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
        this.setPreferredSize(new Dimension(300 , 100));
        this.setResizable(false);
        this.addWindowFocusListener(new WindowFocusListener()
        {
            @Override
            public void windowGainedFocus(WindowEvent e)
            {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyListener);
            }

            @Override
            public void windowLostFocus(WindowEvent e)
            {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(keyListener);
            }

        });
        //
        // confirmButton
        //
        this.confirmButton.setFocusable(false);
        this.confirmButton.setFocusPainted(false);
        this.confirmButton.addActionListener(e -> {
            int age;
            try
            {
    
                age = Integer.parseInt(ageTextField.getText());
                Perceptron perceptron = Utils.assign_age_group(age);
                GUIRecommend(perceptron);
    
    
            } catch (NumberFormatException | IncorrectArgumentException ex)
            {
                JOptionPane.showMessageDialog(null , "Please enter a valid age" , "Error" , JOptionPane.ERROR_MESSAGE);
            }
            this.ageTextField.setText("");
        });
    
        //
        // ageTextField
        //
        
    }
    
    private void GUIRecommend(Perceptron perceptron)
    {
        try
        {
            Utils.threadSafety();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Utils.after_threads_died_routine();
        AtomicReference<String> cities = new AtomicReference<>("");
        perceptron.recommend().forEach(x -> cities.set(cities.get() + x + "\n"));
        main.recommendCitiesTextPane.setText(cities.get());
        main.setVisible(true);
        this.dispose();
        
    }
    
    
    private void terminateMain()
    {
        main.close();
    }
    
    private class KeyListener implements KeyEventDispatcher
    {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e)
            {
                if (e.getID() == KeyEvent.KEY_PRESSED)
                {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    {
                        confirmButton.doClick();
                    }
                }
                return false;
            }
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
        Main_Panel.setLayout(new GridLayoutManager(2 , 6 , new Insets(0 , 0 , 0 , 0) , - 1 , - 1));
        ageTextField = new JTextField();
        Main_Panel.add(ageTextField , new GridConstraints(1 , 1 , 1 , 1 , GridConstraints.ANCHOR_WEST , GridConstraints.FILL_HORIZONTAL ,
                                                          GridConstraints.SIZEPOLICY_CAN_SHRINK |
                                                          GridConstraints.SIZEPOLICY_CAN_GROW , GridConstraints.SIZEPOLICY_CAN_SHRINK |
                                                                                                GridConstraints.SIZEPOLICY_CAN_GROW , null , new Dimension(50 , - 1) , null , 0 , false));
        confirmButton = new JButton();
        confirmButton.setText("Button");
        Main_Panel.add(confirmButton , new GridConstraints(1 , 4 , 1 , 1 , GridConstraints.ANCHOR_CENTER , GridConstraints.FILL_HORIZONTAL ,
                                                           GridConstraints.SIZEPOLICY_CAN_SHRINK |
                                                           GridConstraints.SIZEPOLICY_CAN_GROW , GridConstraints.SIZEPOLICY_FIXED , null , null , null , 0 , false));
        ageLabel = new JLabel();
        Font ageLabelFont = this.$$$getFont$$$(null , - 1 , 14 , ageLabel.getFont());
        if (ageLabelFont != null) ageLabel.setFont(ageLabelFont);
        ageLabel.setText("Age");
        Main_Panel.add(ageLabel , new GridConstraints(0 , 1 , 1 , 1 , GridConstraints.ANCHOR_WEST , GridConstraints.FILL_NONE , GridConstraints.SIZEPOLICY_FIXED , GridConstraints.SIZEPOLICY_FIXED , null , null , null , 0 , false));
        final Spacer spacer1 = new Spacer();
        Main_Panel.add(spacer1 , new GridConstraints(1 , 0 , 1 , 1 , GridConstraints.ANCHOR_CENTER , GridConstraints.FILL_HORIZONTAL , GridConstraints.SIZEPOLICY_WANT_GROW , 1 , null , null , null , 0 , false));
        final Spacer spacer2 = new Spacer();
        Main_Panel.add(spacer2 , new GridConstraints(1 , 5 , 1 , 1 , GridConstraints.ANCHOR_CENTER , GridConstraints.FILL_HORIZONTAL , GridConstraints.SIZEPOLICY_WANT_GROW , 1 , null , null , null , 0 , false));
        final Spacer spacer3 = new Spacer();
        Main_Panel.add(spacer3 , new GridConstraints(1 , 2 , 1 , 1 , GridConstraints.ANCHOR_CENTER , GridConstraints.FILL_HORIZONTAL , GridConstraints.SIZEPOLICY_WANT_GROW , 1 , null , null , null , 0 , false));
        final Spacer spacer4 = new Spacer();
        Main_Panel.add(spacer4 , new GridConstraints(1 , 3 , 1 , 1 , GridConstraints.ANCHOR_CENTER , GridConstraints.FILL_HORIZONTAL , GridConstraints.SIZEPOLICY_WANT_GROW , 1 , null , null , null , 0 , false));
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
        return Main_Panel;
    }
}
