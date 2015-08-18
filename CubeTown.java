import greenfoot.*;
import java.util.*;
/**
 * @author (José Luis Acosta Zamora) 
 * @version (v 1.0)
 */
public class CubeTown  extends World
{
    
    public CubeTown(){ 
        super(600, 500, 1);
        Greenfoot.setSpeed(42);
        init();
    }
    
    public void act(){
        
    }
    
    public void init(){
        
        int x=300,y=230;
        
        List<Puntaje> listpun=getObjects(Puntaje.class);
            removeObjects(listpun);
        List<Digito> listdi=getObjects(Digito.class);
            removeObjects(listdi);
        
        setBackground("portadahh.jpg");
        
        for(int i=1;i<4;i++){
          
                Boton b= new Boton(i);
                addObject(b,x,y);
                y+=70;
            }
    }
    
    public void initgame(){
        
        int x=25;
        setBackground("cubetown.jpg");
        Pipe p1= new Pipe();
        p1.tenPosicion(1);
        addObject(p1,24,39);
        Pipe p2= new Pipe();
        p2.tenPosicion(2);
        addObject(p2,24,399);
        Pipe p3= new Pipe(2);
        p3.tenPosicion(1);
        addObject(p3,574,39);
        Pipe p4= new Pipe(2);
        p4.tenPosicion(2);
        addObject(p4,574,399);
        
        for(int i=0;i<12;i++){
            if(x!=275 && x!=325){
                BloqueAzul ca= new BloqueAzul();
                addObject(ca,x,95);
                BloqueAzul ca2= new BloqueAzul();
                addObject(ca2,x,335);
        }
        x+=50;
        }
        x=25;
        for(int i=0;i<4;i++){
            
                BloqueAzul ca= new BloqueAzul();
                addObject(ca,x,215);
        
                if(i==1){ x=475; }
                x+=50;
        }
        x=180;
        for(int i=0;i<5;i++){ 
            BloqueRojo cr= new BloqueRojo();
            addObject(cr,x,220);
            x+=60;
            }
            
        HelmetBoy jugador= new HelmetBoy();
        addObject(jugador,20,292);
        
     
        Pink o1= new Pink(2,440,465);
        addObject(o1,250,420);
        
        Pink o2= new Pink(1,485,465);
        addObject(o2,350,420);
        
        Pink o3= new Pink(2,530,465);
        addObject(o3,550,420);
        
        Pink o4= new Pink(1,575,465);
        addObject(o4,50,420);
        
        SnakeBoy v1= new SnakeBoy(2);
        addObject(v1,550,55);
        
        SnakeBoy v2= new SnakeBoy();
        addObject(v2,50,55);
        
        MagicHat mh= new MagicHat();
        addObject(mh,300,330);
        
    }
    
    public void checagameover(){
    
        List<Pink> listp=getObjects(Pink.class);
        if(listp.isEmpty()){
            
            List<HelmetBoy> listhb=getObjects(HelmetBoy.class);
            removeObjects(listhb);
            List<Pipe> listpi=getObjects(Pipe.class);
            removeObjects(listpi);
            List<SnakeBoy> listsb=getObjects(SnakeBoy.class);
            removeObjects(listsb);
            List<Cubo> listc=getObjects(Cubo.class);
            removeObjects(listc);
            List<VidaPink> listvp=getObjects(VidaPink.class);
            removeObjects(listvp);
            List<CascoRojo> listcr=getObjects(CascoRojo.class);
            removeObjects(listcr);
            List<MagicHat> listmh=getObjects(MagicHat.class);
            removeObjects(listmh);
            
            setBackground("gameover.gif");
            BotonRegresa regreso= new BotonRegresa();
            addObject(regreso,505,465);
        }   
    }
    
    public void mandasnake(int v1,int v2,int v3){
        
        int xr=0;
            
            if(v1%2==0){
                
                SnakeBoy s1= new SnakeBoy();
                      addObject(s1,50,55);
                    SnakeBoy s2= new SnakeBoy(2);
                      addObject(s2,550,55);
                /*do{
                    xr=Greenfoot.getRandomNumber(3);
                  }while(xr!=1 && xr!=2);                  
                 
                  
                  if(xr==1){
                      SnakeBoy sb= new SnakeBoy();
                      addObject(sb,50,55);
                    }else if(xr==2){
                        SnakeBoy sb2= new SnakeBoy(2);
                      addObject(sb2,550,55); }  */
                      
            }else{if(v1%4==1){
            
                    do{
                    xr=Greenfoot.getRandomNumber(3);
                  }while(xr!=1 && xr!=2);                  
                 
                  
                  if(xr==1){
                      SnakeBoy sb= new SnakeBoy();
                      addObject(sb,50,55);
                    }else if(xr==2){
                        SnakeBoy sb2= new SnakeBoy(2);
                      addObject(sb2,550,55); }
                    }
                    /*SnakeBoy s1= new SnakeBoy();
                      addObject(s1,50,55);
                    SnakeBoy s2= new SnakeBoy(2);
                      addObject(s2,550,55);*/
                    }            
    }
    
}
