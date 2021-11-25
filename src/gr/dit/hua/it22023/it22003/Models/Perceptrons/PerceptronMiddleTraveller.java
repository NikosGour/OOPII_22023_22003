package gr.dit.hua.it22023.it22003.Models.Perceptrons;

import gr.dit.hua.it22023.it22003.Models.City;

import java.util.ArrayList;
import java.util.Comparator;

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
    public void sortRecommendations() {
        this.getRecommended_cities().sort(new Comparator<>() {
            @Override
            public int compare(City o1, City o2) {
                var x = o1.getTimeStamp();
                var y = o2.getTimeStamp();

                return x.compareTo(y);
            }
        });
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
