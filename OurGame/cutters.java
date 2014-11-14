
/**
 * Write a description of class cutters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cutters extends Room
{
    public cutters(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("cutters"))
        {
            System.out.println("You entered cutters. " +
                "The good ole Irish pub");
            
        }
        else
        {
            super.open(command);
        }
    }
}