/*  Author: Cristhian Sotelo
 UCID: 30004060
 CPSC 219, T05, WINTER 2017
 Version: March 26, 2017

 Racing Simulator, this class is a child of class Track,
 it has the extra feature of a heat wave happening on the track
 with a 10% chance. */


public class DesertTrack extends Track {

    public DesertTrack() {
        super();
        setWeather();
    }

    public boolean getHeatWave() {
        return(weatherCondition);
    }

    public void setHeatWave(boolean state) {
        weatherCondition = state;
    }

}
