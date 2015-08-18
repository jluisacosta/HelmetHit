import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Boton  extends Actor
{
    private int boton;
    
    public Boton(){}
    public Boton(int b){
        
        boton=b;
        switch(b){
            case 1: setImage("Boton1.gif");
                    break;
            case 2: setImage("Boton2.gif");
                    break;
            case 3: setImage("Boton3.gif");
                    break;
                }
    }
            
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getActor() == this){
                switch(boton){
                    
                    case 1: setImage("Boton1x.gif");
                    break;
                    case 2: setImage("Boton2x.gif");
                    break;
                    case 3: setImage("Boton3x.gif");
                    break;
                            
                    }
            }
            else{
                switch(boton){
                    
                    case 1: setImage("Boton1.gif");
                    break;
                    case 2: setImage("Boton2.gif");
                    break;
                    case 3: setImage("Boton3.gif");
                    break;
                            
                    }
            }                
        }
        
        if(Greenfoot.mouseClicked(this)){
            
            CubeTown ctown = (CubeTown)getWorld();
            
            switch(boton){
            
                case 1: ctown.initgame();
                break;
                
                case 2: ctown.setBackground("ayuda.gif");
                        BotonRegresa br= new BotonRegresa();
                        getWorld().addObject(br,505,465);
                break;
                
                case 3: ctown.setBackground("CREDITOS.gif");
                        BotonRegresa brc= new BotonRegresa();
                        getWorld().addObject(brc,505,465);
                break;
            }
               
            
            List<Boton> menu= new ArrayList<Boton>();
            menu=getObjectsInRange(300, Boton.class);
            getWorld().removeObjects(menu);
            getWorld().removeObject(this);
        }
        
    }    
}
