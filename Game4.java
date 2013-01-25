import greenfoot.*;

public class Game4 extends Buttons {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setSpeed(38);
            Greenfoot.setWorld(new SkyscraperWorld());
        }
    }
}
