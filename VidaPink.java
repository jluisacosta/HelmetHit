import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VidaPink  extends Letrero
{
    public boolean muerto=false;
    
    public VidaPink(int x,int y){
        setImage("vidajp.gif");
    }
    
    public void act() 
    {
        if(muerto){ setImage("vidajpx.gif");}
    }
    
    public void settache(){
        muerto=true;
    }
}
