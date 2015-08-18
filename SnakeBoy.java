import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SnakeBoy  extends Personaje
{
    private int pimgsn=0;
    private int inis=0;
    private boolean saltando=false;
    private int velocidad=2;
    private boolean vul=false;
    private boolean pateado=false;
    private int dirpateado;
    private int np=0;
    
    public SnakeBoy(){
        super("snake",".gif",5);
        direccion=1;
    }

    public SnakeBoy(int d){
        super("snake",".gif",5);
        direccion=d;
    }

    public void act()
    {   
        if(pateado){
            int xp=getX(),yp=getY();
            
            if(np<8){
            
                    if(dirpateado==1){
                                xp+=15;}
                    else if(dirpateado==2){xp-=15;}
                    
            np++;
            setLocation(xp,yp);
           }else{getWorld().removeObject(this);}
        }
            
        if(!vul){
        
        vul=quedavulnerable();
        boolean v=super.existebloque();
        encuentraigual();
        matapink();
        quitacascoahelmet();
        super.teletransportate();
        
        if(direccion==2){
        if(getX()>100 && getX()<150  && !v){saltando=true; v=true; }
        }else if(direccion==1){ if( getX()>450 && getX()<500 && !v){saltando=true; v=true; } }
                                         
            
        if(v){
            
            int x=getX(), y=getY();
            
        if(saltando){
            
            if(inis<4){
            
            y-=5;
            
            if(direccion==1){
            setImage("snakecaeder.gif");x+=3;
            }else{ setImage("snakecaeizq.gif");x-=3; }
            inis++;
            }else{saltando=false;
                    inis=0;} 
        }
                
        if (direccion == 1){
            
            if(this.existetuberia())
            {   direccion=2; }
            
            if(pimgsn<5){
                    this.setImage(imagder[pimgsn++]);
                }else{ pimgsn=0; }
                x+=velocidad;
            setLocation(x,y);
            
        }else if(direccion==2){
            
            if(this.existetuberia())
            {   direccion=1; }
            
            if(pimgsn<5){
                    this.setImage(imagizq[pimgsn++]);
                }else{ pimgsn=0; }
            x-=velocidad;
            setLocation(x,y);
            
            }
        }else{ cae();}
        
    }else {if(np<5){ Greenfoot.setSpeed(42);setImage("snakecaido"+direccion+".gif");}
            else{setImage("nube.gif");}
            }
        
    }
    
    public void cae(){
        
        int x=getX(),y=getY();
        
        y+=7;
        
        if(direccion==1){
            setImage("snakecaeder.gif");
            x+=2;}else{setImage("snakecaeizq.gif");
                        x-=2;}
            
        setLocation(x,y);
        
    }
    
    public void encuentraigual(){
        
        int x=getX(),lt=5;
        boolean r=false;
        Actor sb;
        
        if(direccion==2){
            lt=-5; 
        }
        sb=this.getOneObjectAtOffset(lt,0,SnakeBoy.class);
        
        if(sb instanceof SnakeBoy){
            r=true;
        }else{ r=false; }
        
        if(r && x>20 && x<580){ 
                if(direccion==1){
                direccion=2;}else{direccion=1;}
            }
    }
    
    public boolean quedavulnerable(){
        
        int y=getY(),x=getX();
        boolean r=false;
        List<Cubo> listac= getObjectsAtOffset(0,17,Cubo.class);
        if(!listac.isEmpty()){
            Cubo c=listac.get(0);
            return(c.getcambio());
        }
        
        return(r);
    }
    
    public boolean getvul(){
        return(vul);
    }
    
    public void setpateado(){
        pateado=true;
    }
    
    public void setdirpateado(int d){
        dirpateado=d;
    }
    
    public void setvul(){
        vul=true;
    }
    
    public void matapink(){
        
        int y=getY(),x=getX(),r=6;
        
        if(direccion==2){r=-6;}
        
        List<Pink> listap= getObjectsAtOffset(r,0,Pink.class);
        if(!listap.isEmpty()){
            Pink presa=listap.get(0);
            presa.setmuerte();
            vul=true;
        }
    }
    
    public void quitacascoahelmet(){
        
        int y=getY(),x=getX(),r=6;
        
        if(direccion==2){r=-6;}
        
        List<HelmetBoy> listah= getObjectsAtOffset(r,0,HelmetBoy.class);
        if(!listah.isEmpty()){
            HelmetBoy h=listah.get(0);
            h.quitatecascorojo();
        }
    }
}
