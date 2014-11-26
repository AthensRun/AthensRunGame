
/**
 * Write a description of class CashRegister here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends Room
{
    // instance variables - replace the example below with your own
    public Bar(String description)
    {
        super(description);
     
        Room cashRegister = new Room("a thief! You succesfully stole the cash!");
        
        setExit("cashregister",cashRegister);
        cashRegister.setExit("back",this);


    }

}
