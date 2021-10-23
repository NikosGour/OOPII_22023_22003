package gr.dit.hua.it22023.it22003;

public abstract class Perceptron implements PerceptronTraveller {
      protected double[] inputs;
      protected static double[] weights;
      protected static double weightBias;
      
      Perceptron(double[] inputs){
            this.inputs = inputs;
      }
      
      public static void setWeights()
      {
      
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
