
/**
 * Write a description of class barburritos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class barburritos extends Room
{
    public barburritos(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("barburritos"))
        {
            System.out.println("You entered barburritos " +
                "late night munchies, just dont eat from the salsa bowl");
            
        }
        else
        {
            super.open(command);
        }
    }
}