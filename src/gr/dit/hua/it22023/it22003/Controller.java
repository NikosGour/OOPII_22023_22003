package gr.dit.hua.it22023.it22003;

import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.io.IOException;

public class Controller
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
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
            
            Utils.sort_cities_by_distance();
            
            Traveler.recommend();
            Traveler.getRecommended_cities().forEach(System.out::println);
            
            System.out.println();
            
            
        }
    }
   
}
