/*  Author: Cristhian Sotelo
    UCID: 30004060
    CPSC 219, T05, WINTER 2017
    Version: March 26, 2017
 
    Racing Simulator, this class is a child of class Car,
    it has its own starting values for an SUV, and an extra
    feature mode for all wheel drive. */


public class SUV extends Car
{
    public static final int STARTING_FUEL = 50;
    public static final int CONSUMPTION_RATE = 3;
    public static final int AWD_DISTANCE = 1;
    public static final char SUV_LOOK = 'V';
    private char mode;
    
    public SUV()
    {
        setAppearance(SUV_LOOK);
        fuel = STARTING_FUEL;
    }
    
    public char getMode()
    {
        return(mode);
    }
    
    public void setMode(char aMode)
    {
        mode = aMode;
    }
    
    public int move() //This method overrides the parent move() method as the starting values are different.
    {
        consumeFuel(CONSUMPTION_RATE);
        System.out.println("Current fuel: " + fuel);
        System.out.println("Fuel use: " + CONSUMPTION_RATE);
        
        if (mode == 'a')
        {
            System.out.println("Distance traveled: " + AWD_DISTANCE);
            return(AWD_DISTANCE);
        }
        
        else
        {
            System.out.println("Distance traveled: " + STANDARD_DISTANCE);
            return(STANDARD_DISTANCE);
        }
    }
    public int move(boolean trackBlizzard) //Overloaded method that takes into account track weather.
    {
        consumeFuel(CONSUMPTION_RATE);
        System.out.println("Current fuel: " + fuel);
        System.out.println("Fuel use: " + CONSUMPTION_RATE);
        
        if (trackBlizzard)
        {
            if (mode == 'a')
            {
                System.out.println("Distance traveled: " + AWD_DISTANCE);
                return(AWD_DISTANCE);
            }
            else
            {
                System.out.println("Distance traveled: 0");
                return(0);
            }
        }
        else
        {
            if (mode == 'a')
            {
                System.out.println("Distance traveled: " + AWD_DISTANCE);
                return(AWD_DISTANCE);
            }
            
            else
            {
                System.out.println("Distance traveled: " + STANDARD_DISTANCE);
                return(STANDARD_DISTANCE);
            }
        }
    }
}
