import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole2 extends Animal
{
    /**
     * Act - do whatever the Mole2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootSound mole2Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    GreenfootImage[] mole2Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole2Timer = new SimpleTimer();
    
    SimpleTimer dazeMole2Timer = new SimpleTimer();
    
    public int hideMole2Time;
    
    boolean mole2IsAnimating = false;
    public Mole2()
    {
        for(int i = 0; i < mole2Animation.length; i++)
        {
            mole2Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole2Animation[i].scale(100, 75);
        }
        
        animationMole2Timer.mark();
        setImage(mole2Animation[0]);        
    }
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        hideMole2Time = 3000 - (gameWorld.level * 500);
        if(mole2IsAnimating)
        {
            dazeMole2();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole2Animation[0])
        {
            mole2Clicked.play();
            gameWorld.increaseScore();
            mole2IsAnimating = true;
        }
        else if(animationMole2Timer.millisElapsed() > hideMole2Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole2();
            gameWorld.aMoleIsAnimating = false;
        }
    }  
    
    int imageIndex = 0;
    public void dazeMole2()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole2Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole2Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole2Animation.length;
        dazeMole2Timer.mark();
        
        if(imageIndex == 8)
        {
            mole2IsAnimating = false;
            setImage(mole2Animation[8]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole2();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
