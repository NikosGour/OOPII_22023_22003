package gr.dit.hua.it22023.it22003.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.dit.hua.it22023.it22003.Models.City;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class Utils
{
    
    public static final Scanner scan = new Scanner(System.in);
    public static  ArrayList<Thread> threads = new ArrayList<>();
    public static  ArrayList<City> cities = new ArrayList<>();
    public static final ObjectMapper JSON_mapper = new ObjectMapper();
    public static final String[] criteria =
            { "cafe" , "sea" , "museum" , "restaurant" , "stadium" , "landmark" , "hotel" };
    
    public static final String APPID = "217d0917e9cae78fdb32d8e85bfa0e4b";
    
    
    public static void writeJSON() throws IOException
    {
        JSON_mapper.writeValue(new File("cities.json") , Utils.cities);
    }
    
    public static void readJSON() throws IOException
    {
        List<City> temp_list = Arrays.asList(JSON_mapper.readValue(new File("cities.json") , City[].class));
        Utils.cities = new ArrayList<>(temp_list);
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
}
