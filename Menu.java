import greenfoot.*;

/**
 * Bevat alle menuitems
 * 
 */
public class Menu extends Actor
{
   /** Checks whether object has been clicked
     * If true, sets the Character variable to POLICE_SHUTOFF
     */
    private String originalFirefighter = "firefighter.png";
    private String originalShutOff = "shut_off_street.png";
    private String originalEvacuate = "evac_vehicle.png";
    private String originalCatchThief = "arrest.png";
    
    public void checkClicked(int character) 
    {
        ControlroomWorld world = (ControlroomWorld)getWorld();
        if (Greenfoot.mouseClicked(this)) 
        {
            
            if (character == 1) {
                 world.setSelectedCharacter(ControlroomWorld.Character.FIREFIGHTER);
                }
            else if (character == 2) {
                 world.setSelectedCharacter(ControlroomWorld.Character.POLICE_SHUTOFF);
            }
            
            else if (character == 3) {
                 world.setSelectedCharacter(ControlroomWorld.Character.POLICE_EVACUATE);
            }
            
            else if (character == 4) {
                 world.setSelectedCharacter(ControlroomWorld.Character.POLICE_CATCHTHIEF);
             }

        }

        if (world.getSelectedCharacter() == ControlroomWorld.Character.FIREFIGHTER) {
            world.getExtinguishMenu().setImage("firefighter_glow.png");
            world.getShutOffMenu().setImage(originalShutOff);
            world.getEvacuateMenu().setImage(originalEvacuate);
            world.getCatchThiefMenu().setImage(originalCatchThief);
        }
        
        else if (world.getSelectedCharacter() == ControlroomWorld.Character.POLICE_SHUTOFF) {
            world.getShutOffMenu().setImage("shut_off_street_glow.png");
            world.getExtinguishMenu().setImage(originalFirefighter);
            world.getEvacuateMenu().setImage(originalEvacuate);
            world.getCatchThiefMenu().setImage(originalCatchThief);
        }
        
        else if (world.getSelectedCharacter() == ControlroomWorld.Character.POLICE_EVACUATE) {
            world.getEvacuateMenu().setImage("evac_vehicle_glow.png");
            world.getExtinguishMenu().setImage(originalFirefighter);
            world.getShutOffMenu().setImage(originalShutOff);
            world.getCatchThiefMenu().setImage(originalCatchThief);
        }
        else if (world.getSelectedCharacter() == ControlroomWorld.Character.POLICE_CATCHTHIEF) {
            world.getCatchThiefMenu().setImage("arrest_glow.png");
            world.getExtinguishMenu().setImage(originalFirefighter);
            world.getShutOffMenu().setImage(originalShutOff);
            world.getEvacuateMenu().setImage(originalEvacuate);
        }
        else {
            world.getExtinguishMenu().setImage(originalFirefighter);
            world.getShutOffMenu().setImage(originalShutOff);
            world.getEvacuateMenu().setImage(originalEvacuate);
            world.getCatchThiefMenu().setImage(originalCatchThief);
        }
    }
}