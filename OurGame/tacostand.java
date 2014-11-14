
/**
 * Write a description of class TacoStand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tacostand extends Room
{
    public tacostand(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("tacostand"))
        {
            System.out.println("You entered Taco Stand. " +
                "The only place you can get alcohol and tacos... at the same time");
            
        }
        else
        {
            super.open(command);
        }
    }
}
