import greenfoot.*;

public class CementBag extends Bag {
    public CementBag() {
        super(3, 7);
        getImage().scale(50,50);
    }
    
    @Override
    public int getCost() {
        return 30;
    }
}
