import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Item  extends Actor
{
    public boolean explota=false;
    public int saltoi=15;
    
    public void act() 
    {
        salta();
        List<HelmetBoy> listah= getObjectsInRange(10,HelmetBoy.class);
        if(!listah.isEmpty()){
            HelmetBoy hb=listah.get(0); 
            if(this.getClass()==CascoRojoItem.class){hb.tencascorojo();getWorld().removeObject(this);}
            else if(this.getClass()==Bomba.class){explota=true;}
            
        }     
    }
    
    public void salta(){
        
        int x=getX(),y=getY();
        if(saltoi>0){
            
            if(saltoi>10){y-=4;}else{y+=2;}
            
            if(this.getClass() == CascoRojoItem.class){
                x-=5;
            }else if(this.getClass() == Bomba.class){
                x+=5;}
                
                saltoi--;
                setLocation(x,y);
            }    
    }
}
