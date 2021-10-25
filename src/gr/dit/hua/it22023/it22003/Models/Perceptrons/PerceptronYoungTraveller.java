package gr.dit.hua.it22023.it22003.Models.Perceptrons;

import java.util.ArrayList;

public class PerceptronYoungTraveller extends Perceptron
{
    
    
    public PerceptronYoungTraveller()
    {
        super();
    }
    
    @Override
    public ArrayList<String> recommend()
    {
        set_weights();
        return super.recommend();
    }
    
    
    private static void set_weights()
    {
        weights    = new double[10];
        weights[0] = 0.6;      // Cafe
        weights[1] = 0.4;      // Sea
        weights[2] = 0.2;      // Museum
        weights[3] = 0.6;      // Restaurant
        weights[4] = 0.8;      // Stadium
        weights[5] = 0.6;      // Landmarks
        weights[6] = 0;        // Hotels
        weights[7] = - 0.4;    // Temperature
        weights[8] = - 0.8;    // Cloudiness
        weights[9] = - 0.6;    // Geodesic Distance
        weightBias = 1;
    }
}
