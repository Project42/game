import greenfoot.*;

/**
 * Deze mensen moeten geëvacueerd worden door de politie.
 * 
 * Project 42
 */

public class Victims extends Calamities
{    
    Evacuate police_evacuate;
    public void addedToWorld(World world)
    {
        setImage("peoplethatneedtobeevacuated.gif");
        setDifficultyScore();
    }
    
    public void act()
    {
        super.act();
        checkClicked(); 
        checkIfIExpire(checkDifficulty());
        
        if (police_evacuate != null) {
            interventionTimer++;
            if (interventionTimer > 200) 
            {
                ControlroomWorld world = (ControlroomWorld)getWorld();
                int NumberOfSaved = (getExpireTimer()/10);
                int NumberOfDeaths = ((checkDifficulty() - getExpireTimer())/40);
                if (NumberOfDeaths > 0 && NumberOfSaved > 0) {
                    world.getNumberOfDeathsCounter().add(NumberOfDeaths);
                    world.getNumberOfSavedCounter().add(NumberOfSaved);
                }
                
                world.removeObject(this);
                world.removeObject(police_evacuate);
                world.getScoreCounter().add(50);
                world.addConsoleMessage("Het leger heeft de mensen geëvacueerd.");
                world.getPoliceUnits().add(-1);
            }
        } else {
            interventionTimer = 0;
        }
    }
    
    /** Check if object has been clicked
     * If true, it checks whether the last object clicked was a Firefighter
     * If true, it deletes the Fire object and adds 50 to score
     */
    
    public void checkClicked() {
        if (Greenfoot.mouseClicked(this)) 
        {
            ControlroomWorld world = (ControlroomWorld)getWorld();
            if (world.getSelectedCharacter() == ControlroomWorld.Character.POLICE_EVACUATE) {
                int objectLocationX = getX()+2;
                int objectLocationY = getY();
                world.addObject(police_evacuate = new Evacuate(), objectLocationX, objectLocationY);
            }
        }
    }
    
    /** Check whether object has been in the world for too long
     * If true, removes the Fire object and sets the timer back to 0
     * Difficulty argument decreases when progressing in the game, making objects expire faster
     */
    
    public void checkIfIExpire(int difficulty) {
       ControlroomWorld world = (ControlroomWorld)getWorld();

       if (getExpireTimer() > difficulty && police_evacuate == null)
       {
           int NumberOfDeaths = (getExpireTimer()/10); 
           if (NumberOfDeaths > 0) {
               world.getNumberOfDeathsCounter().add(NumberOfDeaths);
           }
           world.removeObject(this);
           world.loseLife();
           setExpireTimer(0);
       }
    }
}