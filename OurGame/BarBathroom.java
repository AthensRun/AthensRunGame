
/**
 * Write a description of class BarBathroom here.
 * 
 * @author (your name) 
 * 
 * @version (a version number or a date)
 */
public class BarBathroom extends Room
{

  
     
    public BarBathroom(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        String secondWord = command.getSecondWord();
        if(secondWord.equals("bathroom"))
        {
            getLongDescription();
            Room stall = new Room("in a damp and musty bathroom stall.");
            stall.setExit("out", this);
            setExit("stall", stall);
            
            
            
        }
    
    }

    
}



