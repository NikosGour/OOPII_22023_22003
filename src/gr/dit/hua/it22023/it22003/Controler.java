package gr.dit.hua.it22023.it22003;

public class Controler
{
    public static void main(String[] args)
    {
        dummy_data();
    }
    
    public static void dummy_data()
    {
        City athens = new City(new double[]{ 5 , 10 , 10 , 6 , 10 , 6 , 2 , 288.93 , 40 } , 37.9795 , 23.7162);
        City rome = new City(new double[]{ 0 , 39 , 14 , 2 , 5 , 0 , 0 , 295.76 , 20 } , 41.8947 , 12.4839);
        City new_york = new City(new double[]{2 , 52 , 29 , 7 , 12, 12 ,5, 290.37 , 1}, 40.7143 , -74.006);
        City sydney = new City(new double[]{0, 33, 30 , 1 , 5, 5 ,2 ,289.36 , 0} , -33.8679 , 151.2073);
    }
}
