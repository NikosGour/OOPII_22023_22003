package gr.dit.hua.it22023.it22003;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.dit.hua.it22023.it22003.Models.*;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.*;
import gr.dit.hua.it22023.it22003.Utils.*;

import javax.swing.plaf.IconUIResource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controler
{
    public static void main(String[] args) throws IOException
    {
//        program_initialization();
        
        //         for (City city : Utils.cities)
        //        {
        //            System.out.printf("%s , %s\n" , city.getCityName() , Arrays.toString(city.getFeatures()));
        //        }
    
    
        ObjectMapper mapper = new ObjectMapper();
    
        Utils.cities = new ArrayList<City>( Arrays.asList(mapper.readValue(new File("cities.json") , City[].class)));
        
//        mapper.writeValue(new File("cities.json") , Utils.cities);
        while (true)
        {
            Perceptron Traveler = assign_age_group(read_age());
            Traveler.recommend();
            Traveler.getRecommended_cities().forEach(x -> System.out.println(x));
            
            System.out.println();
            
            
        }
    }
    
    public static void program_initialization() throws IOException
    {
        sync_dummy_data();
    }
    
    public static void async_dummy_data() throws IOException
    {
        Thread[] threads ={
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
        Utils.sort_cities_by_distance();
    }
    
    
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
        
        Utils.sort_cities_by_distance();
    }
    
    
    public static Thread createThread(String city , String country)
    {
        Thread rv = new Thread(() -> {
            
            try
            {
                City.create_city(city , country);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            
        });
        
        return rv;
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
