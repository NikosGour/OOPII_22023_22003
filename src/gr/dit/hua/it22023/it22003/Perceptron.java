package gr.dit.hua.it22023.it22003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Perceptron implements PerceptronTraveller {
      protected double[] inputs = new double[10];
      protected static double[] weights = new double[10];
      protected static double weightBias;
      
      Perceptron(){
      
      }
      
      
      @Override
      public ArrayList<String> recommend()
      {
        
            HashMap<String , Double> sortingHashmap = new HashMap<String, Double>();
            
            for (City city: Utils.cities)
            {
                  inputs = city.getNormalized_features().clone();
                  System.out.printf("%f , %s\n" , summation(), city.getCityName());
                  
            }
            System.out.println();
            return null;
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
