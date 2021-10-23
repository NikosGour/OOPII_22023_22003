package gr.dit.hua.it22023.it22003;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Perceptron implements PerceptronTraveller {
      protected double[] inputs = new double[10];
      protected static double[] weights = new double[10];
      protected static double weightBias;
      
      Perceptron(){
      
      }
      
      public static void setWeights()
      {
      
      }
      
      
      @Override
      public ArrayList<String> recommend()
      {
//            TODO : Add the capability of setting weights dynamically based on the object's class
//            if (this instanceof Perceptron)
//            {
//                  this.getClass().
//            }
            for (City city: Utils.cities)
            {
                  inputs = city.getNormalized_features().clone();
                  System.out.printf("%f , %s\n" , summation(), city.getCityName());
            }
            
            return null;
      }
      
      protected double summation()
      {
            double sum = 0;
            for (int i = 0; i < 10; i++)
            {
                  sum += this.inputs[i] * weights[i];
            }
            sum += weightBias;
            return sum;
      }
      
      protected boolean activation(double input)
      {
            return input > 10;
      }
      
}
