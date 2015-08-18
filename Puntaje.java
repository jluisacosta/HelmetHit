import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Puntaje  extends Letrero
{
    private boolean punto=false;
    private int valor1=0;
    private int valor2=0;
    private int valor3=0;
    private Digito c1;
    private Digito c2;
    private Digito c3;
    private Digito c4;   
    private boolean ini=false;
    
    
    public Puntaje(){

        setImage("puntaje.gif");               
    }
    
    public void act() 
    {
        if(!ini){
        
            inicializate();
            ini=true;
        }
        if(punto)
        {   
            if(valor1<9){
                c2.tencifra(++valor1);
               }else{ valor1=0;
                      c2.tencifra(valor1);
                      if(valor2<9){
                          c3.tencifra(++valor2);
                         }else{ valor2=0;
                                c3.tencifra(valor2);
                                if(valor3<9){
                                    c4.tencifra(++valor3);
                                   }else{ valor3=0;
                                          c4.tencifra(valor3);}
                               }
                      }
            punto=false;
        }
        
    }   
    
    public void tenpunto(){
        punto=true;
    }
    
    public void inicializate(){
        
        int x=getX(),y=getY();
        
        x+=105;
        
            c4= new Digito();
            getWorld().addObject(c4,x,y);
            x+=40;
            c3= new Digito();
            getWorld().addObject(c3,x,y);
            x+=40;
            c2= new Digito();
            getWorld().addObject(c2,x,y);
            x+=40;
            c1= new Digito();
            getWorld().addObject(c1,x,y);
        
    }
    
    public int getcifra2(){
        return(valor2);
    }
    
    public int getvalor(int v){
        
        switch(v){
            
            case 1: return(valor1);
            case 2: return(valor2);
            case 3: return(valor3);
        }
        
        return(valor1);
    }
    
}
