package gr.dit.hua.it22023.it22003.Utils;

import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Models.OpenData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public final class Utils {
      
      public static final Scanner scan = new Scanner(System.in);
      
      public static final ArrayList<City> cities = new ArrayList<City>();
      public static final String APPID = "217d0917e9cae78fdb32d8e85bfa0e4b";
      
      public static City RetrieveData(String city, String country) throws IOException
      {
            return OpenData.RetrieveData(city , country ,APPID);
      }
      
 
      
      public static void sort_cities_by_distance()
      {
            Collections.sort(Utils.cities , new Comparator<City>()
            {
                  @Override
                  public int compare(City o1 , City o2)
                  {
                        return Double.compare(o1.getFeatures()[9],o2.getFeatures()[9]);
                  }
            });
            
      }
      
      public static double distance(double lat1, double lon1, double lat2, double lon2) {
            final double KILOMETER_MULT = 1.609344;
            if ((lat1 == lat2) && (lon1 == lon2)) {
                  return 0;
            }
            else {
                  double theta = lon1 - lon2;
                  double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
                  dist = Math.acos(dist);
                  dist = Math.toDegrees(dist);
                  dist = dist * 60 * 1.1515 * KILOMETER_MULT;
                  return (dist);
            }
      }
}
