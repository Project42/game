import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CatchThief_Menu here.
 * 
 */
public class CatchThief_Menu extends Menu
{
    public void addedToWorld(World world)
    {
        setImage("arrest.png");
    }
    
    public void act() 
    {
        checkClicked(4);
    }    
}
