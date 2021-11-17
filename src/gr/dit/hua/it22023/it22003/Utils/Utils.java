package gr.dit.hua.it22023.it22003.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Exceptions.IncorrectArgumentException;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronElderTraveller;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronMiddleTraveller;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronYoungTraveller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class Utils
{
    //region Constants
    public static  ArrayList<Thread> threads = new ArrayList<>();
    public static  ArrayList<City> cities = new ArrayList<>();
    public static final Scanner scan = new Scanner(System.in);
    public static final ObjectMapper JSON_mapper = new ObjectMapper();
    public static final String[] criteria = { "cafe" , "sea" , "museum" , "restaurant" , "stadium" , "landmark" , "hotel" };
    public static final String APPID = "217d0917e9cae78fdb32d8e85bfa0e4b";
    //endregion
    
    //region JSON
    public static void writeJSON() throws IOException
    {
        JSON_mapper.writeValue(new File("cities.json") , cities);
    }
    
    public static void readJSON() throws IOException
    {
        List<City> temp_list = Arrays.asList(JSON_mapper.readValue(new File("cities.json") , City[].class));
        cities = new ArrayList<>(temp_list);
    }
    //endregion
    
    //region Program Initialization
    public static void program_initialization() throws IOException
    {
        try
        {
            readJSON();
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
    //endregion
    
    //region Perceptron Initialization
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
                
                if (! scan.hasNextInt())
                {
                    throw new IncorrectArgumentException();
                }
            } catch (IncorrectArgumentException e)
            {
                scan.next();
                continue;
            }
            age = scan.nextInt();
            System.out.println();
            if (age == 0)
            {
                try
                {
                    writeJSON();
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
    
    public static Perceptron assign_age_group()
    {
        int age = read_age();
        
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
    
    //endregion
    
    //region Miscellaneous methods
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
    
    public static void sort_cities_by_distance()
    {
        Utils.cities.sort(Comparator.comparingDouble(o -> o.getFeatures()[9]));
        
    }
    
    public static double distance(double lat1 , double lon1 , double lat2 , double lon2)
    {
        final double KILOMETER_MULT = 1.609344;
        if ((lat1 == lat2) && (lon1 == lon2))
        {
            return 0;
        } else
        {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
                          Math.cos(Math.toRadians(lat1)) *
                          Math.cos(Math.toRadians(lat2)) *
                          Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515 * KILOMETER_MULT;
            return (dist);
        }
    }
    
    //endregion
}
