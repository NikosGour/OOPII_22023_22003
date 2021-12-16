package gr.dit.hua.it22023.it22003.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import gr.dit.hua.it22023.it22003.Models.OpenData.OpenData;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.io.IOException;
import java.util.Date;

public class City
{
    
    //region Fields
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("timeStamp")
    private Date timeStamp;
    /**
     * Marking System for Weights : Y = Young , M = Middle , E = Elder <br><hr>
     * index 0: Cafe                (Y M)<br>
     * index 1: Sea                 (Y M E)<br>
     * index 2: Museum              (M E)<br>
     * index 3: Restaurant          (Y M E)<br>
     * index 4: Stadium             (Y M)<br>
     * index 5: Landmarks           (Y M E)<br>
     * index 6: Hotels              (M E)<br>
     * index 7: Temperature         (M E)<br>
     * index 8: Cloudiness          (Y M)<br>
     * index 9: Geodesic Distance   (M E)<br>
     */
    @JsonProperty("features")
    double[] features = new double[10];
    
    /**
     * Marking System for Weights : Y = Young , M = Middle , E = Elder <br><hr>
     * index 0: Cafe                (Y M)<br>
     * index 1: Sea                 (Y M E)<br>
     * index 2: Museum              (M E)<br>
     * index 3: Restaurant          (Y M E)<br>
     * index 4: Stadium             (Y M)<br>
     * index 5: Landmarks           (Y M E)<br>
     * index 6: Hotels              (M E)<br>
     * index 7: Temperature         (M E)<br>
     * index 8: Cloudiness          (Y M)<br>
     * index 9: Geodesic Distance   (M E)<br>
     */
    @JsonProperty("normalized_features")
    private double[] normalized_features = new double[10];
    
    //endregion
    
    //region Constants
    private static final double MIN_TERM = 0;
    private static final double MAX_TERM = 10;
    
    private static final double MIN_TEMPERATURE = 184;
    private static final double MAX_TEMPERATURE = 331;
    
    private static final double TRAVEL_AGENCY_LAT = 37.9838;
    private static final double TRAVEL_AGENCY_LON = 23.7275;
    
    private static final double MAX_DISTANCE = 15325.599430089682;
    //endregion
    
    //region Constructors
    public City()
        {}
    public City(String cityName , double[] features , double latitude , double longitude , Date timeStamp)
    {
        
        
        this.cityName  = cityName;
        this.timeStamp = timeStamp;
        if (features.length == 9)
        {
            for (int i = 0; i < 7; i++)
            {
                this.features[i] = features[i] > 10 ? 10 : features[i];
            }
            this.features[7] = features[7];
            this.features[8] = features[8];
            
            this.features[9] = Utils.distance(TRAVEL_AGENCY_LAT , TRAVEL_AGENCY_LON , latitude , longitude);
        }
        this.normalize_features();
        
        Utils.cities.add(this);
    }
    //endregion
    
    //region Getter & Setters
    
    
    public String getCityName()
    {
        return cityName;
    }
    
    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }
    
    public Date getTimeStamp()
    {
        return timeStamp;
    }
    
    public void setTimeStamp(Date timeStamp)
    {
        this.timeStamp = timeStamp;
    }
    
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
    
    //region Methods
    
    /**
     * calls the api to create a city object
     * @param city City name for api
     * @param country Country abbreviation for api
     * @throws IOException if city doesn't exist
     */
    public static City create_city(String city , String country) throws IOException
    {
        if (!check_if_city_exists(city))
        {
        return OpenData.RetrieveData(city , country , Utils.APPID);
        
        }
        return null;
    }
    
    
    /**
     * Normalization of all the features
     */
    private void normalize_features()
    {
        for (int i = 0; i < 7; i++)
        {
            normalized_features[i] = (this.features[i] - MIN_TERM) / (MAX_TERM - MIN_TERM);
        }
        
        normalized_features[7] = (this.features[7] - MIN_TEMPERATURE) / (MAX_TEMPERATURE - MIN_TEMPERATURE);
        
        normalized_features[8] = this.features[8] / 100;
        
        normalized_features[9] = this.features[9] / MAX_DISTANCE;
    }
    
    
    /**
     * If the city already exists in the arraylist, do not proceed with OpenData.RetrieveData(...) .
     * @param cityName the city name to check
     * @return true if city already exist , otherwise false
     */
   
    public static boolean check_if_city_exists(String cityName)
    {
        for (City city : Utils.cities)
        {
            if ((city.getCityName()).equals(cityName))
            {
                System.out.println(city.getTimeStamp());
                return true;
            }
        }
        return false;
    }
    //endregion
    
}
