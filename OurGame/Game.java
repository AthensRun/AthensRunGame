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
    public Room currentRoom;
    private Item items;
    
    int numberOfDrinks = 0;
    private Room broadE, broadW, intersectionSW, intersectionNW, intersectionN, intersectionC, intersectionNE, intersectionSE, intersectionE, intersectionW, lumpkinS, lumpkinN, collegeS, 
    collegeN, claytonE, claytonW, washingtonW, washingtonE, jacksonN, jacksonS, theArch, starbucks;
    
    private BarBathroom starbucksB;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        createItems();
        parser = new Parser();
        parserWithFileInput = new ParserWithFileInput();

    }

    /**
     * Creating the intersections and streets.
     */
    private void createRooms()
    {
        //         Room broadE, broadW, intersectionSW, intersectionNW, intersectionN, intersectionC, intersectionNE, intersectionSE, intersectionE, intersectionW, lumpkinS, lumpkinN, collegeS, 
        //         collegeN, claytonE, claytonW, washingtonW, washingtonE, jacksonN, jacksonS, theArch, starbucks;

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
        theArch = new Room("at the Arch. Your journey has begun!");
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
        
        // Creating Bars and their bathrooms

        starbucks = new Room("in Starbucks. Do you even party? why are you here on a saturday night?");
        starbucksB = new BarBathroom("in the Starbucks bathroom. Looks like coffee makes you go!"); 

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
        broadE.setExit("starbucks", starbucks);

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

        //initialize bar exits

        starbucks.setExit("outside", broadE);
        starbucks.setExit("bathroom",starbucksB);
        starbucksB.setExit("out",starbucks);
        

        currentRoom = theArch;  // start game at theArch
    }

    /**
     * 
     * creating People
     *
     */
    public void createPeople()
    {

        Person theEX = new theEX("Hell hath no fury like a woman scorned.");
    }

    /**
     * 
     * creating Items
     * 
     */
    public void createItems()

    {
        Item tequilla = new Beverage("Alcoholic Tonic");
        Item water = new Beverage("water");
        Item coffee = new Beverage("coffee");
        Item beer = new Beverage("beer");
        
        
        
        starbucks.setItem(1,water);
        starbucks.setItem(2,coffee);
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
        String secondWord = command.getSecondWord();    

        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } 
        else if(commandWord.equals("see"))
        {
            System.out.println("Type 'help' if you need help.");
        }
        else if(commandWord.equals("enter")) {
            currentRoom.enter(command);
            enterRoom(command);
        }
        else if(commandWord.equals("drink"))
        {
            drinkItem(command);
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
        else if(commandWord.equals("outside"))
        {
            System.out.println("You need to specify movement. Type 'go' to move in your intended direction.");
        }
        // else command not recognised.
        return wantToQuit;
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
    private boolean goRoom(Command command) 
    {
        boolean wantToGo = false;
        if(!command.hasSecondWord() && command.isSecondUnknown()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        

        String secondWord = command.getSecondWord();
        // Try to leave current room.
        if(secondWord.equals("east"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        if(secondWord.equals("west"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        if(secondWord.equals("north"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        if(secondWord.equals("south"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        if(secondWord.equals("outside"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
         if(secondWord.equals("out"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
        }
        return wantToGo;
    }

    public boolean enterRoom(Command command)
    {
        boolean wantToEnter = false;
         if (command.isSecondUnknown())
        {
             System.out.println("Enter what?");
            return false;
        }
       
        String secondWord = command.getSecondWord();
        if (command.isSecondUnknown())
        {
             System.out.println("Enter what?");
            return false;
        }
        

        if(!command.hasSecondWord())
        {
            System.out.println("Enter what?");
        }
        
        if (secondWord.equals("starbucks"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);
            if (nextRoom == null) {
                System.out.println("There is no Starbucks here!");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                currentRoom.changeDesc("You are in Starbucks.");
            }

        }
//         if (secondWord.equals("bathroom"))
//         {
//             Room nextRoom = currentRoom.getExit(secondWord);
//             if (nextRoom == null) {
//                 System.out.println("There is no bathroom here!");
//             }
//             else {
//                 currentRoom = nextRoom;
//                 System.out.println(currentRoom.getLongDescription());
//                 
//             }
// 
//         }
   
        
        return wantToEnter;
    }
   

    public void drinkItem(Command command)
    {
        String secondWord = command.getSecondWord();

        if(!command.hasSecondWord())
        {
            System.out.println("Drink what?");
            return;
        }
        if (secondWord.equals("coffee"))
        {
            Item items1 = currentRoom.getItem(1);
             Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You drank " +secondWord+".");

            }

        }
        else if (secondWord.equals("beer"))
        {
            Item items1 = currentRoom.getItem(1);
             Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You drank " +secondWord+".");
                numberOfDrinks++;
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages");
            }

        }
        if(numberOfDrinks == 4)
        {
          System.out.println("Getting a little dizzy");
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

}
