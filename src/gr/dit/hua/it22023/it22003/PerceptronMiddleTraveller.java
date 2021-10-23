package gr.dit.hua.it22023.it22003;

import java.util.ArrayList;

public class PerceptronMiddleTraveller extends Perceptron {

      PerceptronMiddleTraveller() {
            super();
      }
      
      public static void setWeights()
      {
            weights[0] = 0.4;    // Cafe
            weights[1] = 0.4;    // Sea
            weights[2] = 0.4;    // Museum
            weights[3] = 0.6;    // Restaurant
            weights[4] = 0.4;    // Stadium
            weights[5] = 0.8;    // Landmarks
            weights[6] = 0.4;    // Hotels
            weights[7] = 0.2;    // Temperature
            weights[8] = - 0.2;  // Cloudiness
            weights[9] = 0.8;    // Geodesic Distance
//            weightBias = ;
      }
}
