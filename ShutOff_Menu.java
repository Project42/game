import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShutOff_Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShutOff_Menu extends Menu
{
    public void addedToWorld(World world)
    {
        setImage("shut_off_street.png");
    }
    
    public void act() 
    {
        checkClicked(2);
    }    
}
