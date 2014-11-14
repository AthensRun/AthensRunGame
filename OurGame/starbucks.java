
/**
 * Write a description of class starbucks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class starbucks extends Room
{
    public starbucks(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("starbucks"))
        {
            System.out.println("You entered Starbucks " +
                "Do you even party? why are you here on a saturday night?");
            
        }
        else
        {
            super.open(command);
        }
    }
}