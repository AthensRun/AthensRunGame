
/**
 * Write a description of class boarshead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boarshead extends Room
{
   
    
    public boarshead(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("boarshead"))
        {
            System.out.println("You entered Boarshead. " +
                "Where the somewhat 'classy' come to play pool and listen to music");
            
        }
        else
        {
            super.open(command);
        }
    }
}