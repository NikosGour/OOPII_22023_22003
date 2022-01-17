package gr.dit.hua.it22023.it22003.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import gr.dit.hua.it22023.it22003.Exceptions.IncorrectArgumentException;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

public class AgeSelectionWindow extends JFrame
{
      
      private       JPanel      Main_Panel;
      private       JButton     confirmButton;
      private       JLabel      ageLabel;
      private       JSpinner    ageSpinner;
      private final MainGUI     main;
      private final KeyListener keyListener = new KeyListener();
      
      public AgeSelectionWindow(String title , MainGUI main) throws HeadlessException
      {
            super(title);
            this.main = main;
            $$$setupUI$$$();
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
                        main.close();
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
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
                                keyListener);
                  }
                  
                  @Override
                  public void windowLostFocus(WindowEvent e)
                  {
                        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(
                                keyListener);
                  }
                  
            });
            //
            // confirmButton
            //
            this.confirmButton.setFocusable(false);
            this.confirmButton.setFocusPainted(false);
            this.confirmButton.addActionListener(e -> {
                  int        age = (int) ageSpinner.getValue();
                  Perceptron perceptron;
                  try
                  {
                        perceptron = Utils.assign_age_group(age);
                        Utils.logger.log(Level.INFO , "Successfully entered age.");
                        GUIRecommend(perceptron);
                  } catch (IncorrectArgumentException ex)
                  {
                        ex.printStackTrace();
                  }
                  
                  
            });
            
            //
            // ageSpinner
            //
            ((JSpinner.DefaultEditor) ageSpinner.getEditor()).getTextField().setEditable(false);
            ((JSpinner.DefaultEditor) ageSpinner.getEditor()).getTextField().setBackground(Color.WHITE);
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

      private void createUIComponents()
      {
            ageSpinner = new JSpinner(new SpinnerNumberModel(16 , 16 , 100 , 1));
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
      
      //region AutoGenarated
      
      /**
       * Method generated by IntelliJ IDEA GUI Designer
       * >>> IMPORTANT!! <<<
       * DO NOT edit this method OR call it in your code!
       *
       * @noinspection ALL
       */
      private void $$$setupUI$$$()
      {
            createUIComponents();
            Main_Panel = new JPanel();
            Main_Panel.setLayout(new GridLayoutManager(2 ,
                                                       6 ,
                                                       new Insets(0 , 0 , 0 , 0) ,
                                                       - 1 ,
                                                       - 1));
            confirmButton = new JButton();
            Font confirmButtonFont = this.$$$getFont$$$(null , - 1 , 12 , confirmButton.getFont());
            if (confirmButtonFont != null) confirmButton.setFont(confirmButtonFont);
            confirmButton.setText("Confirm");
            Main_Panel.add(confirmButton ,
                           new GridConstraints(1 ,
                                               4 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_CENTER ,
                                               GridConstraints.FILL_HORIZONTAL ,
                                               GridConstraints.SIZEPOLICY_CAN_SHRINK |
                                               GridConstraints.SIZEPOLICY_CAN_GROW ,
                                               GridConstraints.SIZEPOLICY_FIXED ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
            ageLabel = new JLabel();
            Font ageLabelFont = this.$$$getFont$$$(null , - 1 , 14 , ageLabel.getFont());
            if (ageLabelFont != null) ageLabel.setFont(ageLabelFont);
            ageLabel.setText("Age");
            Main_Panel.add(ageLabel ,
                           new GridConstraints(0 ,
                                               1 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_WEST ,
                                               GridConstraints.FILL_NONE ,
                                               GridConstraints.SIZEPOLICY_FIXED ,
                                               GridConstraints.SIZEPOLICY_FIXED ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
            final Spacer spacer1 = new Spacer();
            Main_Panel.add(spacer1 ,
                           new GridConstraints(1 ,
                                               0 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_CENTER ,
                                               GridConstraints.FILL_HORIZONTAL ,
                                               GridConstraints.SIZEPOLICY_WANT_GROW ,
                                               1 ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
            final Spacer spacer2 = new Spacer();
            Main_Panel.add(spacer2 ,
                           new GridConstraints(1 ,
                                               5 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_CENTER ,
                                               GridConstraints.FILL_HORIZONTAL ,
                                               GridConstraints.SIZEPOLICY_WANT_GROW ,
                                               1 ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
            final Spacer spacer3 = new Spacer();
            Main_Panel.add(spacer3 ,
                           new GridConstraints(1 ,
                                               2 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_CENTER ,
                                               GridConstraints.FILL_HORIZONTAL ,
                                               GridConstraints.SIZEPOLICY_WANT_GROW ,
                                               1 ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
            final Spacer spacer4 = new Spacer();
            Main_Panel.add(spacer4 ,
                           new GridConstraints(1 ,
                                               3 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_CENTER ,
                                               GridConstraints.FILL_HORIZONTAL ,
                                               GridConstraints.SIZEPOLICY_WANT_GROW ,
                                               1 ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
            Font ageSpinnerFont = this.$$$getFont$$$(null , - 1 , 16 , ageSpinner.getFont());
            if (ageSpinnerFont != null) ageSpinner.setFont(ageSpinnerFont);
            Main_Panel.add(ageSpinner ,
                           new GridConstraints(1 ,
                                               1 ,
                                               1 ,
                                               1 ,
                                               GridConstraints.ANCHOR_WEST ,
                                               GridConstraints.FILL_HORIZONTAL ,
                                               GridConstraints.SIZEPOLICY_WANT_GROW ,
                                               GridConstraints.SIZEPOLICY_FIXED ,
                                               null ,
                                               null ,
                                               null ,
                                               0 ,
                                               false));
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
            Font font = new Font(resultName ,
                                 style >= 0 ? style : currentFont.getStyle() ,
                                 size >= 0 ? size : currentFont.getSize());
            boolean isMac = System.getProperty("os.name" , "")
                                  .toLowerCase(Locale.ENGLISH)
                                  .startsWith("mac");
            Font fontWithFallback = isMac ? new Font(font.getFamily() ,
                                                     font.getStyle() ,
                                                     font.getSize()) : new StyleContext().getFont(
                    font.getFamily() ,
                    font.getStyle() ,
                    font.getSize());
            return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(
                    fontWithFallback);
      }
      
      /**
       * @noinspection ALL
       */
      public JComponent $$$getRootComponent$$$()
      {
            return Main_Panel;
      }
      
      //endregion
}
