import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pink  extends Personaje
{
    private int pimgp=0;
    private boolean muerte=false;
    private int agoniza=0;
    private VidaPink vp;
    private int xvp;
    private int yvp;
    private boolean ini=false;

    public Pink(){
        
        super("jp",".gif",5);
        direccion=1;
    }
    
    public Pink(int d,int x,int y){
        
        super("jp",".gif",5);
        direccion=d;
        xvp=x;
        yvp=y;        
    }
    
    public void act() 
    {        
        if(!ini){
            inivida();
            ini=true;
        }
        
        if(!muerte){
                
            muevete();            
            
        }else{ vp.settache();
                muerete();}
    }
    
    public void muevete(){
        
        int x=getX(),y=getY();
        
        if (direccion == 1){
        
        if(this.existetuberia())
            {   direccion=2; }
            
            if(pimgp<5){
                    this.setImage(imagder[pimgp++]);
                }else{ pimgp=0; }
            setLocation(++x,y);
            
        }else if(direccion==2){
            
            if(this.existetuberia())
            {   direccion=1; }
            
            if(pimgp<5){
                    this.setImage(imagizq[pimgp++]);
                }else{ pimgp=0; }
            setLocation(--x,y);
            }
                
    }
    
    public void muerete(){
        
        if(agoniza<20){ if(agoniza<10)
                                {setImage("pinkagoniza.gif");}
                                else{setImage("pinkmuere.gif");}
                                agoniza++;
                            }else{ getWorld().removeObject(this); }        
    }
    
    public void setmuerte(){
        muerte=true;
    }
    
    public void inivida(){
        
        vp= new VidaPink(xvp,yvp);
        getWorld().addObject(vp,xvp,yvp);
    }
    
}
