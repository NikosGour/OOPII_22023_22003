package gr.dit.hua.it22023.it22003.Models.Perceptrons;

import java.util.ArrayList;

public class PerceptronMiddleTraveller extends Perceptron
{
    //region Constructors
    public PerceptronMiddleTraveller()
    {
        super();
    }
    //endregion
    
    //region Methods
       @Override
    public void sortRecommendations()
    {
    }
    
    @Override
    public ArrayList<String> recommend()
    {
        set_weights();
        return super.recommend();
    }
    
    private static void set_weights()
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
        weightBias = -0.4;
    }
    //endregion
}
