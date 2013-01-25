import greenfoot.*;

public class GravelBag extends Bag {
    public GravelBag() {
        super(2, 6);
        getImage().scale(50,50);
    }
    
    @Override
    public int getCost() {
        return 20;
    }
}
