import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Cubo  extends Estructura
{   
    protected int colordecubo;
    private boolean cambio=false;
    
    public Cubo(){}
    public void act() 
    {   
        int radio=0;
        
        if(colordecubo==1){radio=35;}
        else if(colordecubo==2){radio=42;}
        
        List<HelmetBoy> listah= getObjectsInRange(radio,HelmetBoy.class);
        if(!listah.isEmpty()){
            HelmetBoy hb=listah.get(0);
            hb.topaste();
            
            if(colordecubo==1){
                setImage("cuboazulx.gif"); 
                cambio=true;}
                else if(colordecubo==2){
                if(hb.getcasco()){
                setImage("cuborojox.gif");
                cambio=true;
                }
                       }
            }else{
                if(cambio==true){
                    
                if(colordecubo==1){
                    setImage("cuboazul.gif"); }
                else if(colordecubo==2){
                    setImage("cuborojo.gif");
                    }
                 cambio=false;
                }
            }
        
        }
        
        public boolean getcambio(){
            return(cambio);
        }
    }
