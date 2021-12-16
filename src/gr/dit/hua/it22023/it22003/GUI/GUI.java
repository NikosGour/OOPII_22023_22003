package gr.dit.hua.it22023.it22003.GUI;

import javax.swing.*;
import java.awt.*;

public class GUI {

      private JPanel Main_Panel;

      public static void CreateGUI() {
            JFrame GUI = new JFrame("Travel Advisor");
            GUI.setPreferredSize(new Dimension(500, 500));
            GUI.setLocationRelativeTo(null);
            GUI.setVisible(true);
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
}
