
/**
 * Write a description of class starbucks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starbucks extends Room
{
    
    
    public Starbucks(String description)
    {
        super(description);
    }
    public void inStarbucks(Command command)
    {
        String commandWord = command.getCommandWord();
        String secondWord = command.getSecondWord(); 
        
           if(!secondWord.equals("water") || !secondWord.equals("coffee"))
            {
                System.out.println("You cannot order " + secondWord + " here.");
       
        }
    }
    
}
      
