import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int speed=7; //incremento do movimento lateral
    private int verticalSpeed=0;//incremento do movimento vertical
    private int acceleration=2;
    private int jumpStrenght=10;
    
    public void act() {
        checkKeys();
        checkFall();
    }
    /**se o jogador presionar -> mexe para a direita, se presionar
     * <- mexe para a esquerda e inverte a imagem 
     */ 
    public void  checkKeys(){
        if (Greenfoot.isKeyDown("left")){
            getImage().mirrorHorizontally();
            setLocation(getX()-speed, getY());
        }
         if (Greenfoot.isKeyDown("right")){
            
            setLocation(getX()+speed, getY());
        }
        if(Greenfoot.isKeyDown("up")){
            jump();
        }
    }
    public void fall(){
        setLocation(getX(), getY()+ verticalSpeed);
        verticalSpeed +=acceleration;
    }
    public boolean onGround(){
        Actor under= getOneObjectAtOffset(0, getImage().getHeight() /2+1, Ground.class );
        return under!=null;
    }
    public void checkFall(){
        if (onGround()){
            verticalSpeed=0;
        }
        else {
            fall();
        }
    }
    public void jump(){
        verticalSpeed=-jumpStrenght;
        fall();
    }
}
    
    

