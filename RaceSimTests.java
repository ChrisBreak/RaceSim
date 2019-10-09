//RaceSimTests
//To compile after all other classes have been compiled already
//use:  javac -cp .:hamcrest-all-1.3.jar:junit-4.13-beta-1.jar RaceSimTests.java
//To run use:  java -cp .:hamcrest-all-1.3.jar:junit-4.13-beta-1.jar org.junit.runner.JUnitCore RaceSimTests


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RaceSimTests {

  private Track simpleTrack = new Track();
  private ArcticTrack arcticTrack = new ArcticTrack();
  private DesertTrack desertTrack = new DesertTrack();
  private Car aCar = new Car();
  private SUV suv = new SUV();
  private Sports sportsCar = new Sports();

  @Test
  public void testIsWonWithSetLocation() {
    simpleTrack.setLocation(aCar, Track.SIZE - 1);
    arcticTrack.setLocation(aCar, Track.SIZE - 1);
    desertTrack.setLocation(aCar, Track.SIZE - 1);
    assertTrue("\ntestIsWonWithSetLocation() for Track.", simpleTrack.isWon());
    assertTrue("\ntestIsWonWithSetLocation() for ArcticTrack.", arcticTrack.isWon());
    assertTrue("\ntestIsWonWithSetLocation() for DesertTrack.", desertTrack.isWon());
  }

  @Test
  public void testGetFuelWithConsumeFuel() {
    aCar.consumeFuel(5);
    suv.consumeFuel(5);
    sportsCar.consumeFuel(5);
    assertEquals("\ntestGetFuelWithConsumeFuel() for Car, consumed 5", 35, aCar.getFuel());
    assertEquals("\ntestGetFuelWithConsumeFuel() for SUV, consumed 5", 45, suv.getFuel());
    assertEquals("\ntestGetFuelWithConsumeFuel() for Sports, consumed 5", 25, sportsCar.getFuel());
  }

  @Test
  public void testCarMove() {
    assertEquals("\ntestCarMove() for Car, standard distance of 2", 2, aCar.move());
  }

  @Test
  public void testSUVMove() {
    suv.setMode('a'); //set to all wheel drive
    assertEquals("\ntestCarMove() for SUV, AWD distance of 1", 1, suv.move());
    suv.setMode('d'); //set to normal drive
    assertEquals("\ntestCarMove() for SUV, with blizzard distance of 0", 0, suv.move(true));
  }

  @Test
  public void testSportsMove() {
    assertEquals("\ntestCarMove() for Sports, Sports distance of 3", 3, sportsCar.move());
    int currentFuel = sportsCar.getFuel();
    sportsCar.move(true);
    assertEquals("\ntestCarMove() for Sports, with heat consumption", (currentFuel - Sports.HEAT_CONSUMPTION), sportsCar.getFuel());
  }

  @Test
  public void testEmptyFuelTank() {
    aCar.consumeFuel(50);
    suv.consumeFuel(50);
    sportsCar.consumeFuel(50);
    assertTrue("\ntestEmptyFuelTank() for Car.", aCar.isEmpty());
    assertTrue("\ntestEmptyFuelTank() for SUV.", suv.isEmpty());
    assertTrue("\ntestEmptyFuelTank() for Sports.", sportsCar.isEmpty());
  }


  public static void main( String[] args ) {
      Result result = JUnitCore.runClasses( RaceSimTests.class );
      for (Failure failure : result.getFailures()) {
          System.out.println(failure.toString());
      }
  }

}
