import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MagicHat  extends Actor
{   
    private int v2;
    private int v2anterior=0;
    private boolean cr=false;
    
    public MagicHat(){
        setImage("sombrero.gif");
    }
    public void act() 
    {   
        checapuntaje();
        if(v2>v2anterior){
            regalaitem();
        }
    }    
    
    public void checapuntaje(){
        
        List<HelmetBoy> listhb=getWorld().getObjects(HelmetBoy.class);
        if(!listhb.isEmpty()){
            HelmetBoy hb=listhb.get(0);
            cr=hb.getcasco();
            Puntaje p=hb.getpuntaje();
            v2=p.getcifra2();
        }
    }
        
    public void regalaitem(){
        
        int x=getX(),y=getY();
        
        y-=30;
        if(cr){
            Bomba b= new Bomba();
            getWorld().addObject(b,x,y);
        }else{
            CascoRojoItem ic= new CascoRojoItem();
            getWorld().addObject(ic,x,y);
        }
        
        v2anterior=v2;
    }
    
}
