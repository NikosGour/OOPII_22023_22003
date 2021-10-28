package gr.dit.hua.it22023.it22003;

import gr.dit.hua.it22023.it22003.Models.*;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.*;
import gr.dit.hua.it22023.it22003.Utils.*;

import java.util.Arrays;

public class Controler
{
    public static void main(String[] args)
    {
        program_initialization();
        while (true)
        {
            Perceptron Traveler = assign_age_group(read_age());
            Traveler.recommend();
            Traveler.getRecommended_cities().forEach(x -> System.out.println(x));
    
            System.out.println();
            System.out.println(Perceptron.closest_recommended(Traveler));
        }
    }
    
    public static void program_initialization()
    {
        dummy_data();
    }
    
    public static void dummy_data()
    {
        City athens = new City("Athens" , new double[]{ 5 , 10 , 10 , 6 , 10 , 6 , 2 , 288.93 , 40 } , 37.9795 , 23.7162);
        City rome = new City("Rome" , new double[]{ 0 , 39 , 14 , 2 , 5 , 0 , 0 , 295.76 , 20 } , 41.8947 , 12.4839);
        City new_york = new City("New York" , new double[]{ 2 , 52 , 29 , 7 , 12 , 12 , 5 , 290.37 , 1 } , 40.7143 , - 74.006);
        City sydney = new City("Sydney" , new double[]{ 0 , 33 , 30 , 1 , 5 , 5 , 2 , 289.36 , 0 } , - 33.8679 , 151.2073);
        City paris = new City("Paris" , new double[]{ 18 , 35 , 29 , 20 , 0 , 10 , 38 , 280.14 , 0 } , 48.8534 , 2.3488);
        City london = new City("London" , new double[]{ 1 , 48 , 31 , 4 , 15 , 4 , 3 , 284.72 , 90 } , 51.5085 , - 0.1257);
        City bangkok = new City("Bangkok" , new double[]{ 0 , 40 , 6 , 1 , 3 , 2 , 3 , 298.88 , 88 } , 13.75 , 100.5167);
        City hong_kong = new City("Hong Kong" , new double[]{ 1 , 35 , 1 , 1 , 0 , 1 , 2 , 292.89 , 98 } , 22.2855 , 114.1577);
        City dubai = new City("Dubai" , new double[]{ 0 , 21 , 3 , 2 , 1 , 1 , 22 , 302.24 , 0 } , 25.2582 , 55.3047);
        City tokyo = new City("Tokyo" , new double[]{ 0 , 20 , 18 , 1 , 7 , 1 , 0 , 283.26 , 20 } , 35.6895 , 139.6917);
        
        Utils.sort_cities_by_distance();
    }
    
    public static int read_age()
    {
        int age;
        System.out.println("Hello");
        do
        {
            System.out.println("Please insert your age");
            System.out.println("(Enter \"0\" if you want to EXIT the program.)");
            System.out.print("Age : ");
            
            while (! Utils.scan.hasNextInt())
            {
                System.out.println();
                System.out.println("Please enter a NUMBER.");
                System.out.print("Insert your age again : ");
                Utils.scan.next();
            }
            
            age = Utils.scan.nextInt();
            System.out.println();
            if (age == 0)
            {
                System.out.println("Thank you for using the <<Travel-Advisor>> app!");
                System.exit(0);
            }
            
        } while ((age < 16) || (age > 115));
        
        return age;
    }
    
    public static Perceptron assign_age_group(int age)
    {
        Perceptron Traveler = null;
        
        if (age >= 16 && age < 25)
        {
            Traveler = new PerceptronYoungTraveller();
        } else if (age >= 25 && age < 60)
        {
            Traveler = new PerceptronMiddleTraveller();
        } else if (age >= 60 && age < 115)
        {
            Traveler = new PerceptronElderTraveller();
        }
        
        return Traveler;
    }
}
