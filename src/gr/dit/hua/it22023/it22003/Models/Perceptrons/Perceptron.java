package gr.dit.hua.it22023.it22003.Models.Perceptrons;

import gr.dit.hua.it22023.it22003.Models.City;
import gr.dit.hua.it22023.it22003.Utils.Utils;

import java.util.*;

public abstract class Perceptron implements PerceptronTraveller
{
    protected double[] inputs = new double[10];
    protected static double[] weights = new double[10];
    private ArrayList<String> recommended_cities;
    protected static double weightBias;
    
    Perceptron()
    {
    
    }
    
    
    /**
     * @return  The closest city in the recomment list of the given perceptron , returns null if recommend list is empty
     */
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
    
    @Override
    public ArrayList<String> recommend()
    {
        
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        
        for (City city : Utils.cities)
        {
            inputs = city.getNormalized_features().clone();
            double city_ranking = summation();
            if (activation(city_ranking))
            {
                hashMap.put(city.getCityName() , city_ranking);
            }
        }
        
        //Map the hashmap into a list of entries
        ArrayList<Map.Entry<String, Double>> sorting_list = new ArrayList<>(hashMap.entrySet());
        
        //Sort the list based on value
        Collections.sort(sorting_list , new Comparator<Map.Entry<String, Double>>()
        {
            @Override
            public int compare(Map.Entry<String, Double> o1 , Map.Entry<String, Double> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        
        //Reverse the list, so most favorable location is on first index
        Collections.reverse(sorting_list);
        
//        sorting_list.forEach(x -> System.out.println(x));
        
        //Map locations to return_value list
        ArrayList<String> return_value = new ArrayList<>();
        sorting_list.forEach(x -> return_value.add(x.getKey()));
        
        
        this.recommended_cities = return_value;
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
    
    //region Getters & Setters
    
    public double[] getInputs()
    {
        return inputs;
    }
    
    public void setInputs(double[] inputs)
    {
        this.inputs = inputs;
    }
    
    public static double[] getWeights()
    {
        return weights;
    }
    
    public static void setWeights(double[] weights)
    {
        Perceptron.weights = weights;
    }
    
    public static double getWeightBias()
    {
        return weightBias;
    }
    
    public static void setWeightBias(double weightBias)
    {
        Perceptron.weightBias = weightBias;
    }
    
    public ArrayList<String> getRecommended_cities()
    {
        return recommended_cities;
    }
    
    public void setRecommended_cities(ArrayList<String> recommended_cities)
    {
        this.recommended_cities = recommended_cities;
    }
    
    //endregion
}
