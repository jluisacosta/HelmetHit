import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CascoRojo  extends Bonus
{
    private boolean status=false;
    
    public CascoRojo(){
        setImage("cascoazul.gif");
    }
    public void act() 
    {
        if(status){ setImage("cascorojo.gif"); }
        else{ setImage("cascoazul.gif"); }
        
    }  
    
    public void tenstatus(boolean cascorojo){
    
        status=cascorojo;
    }
}
