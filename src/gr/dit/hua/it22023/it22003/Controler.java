package gr.dit.hua.it22023.it22003;

public class Controler
{
    public static void main(String[] args)
    {
        program_initialization();
        while (true) {
            Perceptron Traveler = assign_age_group(read_age());
            Traveler.recommend();
        }
    }
    
    public static void program_initialization()
    {
        dummy_data();
    }
    
    public static void dummy_data()
    {
        City athens = new City("Athens",new double[]{ 5 , 10 , 10 , 6 , 10 , 6 , 2 , 288.93 , 40 } , 37.9795 , 23.7162);
        City rome = new City("Rome",new double[]{ 0 , 39 , 14 , 2 , 5 , 0 , 0 , 295.76 , 20 } , 41.8947 , 12.4839);
        City new_york = new City("New York",new double[]{2 , 52 , 29 , 7 , 12, 12 ,5, 290.37 , 1}, 40.7143 , -74.006);
        City sydney = new City("Sydney",new double[]{0, 33, 30 , 1 , 5, 5 ,2 ,289.36 , 0} , -33.8679 , 151.2073);
    }
    
    public static int read_age()
    {
        int age;
        System.out.println("Hello");
        do
        {
            System.out.println("Please insert your age");
            System.out.println("(Enter \"0\" if you want to EXIT the program.)");
            System.out.print("Age : ");
            
            while (! Utils.scan.hasNextInt())
            {
                System.out.println();
                System.out.println("Please enter a NUMBER.");
                System.out.print("Insert your age again : ");
                Utils.scan.next();
            }
            
            age = Utils.scan.nextInt();
            System.out.println();
            if (age == 0)
            {
                System.out.println("Thank you for using the <<Travel-Advisor>> app!");
                System.exit(0);
            }
            
        } while ((age < 16) || (age > 115));
        
        return age;
    }
    
    public static Perceptron assign_age_group(int age) {
        Perceptron Traveler = null;

        if (age >= 16 && age < 25) {
            PerceptronYoungTraveller.set_weights();
            Traveler = new PerceptronYoungTraveller();
        } else if (age >= 25 && age < 60) {
            PerceptronMiddleTraveller.set_weights();
            Traveler = new PerceptronMiddleTraveller();
        } else if (age >= 60 && age < 115) {
            PerceptronElderTraveller.set_weights();
            Traveler = new PerceptronElderTraveller();
        }

        return Traveler;
    }
}
