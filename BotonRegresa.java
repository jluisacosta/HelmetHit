import greenfoot.*;

public class BotonRegresa  extends Actor
{
    public BotonRegresa(){
        super();
        setImage("br1.gif");
        
    }
    
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getActor() == this){
                
                setImage("br1x.gif");
            }
            else{
                   setImage("br1.gif");
                   }                
        }
        
        if(Greenfoot.mouseClicked(this)){
            
            CubeTown ctown = (CubeTown)getWorld();
            ctown.init();
            getWorld().removeObject(this);
        }
        
    }        
}
