package gr.dit.hua.it22023.it22003.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.dit.hua.it22023.it22003.Exceptions.IncorrectArgumentException;
import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.Perceptron;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronElderTraveller;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronMiddleTraveller;
import gr.dit.hua.it22023.it22003.Models.Perceptrons.PerceptronYoungTraveller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A static class that contains miscellaneous methods and variables
 */
public final class Utils
{
    //region Constants
    public static ArrayList<Thread> threads = new ArrayList<>();
    public static HashMap<String, ArrayList<String>> cities_by_day = new HashMap<>();
    public static ArrayList<City> cities = new ArrayList<>();
    public static final Scanner scan = new Scanner(System.in);
    public static final ObjectMapper JSON_mapper = new ObjectMapper();
    public static final String[] criteria =
            { "cafe" , "sea" , "museum" , "restaurant" , "stadium" , "landmark" , "hotel" };
    public static final String APPID = "217d0917e9cae78fdb32d8e85bfa0e4b";
    public static Logger logger;
    //endregion
    
    //region JSON
    /**
     * Writes the cities arraylist into json.
     * @throws IOException if file missing
     */
    public static void writeJSON() throws IOException
    {
        JSON_mapper.writeValue(new File("cities.json") , cities);
    }
    
    /**
     * Reads the json file to initialize the cities arraylist
     * @throws IOException if file missing
     */
    public static void readJSON() throws IOException
    {
        City[] city_arr = JSON_mapper.readValue(new File("cities.json") , City[].class);
        List<City> temp_list = Arrays.asList(city_arr);
        cities = new ArrayList<>(temp_list);
    }
    //endregion
    
    //region Program Initialization
    
    
    /**
     *  Sets the cities arraylist for perceptron city picking + initializes the cities_by_day HashMap
     */
    public static void program_initialization() throws IOException {
        initialize_Logger();
        initialize_weekdays();

        Utils.logger.log(Level.INFO, "Program Initialization.");
        
        try
        {
            readJSON();
            System.out.println("JSON read successfully");
        } catch (IOException e)
        {
            async_dummy_data();
            System.out.println("JSON read failed");
        }
        
    }
    
    /**
     * Initializes all the cities asynchronously
     */
    public static void async_dummy_data()
    {
        Thread[] threads =
                { createThread("Athens" , "src/gr") , createThread("Rome" , "it") , createThread("California" , "us") , createThread("Sydney" , "au") , createThread("Paris" , "fr") , createThread("London" , "uk") , createThread("Bangkok" , "th") , createThread("Beijing" , "cn") , createThread("Dubai" , "uae") , createThread("Tokyo" , "jp") , createThread("Corfu" , "src/gr") };
        
        for (Thread thread : threads)
        {
            thread.start();
        }
        Utils.threads = new ArrayList<>(List.of(threads));
    }
    
    /**
     * Initializes all the cities synchronously
     * @throws IOException if city doesn't exist
     */
    @SuppressWarnings("unused")
    public static void sync_dummy_data() throws IOException
    {
        
        City.create_city("Athens" , "src/gr");
        City.create_city("Rome" , "it");
        City.create_city("California" , "us");
        City.create_city("Sydney" , "au");
        City.create_city("Paris" , "fr");
        City.create_city("London" , "uk");
        City.create_city("Bangkok" , "th");
        City.create_city("Beijing" , "cn");
        City.create_city("Dubai" , "uae");
        City.create_city("Tokyo" , "jp");
        City.create_city("Corfu" , "src/gr");
        
    }
    //endregion
    
    //region Perceptron Initialization
  
    
    public static Perceptron assign_age_group(int age) throws IncorrectArgumentException
    {
        
        Perceptron Traveler;
        
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
        else throw new IncorrectArgumentException();
        
        return Traveler;
    }
    
    //endregion
    
    //region Miscellaneous methods
    /**
     * Functions that must wait for all the threads to die for them to execute correctly
     */
    public static void after_threads_died_routine()
    {
        Utils.sort_cities_by_distance();
        //Utils.setCities_by_day();
    }
    
    /**
     * Initialize the cities_by_day HashMap
     */
    private static void initialize_weekdays()
    {
        cities_by_day.put("Monday" , new ArrayList<>());
        cities_by_day.put("Tuesday" , new ArrayList<>());
        cities_by_day.put("Wednesday" , new ArrayList<>());
        cities_by_day.put("Thursday" , new ArrayList<>());
        cities_by_day.put("Friday" , new ArrayList<>());
        cities_by_day.put("Saturday" , new ArrayList<>());
        cities_by_day.put("Sunday" , new ArrayList<>());
    }
    
    /**
     * Maps the cities into cities_by_day HashMap
     */
    private static void setCities_by_day()
    {
        var simpleDateformat = new SimpleDateFormat("EEEE");
        for (City city : cities)
        {
            String day = simpleDateformat.format(city.getTimeStamp());
            Utils.cities_by_day.get(day).add(city.getCityName());
        }
    }
    
    /**
     * Creates a thread of the city constructor for the thread array
     * @param city City name for api
     * @param country Country abbreviation for api
     * @return a Thread for the thread array
     */
    private static Thread createThread(String city , String country)
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
    
    public static void threadSafety() throws InterruptedException
    {
        for (Thread thread : Utils.threads)
            {
                if (thread.isAlive())
                {
                    Thread.sleep(500);
                }
            }

    }
    
    /**
     * Sorts cities by distance
     */
    public static void sort_cities_by_distance()
    {
        Utils.cities.sort(Comparator.comparingDouble(o -> o.getFeatures()[9]));
        
    }
    
    /**
     * Calculates the distance between two cities
     * @param lat1 Latitude of the city 1
     * @param lon1 Longitude of the city 1
     * @param lat2 Latitude of the city 2
     * @param lon2 Longitude of the city 2
     * @return the distance
     */
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


    public static void initialize_Logger() throws IOException {
        String file_name = "log.txt";

        File file = new File(file_name);

        //noinspection ResultOfMethodCallIgnored
        file.createNewFile();

        FileHandler fh = new FileHandler(file_name, true);

        logger = Logger.getLogger(Utils.class.getName());
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
    
    //endregion
}
