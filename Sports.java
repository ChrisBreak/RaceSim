/*  Author: Cristhian Sotelo
    UCID: 30004060
    CPSC 219, T05, WINTER 2017
    Version: March 26, 2017
 
    Racing Simulator, this class is a child of class Car,
    it has its own starting values for a Sports car. */


public class Sports extends Car
{
    public static final int STARTING_FUEL = 30;
    public static final int HEAT_CONSUMPTION = CONSUMPTION_RATE * 2;
    public static final int SPORTS_DISTANCE = 3;
    public static final char SPORTS_LOOK = 'P';
    
    public Sports()
    {
        setAppearance(SPORTS_LOOK);
        fuel = STARTING_FUEL;
    }
    
    public int move() //This method overrides the parent move() method as the starting values are different.
    {
        consumeFuel(CONSUMPTION_RATE);
        System.out.println("Current fuel: " + fuel);
        System.out.println("Fuel use: " + CONSUMPTION_RATE);
        System.out.println("Distance traveled: " + SPORTS_DISTANCE);
        return(SPORTS_DISTANCE);
    }
    
    public int move(boolean trackHeat) //Overloaded method that takes into account track weather.
    {
        if (trackHeat)
        {
            consumeFuel(HEAT_CONSUMPTION);
            System.out.println("Current fuel: " + fuel);
            System.out.println("Fuel use: " + HEAT_CONSUMPTION);
        }
        
        else
        {
            consumeFuel(CONSUMPTION_RATE);
            System.out.println("Current fuel: " + fuel);
            System.out.println("Fuel use: " + CONSUMPTION_RATE);
        }
        
        System.out.println("Distance traveled: " + SPORTS_DISTANCE);
        return(SPORTS_DISTANCE);
    }
}
