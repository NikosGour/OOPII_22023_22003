package gr.dit.hua.it22023.it22003.Models.Perceptrons;

import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.util.*;

public abstract class Perceptron implements PerceptronTraveller
{
    //region Fields
    protected double[] inputs = new double[10];
    protected static double[] weights = new double[10];
    private ArrayList<City> recommended_cities;
    protected static double weightBias;
    //endregion
    
    //region Constructors
    Perceptron()
    {
    
    }
    //endregion
    
    //region Methods
    /**
     * @return  The closest city in the recommended list of the given perceptron , returns null if recommend list is empty
     */
    @SuppressWarnings("unused")
    public static String closest_recommended(Perceptron perceptron)
    {
        if (perceptron.recommended_cities.size() == 0) return null;
        for (City city : Utils.cities)
        {
            if (perceptron.getRecommended_cities().indexOf(city.getCityName()) != -1)
            {
                return city.getCityName();
            }
        }
        
        
        return null;
    }
    
    public abstract void sortRecommendations();
    
    
    /**
     *  Recommends the cities based on the perceptron type
     * @return arraylist of recommended cities
     */
    @Override
    public ArrayList<String> recommend()
    {
        
        HashMap<City, Double> hashMap = new HashMap<>();
        
        for (City city : Utils.cities)
        {
            inputs = city.getNormalized_features().clone();
            double city_ranking = summation();
            if (activation(city_ranking))
            {
                hashMap.put(city , city_ranking);
            }
        }
        
        //Map the hashmap into a list of entries
        ArrayList<Map.Entry<City, Double>> sorting_list = new ArrayList<>(hashMap.entrySet());
        
        //Sort the list based on value
        sorting_list.sort(Map.Entry.comparingByValue());
        
        //Reverse the list, so most favorable location is on first index
        Collections.reverse(sorting_list);
        
//        sorting_list.forEach(x -> System.out.println(x));
        
        //Map locations to return_value list
        ArrayList<City> recommended_cities = new ArrayList<>();
        sorting_list.forEach(x -> recommended_cities.add(x.getKey()));
        this.recommended_cities = recommended_cities;
        
        ArrayList<String> return_value = new ArrayList<>();
        recommended_cities.forEach(x -> return_value.add(x.getCityName()));
        
        return return_value;
    }
    
    private double summation()
    {
        double sum = 0;
        for (int i = 0; i < 10; i++)
        {
            sum += this.inputs[i] * weights[i];
        }
        sum += weightBias;
        return sum;
    }
    
    /**
     * Recommends a cities based on perceptron type
     * @param isUpper a param to set the names to upper or not
     * @return same as recommend
     */
    @SuppressWarnings("unused")
    public ArrayList<String> recommend(boolean isUpper)
    {
        ArrayList<String> return_value = this.recommend();
        if (isUpper)
        {
            for (int i = 0; i < return_value.size(); i++)
            {
                return_value.set(i , return_value.get(i).toUpperCase());
            }
        }
        else
        {
            for (int i = 0; i < return_value.size(); i++)
            {
                return_value.set(i , return_value.get(i).toLowerCase());
            }
        }
        return return_value;
        
    }
    
    private boolean activation(double input)
    {
        return input > 1.5;
    }
    //endregion
    
    //region Getters & Setters
    
    public ArrayList<City> getRecommended_cities()
    {
        return recommended_cities;
    }
    
    //endregion
}
