
/**
 * Write a description of class BarBathroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarBathroom extends Room
{

    private Room stall, currentRoom, starbucksB;

   

    public BarBathroom(String description)
    {
        super(description);

        Room stall = new Room("in a damp and musty stall.");

        setExit("stall",stall);
        stall.setExit("out",this);
      

    }

    }

