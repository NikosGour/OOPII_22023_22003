package gr.dit.hua.it22023.it22003;

import java.util.ArrayList;

public class PerceptronElderTraveller extends Perceptron {

      PerceptronElderTraveller() {
            super();
      }

       public static void setWeights()
      {
            
            weights[0] = 0.4;      // Cafe
            weights[1] = 0.4;      // Sea
            weights[2] = 1;        // Museum
            weights[3] = 0.4;      // Restaurant
            weights[4] = - 0.2;    // Stadium
            weights[5] = 1;        // Landmarks
            weights[6] = 0.8;      // Hotels
            weights[7] = 0.8;      // Temperature
            weights[8] = 0.2;      // Cloudiness
            weights[9] = 0.6;      // Geodesic Distance
//            weightBias = ;
      }
}
