
/**
 * Write a description of class Drink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Purchases
{
    public Purchases ()
    {
         
    }
    
     public void buyFood(Command command)
    {
        
        
        if(command.getSecondWord().equals("water"))
            {
            System.out.println("you ordered water");
            
            }
        if(command.getSecondWord().equals("taquilla"))
            {
            System.out.println("you ordered water");
            
            }    
        if(command.getSecondWord().equals("beer"))
            {
            System.out.println("you ordered water");
            
            }    
        
            
         if(command.getSecondWord().equals("coffee"))
            {
            System.out.println("you ordered coffee");
            
            }
            
        
    
    }
    
        
}
