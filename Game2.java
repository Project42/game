import greenfoot.*;

public class Game2 extends Buttons {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new HelicopterWorldMenu());
        }
    }
}
