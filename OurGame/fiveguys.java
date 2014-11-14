
/**
 * Write a description of class fiveguys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fiveguys extends Room
{
    public fiveguys(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("fiveguys"))
        {
            System.out.println("You entered fiveguys " +
                "The secret ingredient is grease");
            
        }
        else
        {
            super.open(command);
        }
    }
}