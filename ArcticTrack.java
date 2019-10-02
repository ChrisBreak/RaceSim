/*  Author: Cristhian Sotelo
    UCID: 30004060
    CPSC 219, T05, WINTER 2017
    Version: March 26, 2017
 
    Racing Simulator, this class is a child of class Track,
    it has the extra feature of a blizzard happening on the track
    with a 10% chance. */




import java.util.Random;

public class ArcticTrack extends Track
{
    private boolean blizzard = false;

    
    public ArcticTrack()
    {
        super();
        setWeather();
    }
    
    public boolean getBlizzard()
    {
        return(blizzard);
    }
    
    public void setBlizzard(boolean state)
    {
        blizzard = state;
    }
    
    public void setWeather()
    {
        Random generator = new Random();
        int probs;
        probs = generator.nextInt(100);
        if ((probs >= 0) && (probs < 10))
            blizzard = true;
        
        else
            blizzard = false;
    }
}
