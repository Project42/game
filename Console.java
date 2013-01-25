import greenfoot.*;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class Console extends Actor {
    List<String> messages;

    public Console() {
        messages = new ArrayList<String>();
    }

    public void addMessage(String message) {
        messages.add(message);
        if (messages.size() > 13) messages.remove(0);
        setImage(renderToImage());
    }

    private GreenfootImage renderToImage() {
        GreenfootImage image = new GreenfootImage(370, 220);
        image.setColor(Color.BLACK);

        String string = "";
        int i = 0;
        for (String message : messages) {
            image.drawString(message, 10, 15 + i * 18);
            ++i;
        }

        return image;
    }
}

