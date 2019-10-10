

public class InfoPrinter {

  public void printInstructions() {

    System.out.println("\nRacing Game Simulator.\n" +
      "There are two tracks displayed, an Arctic track, and a Desert track,\n" +
      "each with a car.  The cars take turns to move along the tracks.\n" +
      "Whichever car reaches the end first wins the race, if both cars reach\n" +
      "the end on the same turn, run out of fuel, or the simulation is ended\n" +
      "before the race is over, the race is a draw.\n\n" +
      "The Arctic track contains an SUV car that has two driving modes,\n" +
      "normal, and AWD (all wheel drive).  There's a 10% chance that a blizzard\n" +
      "could hit the Arctic track. If the SUV is on AWD mode it will move one\n" +
      "space even through the blizzard, but on normal mode it will be stuck on\n" +
      "the same space and use the same amount of fuel.\n\n" +
      "The Desert track contains a Sports car that only has one driving mode,\n" +
      "but can move a longer distance than the SUV.  There's a 10% chance of a\n" +
      "heat wave hitting the Desert track, if this happens, the Sport car will\n" +
      "use double the amount of fuel, but move the same distance.\n\n" +
      "There's a cheat menu (enter 'c') with options available to manipulate the\n" +
      "conditions of the race.  However, the SUV turn can't be used to create a\n" +
      "blizzard on the Arctic track, and similarly the Sports car turn can't be\n" +
      "used to create a heat wave on the Desert trak.  Using the cheat menu will\n" +
      "use up the car's turn to move.\n\n" +
      "Let the race begin!!!\n");
  }

  public void printSUVMenu() {

    System.out.println("\nSUV driving options: \n" +
      "(a)ll wheel drive mode.\n" +
      "(d)rive normally.\n" +
      "(q)uit game.");
  }

  public void printSportsMenu() {

    System.out.println("\nSports car driving options: \n" +
      "(d)rive normally.\n" +
      "(q)uit game.\n");
  }

  public void printCheatMenu() {

    System.out.println("\nCHEAT MENU OPTIONS\n" +
      "(0) Toggle debugging mode on/off.\n" +
      "(1) Change fuel of sports car.\n" +
      "(2) Change fuel of SUV car.\n" +
      "(3) Change location of sports car.\n" +
      "(4) Change location of SUV car.\n" +
      "(5) Create a blizzard in the arctic track.\n" +
      "(6) Create a heat wave in the desert track.\n");
  }

}
