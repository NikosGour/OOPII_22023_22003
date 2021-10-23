package gr.dit.hua.it22023.it22003;

import java.util.ArrayList;

public final class Utils {
      
      public static final ArrayList<City> cities = new ArrayList<City>();
      
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
