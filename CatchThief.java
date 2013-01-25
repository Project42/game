import greenfoot.*;

/**
 * Politie vangt boeven die aan het plunderen zijn.
 * 
 * Project 42
 */
public class CatchThief extends Intervention
{
    public void addedToWorld(World world)
    {
        // Dit moet een werkende .GIF zijn
        setImage("thief_chasing.gif");
    }
    
    public void act()
    {
        super.act();
    }
}