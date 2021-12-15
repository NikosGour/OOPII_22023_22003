package gr.dit.hua.it22023.it22003;

import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import javax.swing.*;

/**
 * Main Class with the main function
 */
public class Controller
{
    public static void main(String[] args) throws InterruptedException
    {
        
        CreateGUI();
        Utils.program_initialization();
    
        //noinspection InfiniteLoopStatement
        while (true)
        {
            Perceptron Traveler = Utils.assign_age_group();
            
            for (Thread thread : Utils.threads)
            {
                if (thread.isAlive())
                {
                    //noinspection BusyWait
                    Thread.sleep(500);
                }
            }
            
            Utils.after_threads_died_routine();
            
            Traveler.recommend().forEach(System.out::println);
            
            System.out.println();
        }
    }
    
     public static void CreateGUI() {
        ImageIcon earth_img = new ImageIcon("image.jpg");

        JFrame GUI = new JFrame("Travel Advisor");
        GUI.setIconImage(earth_img.getImage());
        GUI.setSize(500, 500);
        GUI.setLocationRelativeTo(null);
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
   
}
