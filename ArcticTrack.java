/*  Author: Cristhian Sotelo
    UCID: 30004060
    CPSC 219, T05, WINTER 2017
    Version: March 26, 2017

    Racing Simulator, this class is a child of class Track,
    it has the extra feature of a blizzard happening on the track
    with a 10% chance. */


public class ArcticTrack extends Track {

    public ArcticTrack() {
        super();
        setWeather();
    }

    public boolean getBlizzard() {
        return(weatherCondition);
    }

    public void setBlizzard(boolean state) {
        weatherCondition = state;
    }

}
