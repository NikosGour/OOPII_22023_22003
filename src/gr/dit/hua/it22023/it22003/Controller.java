package gr.dit.hua.it22023.it22003;

import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Models.IncorrectArgumentException;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronElderTraveller;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronMiddleTraveller;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronYoungTraveller;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        program_initialization();
    
        //noinspection InfiniteLoopStatement
        while (true)
        {
            Perceptron Traveler = assign_age_group(read_age());
            
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
    
    public static void program_initialization() throws IOException
    {
        try
        {
            Utils.readJSON();
            System.out.println("JSON read successfully");
        } catch (FileNotFoundException e)
        {
            async_dummy_data();
            System.out.println("JSON read failed");
        }
      
    }
    
    public static void async_dummy_data()
    {
        Thread[] threads = {
                        createThread("Athens" , "gr") ,
                        createThread("Rome" , "it") ,
                        createThread("California" , "us") ,
                        createThread("Sydney" , "au") ,
                        createThread("Paris" , "fr") ,
                        createThread("London" , "uk") ,
                        createThread("Bangkok" , "th") ,
                        createThread("Beijing" , "cn") ,
                        createThread("Dubai" , "uae") ,
                        createThread("Tokyo" , "jp") ,
                        createThread("Corfu" , "gr") };
        
        for (Thread thread : threads)
        {
            thread.start();
        }
        Utils.threads = new ArrayList<>(List.of(threads));
    }
    
    @SuppressWarnings("unused")
    public static void sync_dummy_data() throws IOException
    {
        
        City.create_city("Athens" , "gr");
        City.create_city("Rome" , "it");
        City.create_city("California" , "us");
        City.create_city("Sydney" , "au");
        City.create_city("Paris" , "fr");
        City.create_city("London" , "uk");
        City.create_city("Bangkok" , "th");
        City.create_city("Beijing" , "cn");
        City.create_city("Dubai" , "uae");
        City.create_city("Tokyo" , "jp");
        City.create_city("Corfu" , "gr");
        
    }
    
    
    public static Thread createThread(String city , String country)
    {
        return new Thread(() -> {
            
            try
            {
                City.create_city(city , country);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            
        });
        
    }
    
    public static int read_age()
    {
        int age = - 1;
        System.out.println("Hello");
        do
        {
            try
            {
                System.out.println("Please insert your age");
                System.out.println("(Enter \"0\" if you want to EXIT the program.)");
                System.out.print("Age : ");
                
                if (! Utils.scan.hasNextInt())
                {
                    throw new IncorrectArgumentException();
                }
            } catch (IncorrectArgumentException e)
            {
                Utils.scan.next();
                continue;
            }
            age = Utils.scan.nextInt();
            System.out.println();
            if (age == 0)
            {
                try
                {
                    Utils.writeJSON();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                
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
