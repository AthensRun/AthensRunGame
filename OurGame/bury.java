
/**
 * Write a description of class bury here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bury extends Room
{
    public bury(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("bury"))
        {
            System.out.println("You entered the bury. " +
                "The stalagtites on the ceiling are real and rediculous their prices");
            
        }
        else
        {
            super.open(command);
        }
    }
}