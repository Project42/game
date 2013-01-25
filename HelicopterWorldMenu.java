import greenfoot.*;

public class HelicopterWorldMenu extends World
{
    public HelicopterWorldMenu()
    {    
        super(80, 80, 10);
        setBackground("HeliMenu.png");
    }
    
    @Override
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new HelicopterWorld());
            return;
        }
    }
}