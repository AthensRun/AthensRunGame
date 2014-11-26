import java.util.Set;
import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits; 

    private Command command;
    private Person person1;
    private Item item1;
    private Item item2;
    // stores exits of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + "    " +  getExitString() + " \n ";
    }
    
     

  
    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getExitString()
    {
        String returnString = "Available Directions:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit +", ";
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public void removeExit(String direction) 
    {
         exits.remove(direction);
    }

    public void see(Command command)
    {
        System.out.println("Do What?");
    }

    public void changeDesc(String newDescription)
    {
        description = newDescription;
    }

    public void setPerson( Person pPerson)
    {
        
        
            person1 = pPerson; 

        
           
    }

    public Person getPerson()
    {

         if(person1 != null)
        {
            return person1;

        }
         return null;

    }

    public void setItem(int itemNo, Item pItem)
    {
        if(itemNo == 1)
        {
            item1 = pItem;

        }
        if (itemNo == 2)
        {
            item2 = pItem;
        }
    }

    public Item getItem(int itemNo)
    {
        if(itemNo == 1)
        {
            return item1;

        }
        if (itemNo == 2)
        {
            return item2;
        }
        return null;

    }

    public String getItemsDesc()
    {
     
        return "Food and Beverages: " + item1.getDesc() + ",  " + item2.getDesc() + " \n ";
        
    }
 
        public String getPersonDesc(){
            
    
       return "Found People: " + person1.getDesc() + "\n" ;
   
    
    }

}
