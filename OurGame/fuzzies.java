
/**
 * Write a description of class fuzzies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fuzzies extends Room
{
    public fuzzies(String description)
    {
        super(description);
    }
    public void enter(Command command)
    {
        if(command.getSecondWord().equals("fuzzies"))
        {
            System.out.println("You entered fuzzies. " +
                "Yes this is actually a restraunt... hopefully the food is not fuzzy");
            
        }
        else
        {
            super.open(command);
        }
    }
}