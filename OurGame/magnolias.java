
/**
 * Write a description of class magnolias here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class magnolias extends Room
{
    public magnolias(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("magnolias"))
        {
            System.out.println("You got denied from Magnolias. " +
                "Better not come back here again ");
            
        }
        else
        {
            super.open(command);
        }
    }
}