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
    private Room stolenRoom;
    private Item items;

    int stolenCash = 0;
    int numberOfDrinks = 0;
    int fakeID = 0;
    int drinksWithRM = 0;
    int cops = 0;
    int evades = 0;
    int keysWallet =0;

    private Person fakeIDGuy, roommate;

    private Room broadE, broadW, intersectionSW, intersectionNW, intersectionN, intersectionC, intersectionNE, intersectionSE, intersectionE, intersectionW, lumpkinS, lumpkinN, collegeS, 
    collegeN, claytonE, claytonW, washingtonW, washingtonE, jacksonN, jacksonS, theArch, starbucks,magnolias, fiveGuys, cutters, wonderBar, boarsHead, transMet, bury, tacoStand, barBurritos,
    fuzzys, cashRegister, bus;

    private BarBathroom starbucksB, magnoliasB, fiveGuysB, cuttersB, wonderBarB, boarsHeadB, transMetB, buryB, tacoStandB, barBurritosB, fuzzysB;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        createItems();
        parser = new Parser();
        parserWithFileInput = new ParserWithFileInput();
        play();

    }

    /**
     * Creating the intersections and streets.
     */
    private void createRooms()
    {
        //         Room broadE, broadW, intersectionSW, intersectionNW, intersectionN, intersectionC, intersectionNE, intersectionSE, intersectionE, intersectionW, lumpkinS, lumpkinN, collegeS, 
        //         collegeN, claytonE, claytonW, washingtonW, washingtonE, jacksonN, jacksonS, theArch, starbucks;

        //creating the intersections
        intersectionN = new Room("at the intersection between East & West Washingtoon St. and North College Ave.");
        intersectionW = new Room("at the intersection between North & South Lumpkin St. and West Clayton St.");
        intersectionE = new Room("at the intersection between North & South Jackson St. and East Clayton St.");
        intersectionC = new Room("at the intersection between East & West Clayton St. and North and South College Ave.");

        intersectionSW = new Room("at the intersection between West Broad St. & South Lumpkin St.");
        intersectionNW = new Room("at the intersection between West Washington St. & North Lumpkin St.");
        intersectionNE = new Room("at the intersection between East Wahington St. & North Jackson St.");
        intersectionSE = new Room("at the intersection between East Broad St. & South Jackson St.");

        // creating the streets
        theArch = new Room("at the Arch. Your journey has begun!");

        broadE = new Room("on East Broad St.");
        broadW = new Room("on West Broad St.");

        lumpkinS = new Room("on South Lumpkin St.");
        lumpkinN = new Room("on North Lumpkin St.");
        collegeS = new Room("on South College Ave.");
        collegeN = new Room("on North College Ave.");
        claytonE = new Room("on East Clayton St.");
        claytonW = new Room("on West Clayton St.");
        washingtonE = new Room("on East Washington St.");
        washingtonW = new Room("on West Washington St.");
        jacksonN = new Room("on North Jackson St.");
        jacksonS = new Room("on South Jackson St.");

        // Creating Bars and their bathrooms

        starbucks = new Bar("in Starbucks. Do you even party? Why are you here on a saturday night?");
        starbucksB = new BarBathroom("in the bathroom. Looks like coffee makes you go!"); 

        cutters = new Room("in Cutters. DRAAAANNNKKKKK TIMEEEE!!!");
        cuttersB = new BarBathroom("in the bathroom. You DRAAAANNNKKKKK to much this TIMEEEE!!!");

        magnolias = new Bar("in Magnolias. Sure you look 21?.. turn around and walk away.");
        magnoliasB = new BarBathroom("in the bathrooom. You have been holding it in all night!");

        fiveGuys = new Bar("in fiveGuys. Ready to destroy some drunk munchies? The cashier doesn't seem to be paying much attention to the register.");
        fiveGuysB = new BarBathroom("in the bathroom. unfortunately the line has 5 guys in front of you... ");

        wonderBar = new Bar ("in WonderBar. Great choice my friend!");
        wonderBarB = new BarBathroom("in the bathroom. Isnt it amazing how you can use the bathroom and play Mario Kart... AT THE SAME TIME!!!");

        boarsHead = new Bar("in BoarsHead, the best bar in downtown athens!");
        boarsHeadB = new BarBathroom("in the bathroom. Someone keeps banging on the door. Hopefully your in the mens room!");

        transMet = new Bar("in TransMetropolitan Pizza. $2.50 for a slice of pizza?! You must not be a broke college student.");
        transMetB = new BarBathroom("in the bathroom. One of the few bathrooms that are clean in Athens.");

        bury = new Bar("in bury. Drink up!");
        buryB = new BarBathroom("in the bathroom. This is where dreams of grown men go to die... So much shame happens in these stalls...");

        tacoStand = new Bar(" in TacoStand. Can't say you've lived in athens if you've never stopped by this place!");
        tacoStandB = new BarBathroom("in the bathroom. Well... i could have told you that this was coming.");

        barBurritos = new Bar(" in BarBurritos. Looking forward to an upset stomach I see..");
        barBurritosB = new BarBathroom("in the bathroom. Late night burritos is a bad decision!");

        fuzzys = new Bar(" in Fuzzys. $6 margs, you're a champ!");
        fuzzysB = new BarBathroom("in the bathroom. The only thing worse than fuzzy food is... fuzzy bathrooms ");

        // initialize at the intersection exits
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
        claytonW.setExit("transmetpizza", transMet);

        claytonE.setExit("west", intersectionC);
        claytonE.setExit("east", intersectionE);
        claytonE.setExit("cutters", cutters);

        theArch.setExit("west", broadW);
        theArch.setExit("east", broadE);
        theArch.setExit("north", collegeS);
       

        broadW.setExit("west", intersectionSW);
        broadW.setExit("east", theArch);
        broadW.setExit("fiveguys", fiveGuys);

        broadE.setExit("east", intersectionSE);
        broadE.setExit("west", theArch);
        broadE.setExit("starbucks", starbucks);

        collegeS.setExit("north", intersectionC);
        collegeS.setExit("south", theArch);
        collegeS.setExit("magnolias", magnolias);

        collegeN.setExit("north", intersectionN);
        collegeN.setExit("south", intersectionC);
        collegeN.setExit("fuzzys", fuzzys);

        lumpkinS.setExit("south", intersectionSW);
        lumpkinS.setExit("north", intersectionW);
        lumpkinS.setExit("tacostand", tacoStand);

        lumpkinN.setExit("south", intersectionW);
        lumpkinN.setExit("north", intersectionNW);
        lumpkinN.setExit("bury", bury);

        jacksonS.setExit("south", intersectionSE);
        jacksonS.setExit("north", intersectionE);
        jacksonS.setExit("barburritos", barBurritos);

        jacksonN.setExit("south", intersectionE);
        jacksonN.setExit("north", intersectionNE);

        washingtonW.setExit("east", intersectionN);
        washingtonW.setExit("west", intersectionNW);
        washingtonW.setExit("boarshead", boarsHead);

        washingtonE.setExit("west", intersectionN);
        washingtonE.setExit("east", intersectionNE);
        washingtonE.setExit("wonderbar", wonderBar);

        //initialize bar exits

        starbucks.setExit("outside", broadE);
        starbucks.setExit("bathroom",starbucksB);
        starbucksB.setExit("out",starbucks);

        magnolias.setExit("outside", collegeS);
        magnolias.setExit("bathroom", magnoliasB);
        magnoliasB.setExit("out", magnolias);

        fiveGuys.setExit("outside", broadW);
        fiveGuys.setExit("bathroom",fiveGuysB);
        fiveGuysB.setExit("out",fiveGuys);

        cutters.setExit("outside", claytonE);
        cutters.setExit("bathroom",cuttersB);
        cuttersB.setExit("out",cutters);

        wonderBar.setExit("outside", washingtonE);
        wonderBar.setExit("bathroom",wonderBarB);
        wonderBarB.setExit("out",wonderBar);

        boarsHead.setExit("outside", washingtonW);
        boarsHead.setExit("bathroom",boarsHeadB);
        boarsHeadB.setExit("out",boarsHead);

        transMet.setExit("outside", claytonW);
        transMet.setExit("bathroom",transMetB);
        transMetB.setExit("out",transMet);

        bury.setExit("outside", lumpkinN);
        bury.setExit("bathroom",buryB);
        buryB.setExit("out",bury);

        tacoStand.setExit("outside", lumpkinS);
        tacoStand.setExit("bathroom",tacoStandB);
        tacoStandB.setExit("out",tacoStand);

        barBurritos.setExit("outside", jacksonN);
        barBurritos.setExit("bathroom",barBurritosB);
        barBurritosB.setExit("out",barBurritos);

        fuzzys.setExit("outside", collegeN);
        fuzzys.setExit("bathroom",fuzzysB);
        fuzzysB.setExit("out",fuzzys);

        currentRoom = theArch;  // start game at theArch
    }

    /**
     * 
     * creating People
     *
     */
    public void createPeople()
    {

        // Person theEX = new theEX("Hell hath no fury like a woman scorned.");
    }

    /**
     * 
     * creating Items
     * 
     */
    public void createItems()

    {
        Item tequilla = new Beverage("tequilla");
        Item water = new Beverage("water");
        Item coffee = new Beverage("coffee");
        Item beer = new Beverage("beer");
        Item vodka = new Beverage("vodka");

        Item burger = new Food("burger");
        Item fries = new Food("fries");

        boarsHead.setItem(1,beer);
        boarsHead.setItem(2,vodka);
        starbucks.setItem(1,water);
        starbucks.setItem(2,coffee);
        fiveGuys.setItem(1,burger);
        fiveGuys.setItem(2,fries);
        magnolias.setItem(1,beer);
        magnolias.setItem(2,vodka);

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
        System.out.println("Welcome to the Athens!");
        System.out.println("Here in Athens people like to enjoy themselves by going downtown at night.");
        System.out.println("It would seem that most of these nights are fuled by alcohol.");
        System.out.println("Though they try as hard as they can, the police can not catch every under aged drinker.");
        System.out.println("Being the freshman that you are, you also enjoy the nightlife here in Athens."); 
        System.out.println("Probably a bit too much.");
        System.out.println("You lost your wallet and keys to your dorm, you need to find your roommate to see if he");
        System.out.println("knows where they are. You know he is an avid drinker and will likely be in a bar.");
        System.out.println("Because you are not 21, you need to get a fake ID from... well.. you have your 'resources'.");
        System.out.println("Word on the street is that a fake ID dealer is somewhere in a restauraunt that doesn't sell alcohol.");
        System.out.println("In order to get the ID, you need to get money without getting caught."); 
        System.out.println("For a night to be successful, everyone knows that you must wander in and out");
        System.out.println("of bars, meet people, and find your way back home safely.");
        System.out.println("Your goal is to have a successful night by finding your way around Athens to find");
        System.out.println("friends and items that will help you get on the bus back at the Arch.");
        System.out.println();
        System.out.println("Can you survive a night of fun in Athens without getting arrested?");
        System.out.println("Will you be able to find your way back without getting sick along the way?");
        System.out.println("Who knows!?! but either way it will be a night to remember... or not... ");
        System.out.println("Either way, good luck!!!");
        System.out.println();
        System.out.println();
        System.out.println("Here are your command words to help you navigate through the game.");
        printHelp();
        System.out.println();
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
        boolean arrested = false;
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
            if(stolenCash > 0)
            {
                cops++;
            }
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        } 
        else if(commandWord.equals("map"))
        {

        }
        else if (commandWord.equals("evade")){
            evade(command);
        }
        else if(commandWord.equals("enter")) {
            if(stolenCash > 0)
            {
                cops++;
            }

            enterRoom(command);
        }
        else if(commandWord.equals("drink"))
        {
            if(stolenCash > 0)
            {
                cops++;
            }
            drinkItem(command);
        }  
        else if(commandWord.equals("steal"))
        {
            if(stolenCash > 0)
            {
                cops++;
            }
            stealCash(command);
        }
        else if(commandWord.equals("eat"))
        {
            eatFood(command);
        }
        else if (commandWord.equals("hi"))
        {
            if(stolenCash > 0)
            {
                cops++;
            }
            sayingHi(command);
        }
        else if (commandWord.equals("yes"))
        {
            if(stolenCash > 0)
            {
                cops++;
            }
            sayingYes(command);
        }
        else if (commandWord.equals("no"))
        {
            if(stolenCash > 0)
            {
                cops++;
            }
            sayingNo(command);
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

        if (cops == 10)
        {
            System.out.println("THE POLICE RECIEVED A CALL THAT FIVEGUYS HAS BEEN ROBBED!");
        }
        if (cops == 15)
        {
            System.out.println("THE POLICE GOT YOUR DESCRIPTION FROM WITNESSES!");
        }
        if (cops == 21)
        {
            System.out.println("THE POLICE ARE ON THE PATROL LOOKING FOR YOU!");
        }
        if (cops == 28)
        {
            System.out.println("THE POLICE ARE CLOSING IN ON YOUR POSITION!");
        }
        if (cops == 32)
        {
            System.out.println("THE POLICE HAVE SPOTTED YOU! EVADE IF YOU CAN!");
            if (evades == 0){
                currentRoom.setExit("evade",currentRoom);
                System.out.println(currentRoom.getExitString());
            }

        }
        if (cops == 33)
        {
            System.out.println("THE POLICE CAUGHT AND ARRESTED YOU! YOU ARE IN JAIL!");
            arrested = endGame();

        }

        return wantToQuit;

    }

    public void evade(Command command)
    {
        String secondWord = command.getSecondWord();

        if(command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Evade what?");
            return;
        }
        if(cops < 24)
        { 
            System.out.println("Evade what?");
            return;
        }

        if (evades == 0){
            System.out.println("YOU HAVE SUCCESSFULLY EVADED THE POLICE! BUT THEY WILL BE BACK SOON!");
            evades++;
            currentRoom = currentRoom;
            currentRoom.removeExit("evade");
            System.out.println(currentRoom.getLongDescription());
            cops = cops - 7;
        }
        else
        {
            cops++;
        }

    }

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("If you are on the street type");
        System.out.println("'go' followed by one of the words 'north', 'south', 'east', or 'west'");
        System.out.println("An example would be 'go north'");
        System.out.println();
        System.out.println("If you are next to a bar, room, or bus, type");
        System.out.println("'enter' followed by one of the words 'starbucks', 'tacostand', 'fiveguys', etc.");
        System.out.println("An example would be 'enter starbucks'");
        System.out.println();
        System.out.println("If you are in a building or a room type");
        System.out.println("'go' followed by one of the words 'outside', 'out', or 'back'");
        System.out.println();
        System.out.println("If you are next to a cash register type 'steal' followed by 'cash'.");
        System.out.println();
        System.out.println("If the cops have closed in on you, simply type 'evade', however this can be used only once");
        System.out.println();
        System.out.println("If you have found a person type 'hi' to talk to them, then 'yes', or 'no' to respond.");
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
        else if(secondWord.equals("west"))
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
        else if(secondWord.equals("north"))
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
        else if(secondWord.equals("south"))
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
        else if(secondWord.equals("outside"))
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
        else if(secondWord.equals("out"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("Go out where?");
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                if(currentRoom == starbucks || currentRoom == magnolias || currentRoom == cutters || currentRoom == wonderBar || currentRoom == boarsHead || currentRoom == bury || currentRoom == tacoStand
                || currentRoom == barBurritos || currentRoom == fuzzys){
                    System.out.println(currentRoom.getItemsDesc());
                }

                if(currentRoom == starbucksB)
                {
                    System.out.println(currentRoom.getPersonDesc());
                }
            }
        }
        else if(secondWord.equals("back"))

        {

            Room nextRoom = currentRoom.getExit(secondWord);
            if (nextRoom == null) {
                System.out.println("Go back to what?");
            }
            else {

                currentRoom = nextRoom;
                currentRoom.removeExit("cashregister");

                System.out.println(currentRoom.getLongDescription());

            }
        }
        else if (secondWord.equals("starbucks"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("mognolias"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("fuzzys"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("tacostand"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("bury"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("barburritos"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("boarshhead"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("wonderbar"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("fiveguys"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("cutters"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        else if (secondWord.equals("transmet"))
        {
            System.out.println("You need to specify movement. Type 'enter' to move into bars, restauraunts, and rooms.");
        }
        theArch.changeDesc("at the Arch.");

        return wantToGo;
    }

    public void enterRoom(Command command)
    {

        String secondWord = command.getSecondWord();
        if (command.isSecondUnknown())
        {
            System.out.println("Enter what?");
            return;
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
                return;
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                System.out.println(currentRoom.getItemsDesc());
                currentRoom.changeDesc("in Starbucks.");
            }

        }
        else if (secondWord.equals("magnolias"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{

                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("Magnolias is located somewhere else!");
                    return;
                }

                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in Magnolias.");
                }
            }

        }
        else if (secondWord.equals("fiveguys"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);
            if (nextRoom == null) {
                System.out.println("FiveGuys is not located here");
                return;
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                System.out.println(currentRoom.getItemsDesc());
                currentRoom.changeDesc("in FiveGuys.");
            }

        }
        else if (secondWord.equals("cutters"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{

                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("Cutters is not located here!");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in Cutters.");
                }
            }

        }
        else if (secondWord.equals("wonderbar"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{

                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("Hmm... i wonder where the bar is... wonder...bar... ");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in Wonderbar.");
                }
            }

        }
        else if (secondWord.equals("boarshead"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{

                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("this is not where BoarsHead is...");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    if(currentRoom == boarsHead && keysWallet == 0){
                        roommate = new Person("Your Roommate.");
                        boarsHead.setPerson(roommate);
                        System.out.println(currentRoom.getPersonDesc());
                    }
                    currentRoom.changeDesc("in BoarsHead.");

                }
            }
        }
        else if (secondWord.equals("transmetpizza"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);
            if (nextRoom == null) {
                System.out.println("There is no TransMetPizza here!");
                return;
            }
            else {

                System.out.println("The doors are locked, you can't get in!");

            }

        }
        else if (secondWord.equals("bury"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{
                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("The Bury is not here, try another street!");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in The Bury.");
                }
            }

        }
        else if (secondWord.equals("tacostand"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{

                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("There is no TacoStand here!");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in TacoStand.");
                }
            }

        }
        else if (secondWord.equals("barburritos"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{

                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("You can not find a burrito here my friend.");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in BarBurritos.");
                }
            }

        }
        else if (secondWord.equals("fuzzys"))
        {
            if(fakeID == 0)
            {
                System.out.println("Bouncer: 'Until I see your ID, I won't let you in here.'");
                return;
            }
            else{
                Room nextRoom = currentRoom.getExit(secondWord);
                if (nextRoom == null) {
                    System.out.println("Your memory is fuzzy! Fuzzys is on a different street!");
                    return;
                }
                else {
                    currentRoom = nextRoom;
                    System.out.println(currentRoom.getLongDescription());
                    System.out.println(currentRoom.getItemsDesc());
                    currentRoom.changeDesc("in Fuzzys.");
                }
            }

        }

        else if (secondWord.equals("bathroom"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);
            if (nextRoom == null) {
                System.out.println("There is no bathroom here!");
                return;
            }
            else {
                currentRoom = nextRoom;

                System.out.println(currentRoom.getLongDescription());

                if(currentRoom == starbucksB && fakeID == 0){
                    fakeIDGuy = new Person("Fake ID Guy");
                    starbucksB.setPerson(fakeIDGuy);
                    System.out.println(currentRoom.getPersonDesc());
                }
                currentRoom.changeDesc("in the bathroom.");

            }

        }

        else if (secondWord.equals("stall"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no stall here!");
                return;
            }
            else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());

            }
        }
        else if (secondWord.equals("bus"))
        {
            Room nextRoom = currentRoom.getExit(secondWord);

            if (nextRoom == null) {
                System.out.println("There is no bus here!");
                return;
            }
            else {
                cops = 0;
                currentRoom = nextRoom;
                System.out.println("Great success! You go on the bus and rode back home against all odds! You Win!");
                endGame();
            }

        }
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
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages \n");
                if(currentRoom == boarsHead){
                    drinksWithRM++;
                    if(drinksWithRM >= 4)
                    {
                        drankWithRM();
                    }
                }
            }

        }
        else if (secondWord.equals("taquilla"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You drank " +secondWord+".");
                numberOfDrinks++;
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages \n");
            }

        }
        else if (secondWord.equals("vodka"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You drank " +secondWord+".");
                numberOfDrinks++;
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages \n");
            }

        }
        else if (secondWord.equals("liquor"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You drank " +secondWord+".");
                numberOfDrinks++;
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages \n");
            }

        }
        else if (secondWord.equals("surprise"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("That bartender sure know how to make'em, this was a bad choice.");
                numberOfDrinks++;
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages \n");
            }

        }
        else if (secondWord.equals("water"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You drank a water.");
                numberOfDrinks--;
                System.out.println("You have had "+ numberOfDrinks +" alcoholic beverages \n");
                System.out.println("Apparently water has the opposite effect of alcohol");
            }

        }
        if(numberOfDrinks == 4)
        {
            System.out.println("Getting a little dizzy. \n");
        }
        if(numberOfDrinks == 6)
        {
            System.out.println("Tore up from the floor up!!!");
        }
        if(numberOfDrinks == 8)
        {
            System.out.println("Throwing up!!!");
        }
        if(numberOfDrinks == 9)
        {
            System.out.println("You have a problem.");
        }
        if(numberOfDrinks == 10)
        {
            System.out.println("Seriously Stop!!!");
        }
        if(numberOfDrinks == 11)
        {
            System.out.println("Last chance!!!");
        }
        if(numberOfDrinks == 12)
        {
            System.out.println("You died of alcohol poisoning");
            System.out.println("Game Over");
            quit(null);          

        }
    }

    public void eatFood(Command command)
    {
        String secondWord = command.getSecondWord();

        if(!command.hasSecondWord())
        {
            System.out.println("Eat what?");
            return;
        }
        if (secondWord.equals("hamburger"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You ate a " +secondWord+".");

            }

        }
        else if (secondWord.equals("taco"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You ate a  " +secondWord+".");

            }
        }
        else if (secondWord.equals("pizza"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There is no " +secondWord+" here!");
            }
            else {
                System.out.println("You ate a " +secondWord+".");

            }

        }
        if (secondWord.equals("fries"))
        {
            Item items1 = currentRoom.getItem(1);
            Item items2 = currentRoom.getItem(2);
            if (items1 == null && items2 == null) {
                System.out.println("There are no " +secondWord+" here!");
            }
            else {
                System.out.println("You ate " +secondWord+".");

            }

        }

    }

    private void stealCash(Command command)
    {
        String secondWord = command.getSecondWord();  
        boolean arrested = false;

        if(secondWord.equals("cash"))
        {
            Room nextRoom = currentRoom.getExit("cashregister");
            if (nextRoom == null) {
                System.out.println("There is no cash here you theif!");
                return;
            }

            if(currentRoom != fiveGuys)
            {
                arrested = endGame();

                System.out.println("You go caught! You got arrested and thrown in jail. Game Over.");

                return;
            }
            else

            {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                stolenCash = 27;

            }
        }
    }

    public void sayingHi(Command command)
    {

        if(command.hasSecondWord()) {
            System.out.println("Hi what?");
            return;
        }
        Person foundPerson = currentRoom.getPerson();
        if(foundPerson == null) {
            System.out.println("Who are you saying hi to???");
            return;
        }

        if(fakeIDGuy == foundPerson)
        {
            System.out.println("Fake ID Guy: 'Hey you and I both know why we are here, so lets cut to the chase.'");
            System.out.println("'Give me a few dead presidents and you'll get your new ID. Are you ready to do this?' \n");
        }

        if(roommate == foundPerson)
        {
            System.out.println("Roommate: 'Hey Roomie!!! Did you know that I had your wallet and keys?' \n");
        }

    }

    public void sayingYes(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Yes what?");
            return;
        }
        Person foundPerson = currentRoom.getPerson();
        if(foundPerson == null) {
            System.out.println("Who are you saying yes to???");
            return;
        }

        if(fakeIDGuy == foundPerson)
        {
            if(stolenCash > 0)
            {
                System.out.println("Fake ID Guy: 'Ok then here ya go, hope to never see you again.' \n ");
                fakeID = 3;
                fakeIDGuy = null;
                System.out.println("You aquired a fake ID. Now you can access bars. \n");
            }
            else{
                System.out.println("Fake ID Guy: 'I wont give you the id unless you give me the casheesh' \n");
            }
        }
        if(foundPerson == roommate)
        {

            System.out.println("Roommate: 'Since I have your keys, you gotta drink with me before I let you leave.' \n");

        }

    }

    private void sayingNo(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("No what?");
            return;
        }
        Person foundPerson = currentRoom.getPerson();
        if(foundPerson == null) {
            System.out.println("Who are you saying no to???");
            return;
        }

        if(foundPerson == fakeIDGuy)
        {

            System.out.println("Fake ID Guy: 'I wont give you the ID unless you give me the casheesh' \n");

        }

        if(foundPerson == roommate)
        {

            System.out.println("Roommate: 'Since I have your keys, you gotta drink with me before I let you leave.' \n");

        }
    }

    private void drankWithRM()
    {
        System.out.println("Roommate: 'YOU KNOW HOW TO DRAAAAANK! HERE YOU GO! Take your keys and.... and... oh, wallet. SEE YOU AT HOME!!!'");
        System.out.println("...if you make it.' \n");   
        keysWallet = 4;
        roommate = null;
        bus = new Room("This bus will take you back home. \n");
        theArch.setExit("bus",bus);
        System.out.println("You now have your keys and wallet. \n");
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

    private boolean endGame() 
    {

        return true;  // signal that we want to quit
    }
}
