import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Digito  extends Actor
{
    private GreenfootImage[] digitos;
    private int cifra=0;
    
    public Digito(){
    
        digitos = new GreenfootImage[10];
        
        for(int i=0; i < 10; i++) {
            
            digitos[i] = new GreenfootImage(i+".gif");
        }
        setImage(digitos[cifra]);
    }
    
    public void act() 
    {
        setImage(digitos[cifra]);
    }   
    
    public void tencifra(int c){
        cifra=c;
    }
    
    public int getcifra(){
        return(cifra);    
    }
}
