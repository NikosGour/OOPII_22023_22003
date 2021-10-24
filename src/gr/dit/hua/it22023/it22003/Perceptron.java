package gr.dit.hua.it22023.it22003;

import java.util.*;

public abstract class Perceptron implements PerceptronTraveller {
      protected double[] inputs = new double[10];
      protected static double[] weights = new double[10];
      protected static double weightBias;
      
      Perceptron(){
      
      }
    
    
    @Override
    public ArrayList<String> recommend()
    {
        
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        
        for (City city : Utils.cities)
        {
            inputs = city.getNormalized_features().clone();
            hashMap.put(city.getCityName() , summation());
            
        }
        
        //Map the hashmap into a list of entries
        ArrayList<Map.Entry<String,Double>> sorting_list = new ArrayList<>(hashMap.entrySet());
        
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
        
        //Map locations to return_value list
        ArrayList<String> return_value = new ArrayList<>();
        sorting_list.forEach(x -> return_value.add(x.getKey()));
        
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
      
      private boolean activation(double input)
      {
            return input > 10;
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
      
      //endregion
}
