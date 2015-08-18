import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class HelmetBoy  extends Personaje
{   
    private int insalto;
    private int insalto2;
    private int insaltando;
    private int insaltando2;
    private GreenfootImage[] sder;
    private GreenfootImage[] sizq;
    private boolean saltando=false;
    private int durasalto=0;
    private int pres=22;
    private boolean topaste=false;
    private boolean pateando=false;
    private int inpat=0;
    private boolean inipat=false;
    private boolean inipunt=false;
    protected Puntaje mipuntaje;
    private boolean ponepunto=false;
    private boolean cascorojo=false;
    private CascoRojo casco;
    
    public HelmetBoy(){
        
        super("hb",".gif",9);
        
        int d=1,iz=2;
        sder = new GreenfootImage[5];
        sizq = new GreenfootImage[5];
        
        for(int i=0; i < 5; i++) {
            
            sder[i] = new GreenfootImage("hbs"+ d + i + ".gif");
            sizq[i] = new GreenfootImage("hbs"+ iz + i + ".gif");
        }
        
    }
    
    public void act() 
    { 
        int y=getY(),x=getX();
        
        if(!inipunt){
         inime();
         inipunt=true;            
        }
      
      encuentrasnake();
      checaniveles();
      casco.tenstatus(cascorojo);
      
      if(durasalto<pres){  
                sube();
        }else { 
                durasalto=0;
                saltando=false;
                topaste=false;
            }
            
      if(inipat){ pateando=true;}
            
      if(pateando && inpat<10){
          
          if(!ponepunto && inpat==0){mipuntaje.tenpunto();
                                     revisapuntaje();
                                     ponepunto=false;}
          
          if(direccion==1){setImage("hbpatea1.gif");}
                    else if(direccion==2){setImage("hbpatea2.gif");}
          inpat++;
        
        }else{ inpat=0;
               pateando=false;
               inipat=false;
               }
            
           
      if( super.existebloque() && !pateando){
        super.teletransportate();
        obedece();
        insalto=10;
        insalto2=10;
        insaltando=10;
        insaltando2=10;
      }else{ if(!super.existebloque() && !saltando){
                cae();  }
      }
      
      CubeTown ctown = (CubeTown)getWorld();
      ctown.checagameover();
    }
    
    public void obedece(){
        
        int x=getX(), y=getY();
        
        if(Greenfoot.isKeyDown("right")){
            
                if(pimd<9){
                    this.setImage(imagder[pimd++]);
                }else{ pimd=0; }
                
                if(!super.existetuberia()){
                        x+=5; } 
                this.setLocation(x,y);
                direccion=1;
        }
      else{if(direccion==1){this.setImage(imagder[0]);}
            pimd=0;}
      
      if(Greenfoot.isKeyDown("left")){
          
                if(pimi<9){
                    this.setImage(imagizq[pimi++]);
                }else{ pimi=0; } 
                
                if(!super.existetuberia()){
                    x-=5;
                }
               this.setLocation(x,y);
               direccion=2;
            }
      else{ if(direccion==2){this.setImage(imagizq[0]);}
            pimi=0;}
            
      if(Greenfoot.isKeyDown("up") && Greenfoot.getKey()!="up"){
          
        saltando=true;
                        
        }
      
    }
    
    public void cae(){
        
        int x=getX(), y=getY();
            
        if(direccion==1){
            setImage("hbcae.gif");
        }else if(direccion==2){
            setImage("hbcae2.gif"); }
            
        y+=7;
        
        if(Greenfoot.isKeyDown("right") && insalto > 0 && !topaste){
            setImage("hbcae.gif");
            x+=3; 
            insalto--;
        }
        else if(Greenfoot.isKeyDown("left") && insalto2 > 0 && !topaste){
            setImage("hbcae2.gif");
            x-=3;
            insalto2--;
            }
                    
        setLocation(x,y);
       
    }
    
    public void sube(){
        
       int x=getX(), y=getY();
        
        if(saltando){
        
        if(!topaste && y!=0){
            
                y-=7;
               }else{ durasalto+=2;
                      if(direccion==1){
                        x+=3;}else if(direccion==2){x-=3;}
                    }
        
        if(direccion==1){
            if(durasalto<5){
            setImage(sder[durasalto]); }
        }else if(direccion==2){
            if(durasalto<5){
            setImage(sizq[durasalto]); }
        }
        
        if(Greenfoot.isKeyDown("right") && insaltando > 0 && !topaste){
            setImage(sder[4]);
            x+=3; 
            insaltando--;
        }
        else if(Greenfoot.isKeyDown("left") && insaltando2 > 0 && !topaste){
            setImage(sizq[4]);
            x-=3;
            insaltando2--;
            }
        durasalto++;       
        setLocation(x,y);
       }
    }
    
    public void topaste(){
        topaste=true;
    }
    
    public void checaniveles(){
        
        int x=getX(),y=getY();
        
        if(x>200 && x<250 && y>70 && y<120){ x+=20; }
        else if(x>350 && x<400 && y>70 && y<120){ x-=20; }
             else if(x>50 && x<100 && y>190 && y<240){ x+=20; }
                  else if(x>150 && x<210 && y>190 && y<250){ x-=20; }
                       else if(x>390 && x<450 && y>190 && y<250){ x+=20; }
                            else if(x>500 && x<550 && y>190 && y<240){ x-=20; }
                                 else if(x>200 && x<250 && y>310 && y<360){ x+=20; }
                                      else if(x>350 && x<400 && y>310 && y<360){ x-=20; }
        
        setLocation(x,y);        
        
    }
    
    public void encuentrasnake(){
        
        int x=getX(),y=getY(),lt=6;
        boolean s=false;
        Actor snakevul;
        
        if(direccion==2){
            lt=-6; 
        }
        List<SnakeBoy> listasb=this.getObjectsAtOffset(lt,0,SnakeBoy.class);
        
        if(!listasb.isEmpty()){
            SnakeBoy sv=listasb.get(0);
            s=sv.getvul();
           
            if(s){                
                    if(direccion==1){setImage("hbpatea1.gif");}
                    else if(direccion==2){setImage("hbpatea2.gif");}                      
                    sv.setpateado();
                    sv.setdirpateado(direccion); 
                    inipat=true;   
                }
        }
    }
    
    public void inime(){
        
        mipuntaje= new Puntaje();
        getWorld().addObject(mipuntaje,90,465);
        casco= new CascoRojo();
        getWorld().addObject(casco,375,465);
    
    }
    
    public boolean getcasco(){
        return(cascorojo);
    }
    
    public void tencascorojo(){
        cascorojo=true;
    }
    
    public void quitatecascorojo(){
        cascorojo=false;
    }
    
    public Puntaje getpuntaje(){
        return(mipuntaje);
    }
    
    public void revisapuntaje(){
       
        CubeTown ctown = (CubeTown)getWorld();
        ctown.mandasnake(mipuntaje.getvalor(1),mipuntaje.getvalor(2),mipuntaje.getvalor(3));
        
    }
    
}
