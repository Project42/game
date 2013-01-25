import java.awt.Toolkit;    
import java.awt.event.WindowEvent;    
import java.lang.reflect.Field;   
import greenfoot.core.WorldHandler;    
import greenfoot.export.GreenfootScenarioViewer;    
import greenfoot.platforms.WorldHandlerDelegate;    
import greenfoot.platforms.standalone.WorldHandlerDelegateStandAlone;    
import javax.swing.RootPaneContainer;  
import javax.swing.JFrame;  
    
public class Quitbutton extends Buttons { 
   
    public void close() throws NoSuchFieldException,java.lang.IllegalAccessException{    
        WorldHandler wh = WorldHandler.getInstance();    
        Field whd_get = WorldHandler.class.getDeclaredField("handlerDelegate");    
        whd_get.setAccessible(true);    
        WorldHandlerDelegate w = (WorldHandlerDelegate)whd_get.get(wh);    
        if(w instanceof WorldHandlerDelegateStandAlone)    
        {    
           WorldHandlerDelegateStandAlone wsa = (WorldHandlerDelegateStandAlone)w;    
            Field gsv_get = WorldHandlerDelegateStandAlone.class.getDeclaredField("viewer");    
            gsv_get.setAccessible(true);    
            GreenfootScenarioViewer gsv = (GreenfootScenarioViewer)gsv_get.get(wsa);    
            Field f = GreenfootScenarioViewer.class.getDeclaredField("rootPaneContainer");    
            f.setAccessible(true);    
            System.out.println(f.get(gsv).getClass());  
            JFrame rpc = (JFrame)f.get(gsv);    
            WindowEvent wev = new WindowEvent(rpc, WindowEvent.WINDOW_CLOSING);    
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);  
        }    
        else return; //Not stand-alone, don't continue.    
    }    
}  