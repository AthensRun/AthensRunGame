
/**
 * Write a description of class wonderbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wonderbar extends Room
{
    public wonderbar(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("wonderbar"))
        {
            System.out.println("You entered wonderbar. " +
                "Time to game bro");
            
        }
        else
        {
            super.open(command);
        }
    }
}