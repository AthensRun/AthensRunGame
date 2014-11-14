
/**
 * Write a description of class Directory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Directory extends Room
{

    /**
     * Constructor for objects of class 
     */
    public Directory(String description)
    {
        super(description);
    }
    public void see(Command command)
    {
        if(command.getSecondWord().equals("map"))
        {
            System.out.println("You are now looking at the directory.");
            
            //insert method for picture

        }
        else
        {
            super.see(command);
        }
    }

    
}