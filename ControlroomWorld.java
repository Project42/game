import greenfoot.*;

/**
 * Dit is de kamer waarin allerlei calamiteiten ontstaan en vervolgens
 * geïnterveniëerd moeten worden door de speler.
 *
 * Project 42
 * 0.80
 */

public class ControlroomWorld extends World
{
    public Score scoreCounter;
    public PoliceUnits policeUnitsCounter;
    public FirefighterUnits firefighterUnitsCounter;
    public NumberOfDeaths numberOfDeathsCounter;
    public NumberOfSaved numberOfSavedCounter;
    public Extinguish_Menu FirefighterMenu;
    public ShutOff_Menu ShutOffMenu;
    public Evacuate_Menu EvacuateMenu;
    public CatchThief_Menu CatchThiefMenu;
    private Console console;

    private int spawnTimer = 0;
    private int spawnLocationX = 0;
    private int spawnLocationY = 0;
    public int currentScore = 0;

    // References for Life objects
    private Life life1;
    private Life life2;
    private Life life3;

    private int countLifes = 4;

    public enum Character {
        FIREFIGHTER,
        POLICE_SHUTOFF,
        POLICE_CATCHTHIEF,
        POLICE_EVACUATE,
    }

    Character selectedCharacter;

    // Getter and setter Character
    public void setSelectedCharacter(Character character) {
        selectedCharacter = character;
    }

    public Character getSelectedCharacter() {
        return selectedCharacter;
    }

    // Constructor
    public ControlroomWorld()
    {
        super(80,80,10);
        setBackground("background.png");

        // Add interface
        addObject(new MenuBar(), 39, 75);
        scoreCounter = new Score("Score: ");
        policeUnitsCounter = new PoliceUnits("Police units: ");
        firefighterUnitsCounter = new FirefighterUnits("Firefighter units:  ");
        numberOfDeathsCounter = new NumberOfDeaths("Number of deaths: ");
        numberOfSavedCounter = new NumberOfSaved("Number of saved:  ");

        addObject(numberOfDeathsCounter, 12, 59);
        addObject(numberOfSavedCounter, 12, 61);
        addObject(scoreCounter, 6, 74);
        addObject(policeUnitsCounter, 10, 46);
        addObject(firefighterUnitsCounter, 13, 48);

        addObject(console = new Console(), 58, 56);

        prepare();
    }

    /** Checks score to set difficulty over the game */
    public void checkScore(int score) {
        if (score < 600) {
            spawnSomewhere(600);
        }
        else if (score >= 1000) {
            spawnSomewhere(500);
        }
        else if (score >= 2000) {
            spawnSomewhere(450);
        }
        else if (score >= 3000) {
            spawnSomewhere(400);
        }
        else if (score >= 4000) {
            spawnSomewhere(350);
        }
        else if (score >= 5000) {
            spawnSomewhere(300);
        }
        else if (score >= 6000) {
            spawnSomewhere(250);
        }
        else if (score >= 7000) {
            spawnSomewhere(200);
        }
        else if (score >= 8000) {
            spawnSomewhere(150);
        }
        else {
            spawnSomewhere(100);
        }
    }

    /** Prepares the world by adding objects which should be initiated when rendering */
    private void prepare()
    {
        addObject(life1 = new Life(), 73, 75);
        addObject(life2 = new Life(), 69, 75);
        addObject(life3 = new Life(), 65, 75);

        // Add menu objects
        addObject(FirefighterMenu = new Extinguish_Menu(), 20, 75);
        addObject(ShutOffMenu = new ShutOff_Menu(), 30, 75);
        addObject(CatchThiefMenu = new CatchThief_Menu(), 40, 75);
        addObject(EvacuateMenu = new Evacuate_Menu(), 50, 75);
    }

    // Getter scoreCounter
    public Score getScoreCounter() {
        return scoreCounter;
    }

    // Random spawn and adds timer
    public void act() {
        spawnTimer++;
        checkScore(scoreCounter.getValue());
        setCurrentScore();
    }

    public void setCurrentScore() {
        currentScore = scoreCounter.getValue();
    }

    /** Sets a random location */
    public void spawnLocation() {
        spawnLocationX = (int)(Math.random()*((64-0)+12));
        spawnLocationY = (int)(Math.random()*((31-0)+12));

        if (getObjectsAt(spawnLocationX,spawnLocationY,Calamities.class).isEmpty())
        {
            if(spawnLocationX > 3 && spawnLocationY > 5)
            {
                    chooseObject((int)(Math.random()*((4-0)+1)));
            }
         }
    }

    /** Creates a random new object on a random location */
    public void chooseObject (int x) {
        if (x==1)
        {
            addObject(new Fire(), spawnLocationX, spawnLocationY);
            addConsoleMessage("Vuur");
        }

        else if (x==2)
        {
            addObject(new Victims(), spawnLocationX, spawnLocationY);
            addConsoleMessage("Slachtoffers");
        }
        else if (x==3)
        {
            addObject(new FloodStreet(), spawnLocationX, spawnLocationY);
            addConsoleMessage("Overstroming");
        }
        else if (x==4)
        {
            addObject(new Thief(),  spawnLocationX, spawnLocationY);
            addConsoleMessage("Dief");
        }
        setSpawnTimer(0);
    }

    // Getter and setter spawnTimer
    public void setSpawnTimer(int newSpawnTimer) {
        spawnTimer = newSpawnTimer;
    }

    public int getSpawnTimer() {
       return spawnTimer;
    }

    /** Checks timer and spawns */
    public void spawnSomewhere(int difficulty) {
        if (getSpawnTimer()>difficulty)
        {
            spawnLocation();
        }
    }

    /** Deletes a life object after a miss */
    public void loseLife() {
        countLifes--;
        if (countLifes == 3)
        {
           removeObject(life3);
        }

        else if (countLifes == 2)
        {
            removeObject(life2);
        }

        else if (countLifes == 1)
        {
            // Game Over
            System.out.println("WAAAAHHHH VERLOREN!");
            removeObject(life1);
        }
    }

    public void addConsoleMessage(String message) {
        console.addMessage(message);
    }

    public PoliceUnits getPoliceUnits() {
        return policeUnitsCounter;
    }

    public FirefighterUnits getFirefighterUnits() {
        return firefighterUnitsCounter;
    }

    public NumberOfDeaths getNumberOfDeathsCounter() {
        return numberOfDeathsCounter;
    }

    public NumberOfSaved getNumberOfSavedCounter() {
        return numberOfSavedCounter;
    }

    public Extinguish_Menu getExtinguishMenu() {
        return FirefighterMenu;
    }

    public ShutOff_Menu getShutOffMenu() {
        return ShutOffMenu;
    }

    public Evacuate_Menu getEvacuateMenu() {
        return EvacuateMenu;
    }

    public CatchThief_Menu getCatchThiefMenu() {
        return CatchThiefMenu;
    }
}
