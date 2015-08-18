import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Pipe  extends Estructura
{   
    private int posicion; //arriba o abajo= 1 o 2
    
    public Pipe(){
    orientacion=1;
    }
    public Pipe(int ori){
                  
      orientacion=ori;  
    }
    public void act() 
    {
        if(orientacion==2){
        setRotation(180);
        }
    }
    
    public void tenPosicion(int pos){
    
        posicion=pos;
    }
    
    /*public void escupe(){
        int x=0;
        if(orientacion==1){
            x=70;      
        }else if(orientacion==2){
                x=530;
            }
            
         Pink pink=new Pink(orientacion);        
         getWorld().addObject(pink,x,420);
    }*/
}
