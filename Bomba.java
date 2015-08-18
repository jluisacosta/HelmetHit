import greenfoot.*; 
import java.util.*; 

public class Bomba  extends Item
{
    private int tiempob=13;
    
    public Bomba(){
        setImage("bomba.gif");
    }
    public void act() 
    {
        super.act();
        if(explota){if(tiempob>0){
                        if(tiempob%2 == 0){
                            getWorld().setBackground("bomb.gif");
                        }else{getWorld().setBackground("cubetown.jpg");}
                        tiempob--;
                    }else{ explota();}
                }
    }    
    
    public void explota(){
        
        List<SnakeBoy> listsb= this.getWorld().getObjects(SnakeBoy.class);
        if(!listsb.isEmpty()){
            
            Iterator<SnakeBoy> snakes=listsb.iterator();
            
            do{
                SnakeBoy sb=snakes.next();
                sb.setvul();
            }while(snakes.hasNext());
                
                getWorld().removeObject(this);
        }
    }
}
