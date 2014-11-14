
/**
 * Write a description of class transmet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class transmet extends Room
{
    public transmet(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("transmet"))
        {
            System.out.println("Transmet is closed. " +
                "It is a daytime pizza shop only.");
            
        }
        else
        {
            super.open(command);
        }
    }
}