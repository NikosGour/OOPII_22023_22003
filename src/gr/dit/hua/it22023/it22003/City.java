package gr.dit.hua.it22023.it22003;
import gr.dit.hua.it22023.it22003.Utils;

public class City
{

    /**
     *      Marking System for Weights : Y = Young , M = Middle , E = Elder <br><hr>
     *      index 0: Cafe                (Y M)<br>
     *      index 1: Sea                 (Y M E)<br>
     *      index 2: Museum              (M E)<br>
     *      index 3: Restaurant          (Y M E)<br>
     *      index 4: Stadium             (Y M)<br>
     *      index 5: Landmarks           (Y M E)<br>
     *      index 6: Hotels              (M E)<br>
     *      index 7: Temperature         (M E)<br>
     *      index 8: Cloudiness          (Y M)<br>
     *      index 9: Geodesic Distance   (M E)<br>
     */
    private double[] features = new double[10];
    
    //region Constants
    private static final double MIN_TERM = 0;
    private static final double MAX_TERM = 10;
    
    private static final double MIN_TEMPERATURE = 184;
    private static final double MAX_TEMPERATURE = 331;
    
    private static final double TRAVEL_AGENCY_LAT = 37.9838;
    private static final double TRAVEL_AGENCY_LON = 23.7275;

    private static final int MAX_DISTANCE = 15317;
    //endregion
    
    
    private double latitude;
    private double longitude;
    
    
    /**
     * Same as <strong>features array</strong> but with normalized values
     */
    private double[] normalized_features = new double[10];


    //region Getter & Setters
    public double[] getFeatures()
    {
        return features;
    }
    
    public void setFeatures(double[] features)
    {
        this.features = features;
    }
    
    public double[] getNormalized_features()
    {
        return normalized_features;
    }
    
    public void setNormalized_features(double[] normalized_features)
    {
        this.normalized_features = normalized_features;
    }
    //endregion


    private void normalize_features() {
          for (int i = 0; i < 7; i++) {
                normalized_features[i] = (this.features[i] - MIN_TERM) / (MAX_TERM - MIN_TERM);
          }

          normalized_features[7] = (this.features[7] - MIN_TEMPERATURE) / (MAX_TEMPERATURE - MIN_TEMPERATURE);

          normalized_features[8] = this.features[8]/100;

          normalized_features[9] = (Utils.distance(TRAVEL_AGENCY_LAT, TRAVEL_AGENCY_LON, this.latitude, this.longitude) / MAX_DISTANCE);
    }
}
