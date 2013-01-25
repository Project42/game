import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Toont sprite in het menu en is klikbaar
 * 
 */
public class Extinguish_Menu extends Menu
{
    public void addedToWorld(World world)
    {
        setImage("firefighter.png");
    }
    
    public void act() 
    {
        // Checks if object itself has been clicked
        checkClicked(1);
    }    
}
