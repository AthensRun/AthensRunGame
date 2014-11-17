/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Game 
{
    private Parser parser;
    private ParserWithFileInput parserWithFileInput;
    private Room currentRoom;
    int numberOfDrinks = 0;
    private People currentP1;
    private People currentP2;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        parserWithFileInput = new ParserWithFileInput();
    }

    /**
     * Creating the intersections and streets.
     */
    private void createRooms()
    {
        Room broadE, broadW, intersectionSW, intersectionNW, intersectionN, intersectionC, intersectionNE, intersectionSE, intersectionE, intersectionW, lumpkinS, lumpkinN, collegeS, 
        collegeN, claytonE, claytonW, washingtonW, washingtonE, jacksonN, jacksonS, theArch;

        
        //creating the intersections
        intersectionN = new Room("Intersection between East & West Washingtoon St. and North College Ave.");
        intersectionW = new Room("Intersection between North & South Lumpkin St. and West Clayton St.");
        intersectionE = new Room("Intersection between North & South Jackson St. and East Clayton St.");
        intersectionC = new Room("Intersection between East & West Clayton St. and North and South College Ave.");

        intersectionSW = new Room("Intersection between West Broad St. & South Lumpkin St.");
        intersectionNW = new Room("Intersection between West Washington St. & North Lumpkin St.");
        intersectionNE = new Room("Intersection between East Wahington St. & North Jackson St.");
        intersectionSE = new Room("Intersection between East Broad St. & South Jackson St.");

        // creating the streets
        theArch = new Room("the Arch. Your journey has begun!");
        broadE = new Room("East Broad St.");
        broadW = new Room("West Broad St.");

        lumpkinS = new Room("South Lumpkin St.");
        lumpkinN = new Room("North Lumpkin St.");
        collegeS = new Room("South College Ave.");
        collegeN = new Room("North College Ave.");
        claytonE = new Room("East Clayton St.");
        claytonW = new Room("West Clayton St.");
        washingtonE = new Room("East Washington St.");
        washingtonW = new Room("West Washington St.");
        jacksonN = new Room("North Jackson St.");
        jacksonS = new Room("South Jackson St.");

        // initialize intersection exits
        
        
        intersectionC.setExit("west", claytonW);
        intersectionC.setExit("north", collegeN);
        intersectionC.setExit("south", collegeS);
        intersectionC.setExit("east", claytonE);

        intersectionN.setExit("east", washingtonE);
        intersectionN.setExit("south", collegeN);
        intersectionN.setExit("west", washingtonW);

        intersectionW.setExit("east", claytonW);
        intersectionW.setExit("north", lumpkinN);
        intersectionW.setExit("south", lumpkinS);

        intersectionE.setExit("west", claytonE);
        intersectionE.setExit("north", jacksonN);
        intersectionE.setExit("south", jacksonS);

        intersectionNE.setExit("west", washingtonE);
        intersectionNE.setExit("south", jacksonN);

        intersectionNW.setExit("east", washingtonW);
        intersectionNW.setExit("south", lumpkinN);

        intersectionSW.setExit("north", lumpkinS);
        intersectionSW.setExit("east", broadW);

        intersectionSE.setExit("north", jacksonS);
        intersectionSE.setExit("west", broadE);

        // initialise street exits
        claytonW.setExit("east", intersectionC);
        claytonW.setExit("west", intersectionW);
        
        claytonE.setExit("west", intersectionC);
        claytonE.setExit("east", intersectionE);
        
        theArch.setExit("west", broadW);
        theArch.setExit("east", broadE);
        theArch.setExit("north", collegeS);

        broadW.setExit("west", intersectionSW);
        broadW.setExit("east", theArch);

        broadE.setExit("east", intersectionSE);
        broadE.setExit("west", theArch);

        collegeS.setExit("north", intersectionC);
        collegeS.setExit("south", theArch);

        collegeN.setExit("north", intersectionN);
        collegeN.setExit("south", intersectionC);

        lumpkinS.setExit("south", intersectionSE);
        lumpkinS.setExit("north", intersectionW);

        lumpkinN.setExit("south", intersectionW);
        lumpkinN.setExit("north", intersectionNW);

        jacksonS.setExit("south", intersectionSE);
        jacksonS.setExit("north", intersectionE);

        jacksonN.setExit("south", intersectionE);
        jacksonN.setExit("north", intersectionNE);

        washingtonW.setExit("east", intersectionN);
        washingtonW.setExit("west", intersectionNW);

        washingtonE.setExit("west", intersectionN);
        washingtonE.setExit("east", intersectionSE);

        currentRoom = theArch;  // start game theArch
    }
    
    public void drinkAtStarbucks(Command command)
    {
        starbucks water, coffee;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "coffee"))
            {
              System.out.println("coffee on a Saturday night? you must be tired!")  ;
            }
            
        if(commandWord.equals("drink")&&(command.isUnknown()) )
            {
            System.out.println("This drink is not available at starbucks");
            }
    }
    
    public void drinkAtTacoStand(Command command)
    {
      
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink")&&(command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink")&&(command.secondWord == "taquilla"))
            {
              System.out.println("a few of these and your night is not going to end well")  ;
            }
            
        if (commandWord.equals("drink")&&(command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink")&&(command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            }    
            
        if(commandWord.equals("drink")&&(command.isUnknown()) )
            {
            System.out.println("This drink is not available at TacoStand");
            }
    }
    
    public void drinkAtBoarsHead(Command command)
    {
        
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink")&&(command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink")&&(command.secondWord == "vodka"))
            {
              System.out.println("the drink of champions!!!")  ;
            }
            
        if (commandWord.equals("drink")&&(command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink")&&(command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            }    
            
        if(commandWord.equals("drink")&&(command.isUnknown()) )
            {
            System.out.println("This drink is not available at BoarsHead");
            }
    }
    
    public void drinkAtCutters(Command command)
    {
        cutters water, surpriseMe, liquor, beer;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "surpriseMe"))
            {
              System.out.println("a few of these and your night is not going to end well")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            }    
            
        if(commandWord.equals("drink") && (command.isUnknown()) )
            {
            System.out.println("This drink is not available at Cutters");
            }
    }
    
    public void drinkAtWonderBar(Command command)
    {
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "jack"))
            {
              System.out.println("for the expensive video gamers")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            }    
            
        if(commandWord.equals("drink") && (command.isUnknown())) 
            {
            System.out.println("This drink is not available at WonderBar");
            }
    }
    
    public void drinkAtTheBury(Command command)
    {
        bury water, taquilla, liquor, beer, vodka, surpriseMe;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "taquilla"))
            {
              System.out.println("a few of these and your night is not going to end well")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
            
        if (commandWord.equals("drink") && (command.secondWord == "vodka"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
            
        if (commandWord.equals("drink") && (command.secondWord == "surpriseMe"))
            {
              System.out.println("you just tasted the color purple")  ;
            }    
            
        if(commandWord.equals("drink") && (command.isUnknown()) )
            {
            System.out.println("This drink is not available at the Bury");
            }
    }
    
    public void drinkAtFiveGuys(Command command)
    {
        fiveguys water, soda;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
        
        if (commandWord.equals("drink") && (command.secondWord == "soda"))
            {
              System.out.println("this is a nice change of pace for a saturday night")  ;
            }
            
        if(commandWord.equals("drink") && (command.isUnknown()) )
            {
            System.out.println("This drink is not available at Five Guys");
            }
    }
    
    public void drinkAtBarBurritos(Command command)
    {
        barburritos water, beer, soda;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
                        
        if (commandWord.equals("drink") && (command.secondWord == "soda"))
            {
              System.out.println("this is a nice change of pace for a Saturday night")  ;
            }    
            
        if (commandWord.equals("drink") && (command.isUnknown()) )
            {
            System.out.println("This drink is not available at the Barburittos");
            }
    }
    
    public void drinkAtMagnolias(Command command)
    {
        magnolias water, taquilla, liquor, beer, vodka;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "taquilla"))
            {
              System.out.println("a few of these and your night is not going to end well")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
            
        if (commandWord.equals("drink") && (command.secondWord == "vodka"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
                        
        if(commandWord.equals("drink") && (command.isUnknown())) 
            {
            System.out.println("This drink is not available at the Fuzzies");
            }
    }
    
    public void drinkAtFuzzies(Command command)
    {
        fuzzies water, taquilla, liquor, beer, vodka, surpriseMe;
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();       
        if (commandWord.equals("drink") && (command.secondWord == "water"))
            {
              System.out.println("you are sobering up!")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "taquilla"))
            {
              System.out.println("a few of these and your night is not going to end well")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "liquor"))
            {
              System.out.println("take it easy friend, you have a long night ahead of you")  ;
            }
            
        if (commandWord.equals("drink") && (command.secondWord == "beer"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
            
        if (commandWord.equals("drink") && (command.secondWord == "vodka"))
            {
              System.out.println("When money is tight go natty-lite")  ;
            } 
            
        if (commandWord.equals("drink") && (command.secondWord == "surpriseMe"))
            {
              System.out.println("you just tasted the color purple")  ;
            }    
            
        if(commandWord.equals("drink") && (command.isUnknown()) )
            {
            System.out.println("This drink is not available at the Fuzzies");
            }
    }

    public void createPeople()
    {
        People theEx;

        theEx = new People("your worst nightmare");
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    public void playWithFileInput() 
    {            
        printWelcome();
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parserWithFileInput.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Zuul Athens!");
        System.out.println("Here in Zuul Athens people like to enjoy themselves by going downtown at night.");
        System.out.println("It would seem that most of these nights are fuled by alcohol.");
        System.out.println("Though they try as hard as they can, the police can not catch every under aged drinker.");
        System.out.println("Being the freshman that you are, you also enjoy the nightlife here in Zuul Athens."); 
        System.out.println("Probably a bit too much");
        System.out.println("Although you are not 21, you have been issued a fake ID from... well.. you have your 'resources'.");
        System.out.println("For a night go be successful, everyone knows that you must wander in and out");
        System.out.println("of bars, meet vaious people, and find your way back home safely.");
        System.out.println("Your goal is to have a successful night by finding your way around Zuul Athens to find");
        System.out.println("friends and items that will help you get on the shuttle back at the arch by 3:00 AM");
        System.out.println();
        System.out.println("Can you survive a night of fun in Zuul Athens without getting arrested?");
        System.out.println("Will you be able to find your way back without getting sick along the way?");
        System.out.println("Who knows!?! but either way it will be a night to remember... or not... ");
        System.out.println("Either way, good luck!!!");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        int numberOfDrinks = 0;

        if(command.isUnknown()) {
            System.out.println("Not a valid command.");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            //wantToLook = look(command);
            goLook(command);
        }
        else if(commandWord.equals("see"))
        {
            System.out.println("Type 'help' if you need help.");
        }
        else if (commandWord.equals("drink")) {
            numberOfDrinks++;
            System.out.println("You drank a beer.");
            if (numberOfDrinks == 4)
            {

                System.out.println("You're starting to get dizzy.");

            }
        }
        else if(commandWord.equals("east"))
        {
            System.out.println("You need to specify movement. Type 'go' to move in your intended direction.");
        }

        else if(commandWord.equals("west"))
        {
            System.out.println("You need to specify movement. Type 'go' to move in your intended direction.");
        }

        else if(commandWord.equals("north"))
        {
            System.out.println("You need to specify movement. Type 'go' to move in your intended direction.");
        }
        else if(commandWord.equals("south"))
        {
            System.out.println("You need to specify movement. Type 'go' to move in your intended direction.");
        }
        else if(commandWord.equals("left"))
        {
            System.out.println("You need to specify movement. Type 'walk' to move in bars.");
        }
        else if(commandWord.equals("right"))
        {
            System.out.println("You need to specify movement. Type 'walk' to move in bars.");
        }
        else if(commandWord.equals("out"))
        {
            System.out.println("You need to specify movement. Type 'walk' to move in bars.");
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    
    
    public int getDrinks()
    {
        return numberOfDrinks;
    }

    
    
    public void goLook(Command command)
    {
       String commandWord = command.getCommandWord();
       String secondWord = command.getSecondWord();
        
        if(commandWord.equals("look"))
        {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Look where?");
            return;
        }
        else
        {
          String direction = command.getSecondWord();
          return;
        }
        
       }
    }

    
    
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("If you are on the street press");
        System.out.println("'go' followed by one of the words 'north', 'south', 'east', or 'west'");
        System.out.println(" An example would be 'go north'");
        System.out.println();
        System.out.println("If you are in a bar press");
        System.out.println("'look' followed by one of the words 'left', 'right', 'up', or 'down' ");
        System.out.println(" An example would be 'look right'");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

  
    private void goEnter(Command command)
    {
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord();
        if(commandWord.equals("enter"))
        {
            if(!command.hasSecondWord())
            {
                   System.out.println("Enter where?");
            return;
            }
          else if (secondWord.equals("starbucks"))
          {
            
              
              
            }
            
            
            
        }
        
        
        
    }
    
     

}
