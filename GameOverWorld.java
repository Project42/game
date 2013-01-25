import greenfoot.*;
import java.io.IOException;

public class GameOverWorld extends World {
    private int actsPassed;
    private Game game;
    private int score;
    
    public GameOverWorld(Game game, int score) {
        super(600, 400, 1); 
        this.game = game;
        this.score = score;
        getBackground().scale(600, 400);
    }
    
    @Override
    public void act() {
        if (++actsPassed == 50) {
            HighScore highScore = HighScore.askName(score);
            if (highScore != null) {
                try {
                    highScore.save(HighScore.defaultFilenameForGame(game));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Greenfoot.setWorld(new HighScoreWorld(game));
        }
    }
}
