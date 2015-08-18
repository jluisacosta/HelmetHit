import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public abstract class Personaje  extends Actor
{
    protected GreenfootImage[] imagder;
    protected GreenfootImage[] imagizq;
    protected int pimd = 0;
    protected int pimi = 0;
    protected int direccion;
    
    public Personaje(String nomper, String ext, int numimg)
    {
        int d=1,iz=2;
        imagder = new GreenfootImage[numimg];
        imagizq = new GreenfootImage[numimg];
        
        for(int i=0; i < numimg; i++) {
            
            imagder[i] = new GreenfootImage(nomper+ d + i + ext);
            imagizq[i] = new GreenfootImage(nomper+ iz + i + ext);
        }
        setImage(imagder[pimd]);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public boolean existebloque(){
        int y=getY(),ld=-6,ylim=405,limb=20;
        Actor ba1,ba2;
        boolean r=false;
        
        if(this instanceof SnakeBoy){ ylim=408; limb=17;}
        
        if(direccion==2)
        { ld=6; }
        
        ba2=this.getOneObjectAtOffset(ld,limb,BloqueRojo.class);
        ba1=this.getOneObjectAtOffset(ld,limb,BloqueAzul.class);
        
        if(ba2 instanceof BloqueRojo || ba1 instanceof BloqueAzul || y>ylim ){
            r=true;
        }else{ r=false;}
        
        return(r);
       
    }
    
    public boolean existetuberia(){
        int x=getX(),lt=12;
        boolean r=false;
        Actor tubo;
        
        if(direccion==2){
            lt=-12; 
        }
        tubo=this.getOneObjectAtOffset(lt,0,Pipe.class);
        
        if(tubo instanceof Pipe){
            r=true;
        }else{ r=false; }
        
        return (r);
    }
    
    public void teletransportate(){
        int x=getX(), y=getY();
        
        if(x<5 && direccion==2){
            
            this.setLocation(590,y);
        }else if(x>590 && direccion==1){
            
            this.setLocation(10,y);
        }
    }
    
    public int getdireccion(){
        return(direccion);
    }
    
    
       
}
