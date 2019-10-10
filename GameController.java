/*  Author: Cristhian Sotelo
    UCID: 30004060
    CPSC 219, T05, WINTER 2017
    Version: March 26, 2017

    Racing Simulator, this class contains code that controls the flow
    of the game, makes the decisions according to user input,
    features displayed when program is started. */


import java.util.Scanner;

public class GameController
{
    private Track theArctic = new Track();
    private Track theDesert = new Track();
    private SUV suvCar = new SUV();
    private int suvLocation = 0;
    private Sports sportsCar = new Sports();
    private int sportsLocation = 0;
    private char selection;
    private String cheatSelection;
    private MyFrame raceFrame = new MyFrame();
    private MyPane racePane = new MyPane();
    private InfoPrinter infoPrint = new InfoPrinter();



    /* Main execution code, SUV and Sports menus called, and
     possible outcomes for the simulation*/

    public GameController()
    {
        initialize();

        raceFrame.add(racePane);
        raceFrame.setVisible(true);

        do {
            showTracks();

            if (suvCar.getFuel() > 0)
                suvMenu();

            if (selection != 'q')

                if (sportsCar.getFuel() > 0)
                    sportsMenu();

            if (Debug.on)
            {
                System.out.println("\nCar menus executed, outcome to be chosen.");
                System.out.println("SUV location: " + suvLocation + "\tFuel: " + suvCar.getFuel());
                System.out.println("SPorts location: " + sportsLocation + "\tFuel: " + sportsCar.getFuel());
            }

            checkPossibleOutcome();

            if (Debug.on)
                System.out.println("Selection is 'q' if one outcome chosen: " + selection);

        } while (selection != 'q');

        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException ex)
        {
            System.out.println("Pause interrupted.");
        }

        raceFrame.setVisible(false);
        raceFrame.dispose();
    }



    /* Initializing method with a description of the game.
     Cars are put in the 0 positions, and weather conditions executed. */

    private void initialize()
    {
        infoPrint.printInstructions();

        theArctic.setLocation(suvCar, suvLocation);
        theArctic.createWeather();
        theDesert.setLocation(sportsCar, sportsLocation);
        theDesert.createWeather();

        if (Debug.on)
        {
            System.out.print("Blizzard: " + theArctic.getWeatherCondition());
            System.out.println("\tHeat Wave: " + theDesert.getWeatherCondition());
        }
    }



    /* method to display tracks and their names. */

    private void showTracks()
    {
        System.out.println("\nARCTIC TRACK");
        theArctic.display();
        System.out.println("DESERT TRACK");
        theDesert.display();
    }



    /*SUV method, displays options and calls user input method,
     then executes an option accordingly. */

    private void suvMenu()
    {
        infoPrint.printSUVMenu();
        setSelection();

        if ((selection == 'a') || (selection == 'd'))
        {
            suvCar.setMode(selection);
            theArctic.setLocation(null, suvLocation); //Previous location of SUV set to null.

            racePane.setBlizzard(theArctic.getWeatherCondition());

            if (theArctic.getWeatherCondition())
                System.out.println("A blizzard has hit the Arctic track.");

            //New location of SUV calculated according to user input and condition of the track.
            suvLocation = suvLocation + suvCar.move(theArctic.getWeatherCondition());

            if (suvLocation > (Track.SIZE - 1))
            {
                suvLocation = Track.SIZE - 1;

                if (Debug.on)
                    System.out.println("Array index out of bounds, index set to " + suvLocation);
            }

            theArctic.setLocation(suvCar, suvLocation); //SUV put in the new location.
            racePane.moveSUV(suvLocation);
            theArctic.createWeather(); //Track weather set for next turn.

            if (Debug.on)
                System.out.println("Blizzard for next turn: " + theArctic.getWeatherCondition());

            if (suvCar.isEmpty())
                System.out.println("The SUV car is out of fuel, and can't move.");
        }

        else if (selection == 'c')
        {
            infoPrint.printCheatMenu();
            setCheatSelection();

            if (cheatSelection.equals("5")) //Condition to prevent SUV from sabotaging its own track.
            {
                theArctic.createWeather();

                if (Debug.on)
                    System.out.println("Sabotage tried.  Random blizzard: " + theArctic.getWeatherCondition());
            }
        }

    }



    /*Sports car method, displays options and calls user input method,
     then executes an option accordingly.  Same structure as SUV menu method. */

    private void sportsMenu()
    {
        infoPrint.printSportsMenu();

        /* Since the user input method is the same for both cars, this loop
         prevents the AWD to be chosen for the Sports car. */
        do {
            setSelection();
            if (selection == 'a')
            System.out.println("This option is not available for the Sports car.");
        } while(selection == 'a');


        if (selection == 'd')
        {
            theDesert.setLocation(null, sportsLocation);

            racePane.setHeat(theDesert.getWeatherCondition());

            if (theDesert.getWeatherCondition())
                System.out.println("A heat wave has hit the Desert track.");

            sportsLocation = sportsLocation + sportsCar.move(theDesert.getWeatherCondition());

            if (sportsLocation > (Track.SIZE - 1))
            {
                sportsLocation = Track.SIZE - 1;

                if (Debug.on)
                    System.out.println("Array index out of bounds, index set to " + sportsLocation);
            }

            theDesert.setLocation(sportsCar, sportsLocation);
            racePane.moveSports(sportsLocation);
            theDesert.createWeather();

            if (Debug.on)
                System.out.println("Heat for next turn: " + theDesert.getWeatherCondition());

            if (sportsCar.isEmpty())
                System.out.println("The Sports car is out of fuel, and can't move.");
        }

        else if (selection == 'c')
        {
            infoPrint.printCheatMenu();
            setCheatSelection();

            if (cheatSelection.equals("6"))
            {
                theDesert.createWeather();

                if (Debug.on)
                    System.out.println("Sabotage tried.  Random heat: " + theDesert.getWeatherCondition());
            }
        }

    }


    //User input method, if none of the options is chosen, input is asked again.
    private void setSelection()
    {
        Scanner in = new Scanner(System.in);
        String aSelect;

        do {
            System.out.print("Enter selection: ");
            aSelect = in.nextLine();
            switch (aSelect)
            {
                case "a":
                case "A":
                case "c":
                case "C":
                case "d":
                case "D":
                case "q":
                case "Q":
                    aSelect = aSelect.toLowerCase();
                    selection = aSelect.charAt(0);
                    break;
                default:
                    aSelect = "Invalid input.";
                    System.out.println(aSelect);
            }
        } while (aSelect == "Invalid input.");

        if (selection == 'q')
            System.out.println("Quitting the game before the race is over...");
    }


    //User method input for cheat menu, separate methods called for the options.
    private void setCheatSelection()
    {
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter selection: ");
            cheatSelection = in.nextLine();

            switch (cheatSelection)
            {
                case "0":
                    caseDebug();
                    break;

                case "1":
                case "2":
                    caseChangeFuel();
                    break;

                case "3":
                case "4":
                    caseChangeLocation();
                    break;

                case "5":
                case "6":
                    caseChangeWeather();
                    break;

                case "q":
                case "Q":
                    System.out.println("Quitting the game before the race is over...");
                    selection = 'q';
                    break;

                default:
                    cheatSelection = "Invalid input.";
                    System.out.println(cheatSelection);
            }

        } while (cheatSelection == "Invalid input.");
    }


    //Method to toggle Debug mode.
    private void caseDebug()
    {
        if (Debug.on == false)
        {
            Debug.on = true;
            System.out.println("Debugging mode ON.");
        }

        else
        {
            Debug.on = false;
            System.out.println("Debugging mode OFF.");
        }
    }


    //Method to change fuel for either car.
    private void caseChangeFuel()
    {
        Scanner in = new Scanner(System.in);
        int amount = 0;

        if (cheatSelection.equals("1"))
        {
            do {
                    System.out.print("Enter new fuel for Sports car (0-30): ");
                    amount = in.nextInt();
            } while ((amount < 0) || (amount > Sports.STARTING_FUEL));

            sportsCar.setFuel(amount);

            if (amount == 0)
                System.out.println("The Sports car is out of fuel, and can't move.");
        }

        else if (cheatSelection.equals("2"))
        {
            do {
                    System.out.print("Enter new fuel for SUV car (0-50): ");
                    amount = in.nextInt();
            } while ((amount < 0) || (amount > SUV.STARTING_FUEL));

            suvCar.setFuel(amount);

            if (amount == 0)
                System.out.println("The SUV car is out of fuel, and can't move.");
        }
    }


    //Method to change location for either car on their respective track.
    private void caseChangeLocation()
    {
        Scanner in = new Scanner(System.in);
        int newLocation;

        if (cheatSelection.equals("3"))
        {
            theDesert.setLocation(null, sportsLocation);

            do {
                System.out.print("Enter new location of Sports car (0-24): ");
                newLocation = in.nextInt();
            } while ((newLocation < 0) || (newLocation > (Track.SIZE - 1)));

            theDesert.setLocation(sportsCar, newLocation);
            sportsLocation = newLocation;
            racePane.moveSports(newLocation);
        }

        else if (cheatSelection.equals("4"))
        {
            theArctic.setLocation(null, suvLocation);

            do {
                System.out.print("Enter new location of SUV car (0-24): ");
                newLocation = in.nextInt();
            }while ((newLocation < 0) || (newLocation > (Track.SIZE - 1)));

            theArctic.setLocation(suvCar, newLocation);
            suvLocation = newLocation;
            racePane.moveSUV(newLocation);
        }
    }


    //Method to change weather conditions for either track.
    private void caseChangeWeather()
    {
        if (cheatSelection.equals("5"))
        {
            System.out.println("Creating a blizzard on the Arctic track...");
            theArctic.setWeatherCondition(true);
        }

        else if (cheatSelection.equals("6"))
        {
            System.out.println("Creating a heat wave on the Desert track...");
            theDesert.setWeatherCondition(true);
        }
    }

    private void checkPossibleOutcome() {
      //Both cars location at the end space, or user chose to quit early.
      if ((theArctic.isWon()) && (theDesert.isWon()) || (selection == 'q'))
      {
          System.out.println("The race is a draw.");
          showTracks();
          selection = 'q';
          racePane.setRaceTie(true);
      }

      //SUV at the end first.
      else if (theArctic.isWon())
      {
          System.out.println("The SUV car has won the race.");
          showTracks();
          selection = 'q';
          racePane.setSUVWin(true);
      }

      //Sports car at the end first.
      else if (theDesert.isWon())
      {
          System.out.println("The Sports car has won the race.");
          showTracks();
          selection = 'q';
          racePane.setSportsWin(true);
      }

      //Both cars out of fuel before the end.
      else if ((suvCar.getFuel() == 0) && (sportsCar.getFuel() == 0))
      {
          System.out.println("Both cars ran out of fuel, the race is a draw.");
          showTracks();
          selection = 'q';
          racePane.setRaceTie(true);
      }
    }
}
