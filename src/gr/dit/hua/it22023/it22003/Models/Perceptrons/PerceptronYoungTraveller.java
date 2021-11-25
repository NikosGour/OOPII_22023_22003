package gr.dit.hua.it22023.it22003.Models.Perceptrons;

import gr.dit.hua.it22023.it22003.Models.City;

import java.util.ArrayList;
import java.util.Comparator;

public class PerceptronYoungTraveller extends Perceptron
{
    
    //region Constructors
    public PerceptronYoungTraveller()
    {
        super();
    }

    @Override
    public ArrayList<String> sortRecommendations() {
        this.getRecommended_cities().sort(new Comparator<>() {
            @Override
            public int compare(City o1, City o2) {
                var x = o1.getFeatures()[9];
                var y = o2.getFeatures()[9];

                return Double.compare(x, y);
            }
        });
        return null;
    }
    //endregion
    
    //region Methods
    @Override
    public ArrayList<String> recommend()
    {
        set_weights();
        super.recommend();
        sortRecommendations();

        ArrayList<String> return_value = new ArrayList<>();
        this.getRecommended_cities().forEach(x -> return_value.add(x.getCityName()));

        return return_value;
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
    //endregion
}
