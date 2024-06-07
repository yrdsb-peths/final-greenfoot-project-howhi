import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole7 extends Animal
{
    /**
     * Act - do whatever the Mole7 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] mole7Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole7Timer = new SimpleTimer();
    
    SimpleTimer dazeMole7Timer = new SimpleTimer();
    
    public int hideMole7Time;
    
    boolean mole7IsAnimating = false;
    public Mole7()
    {
        for(int i = 0; i < mole7Animation.length; i++)
        {
            mole7Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole7Animation[i].scale(100, 75);
        }
        
        animationMole7Timer.mark();
        hideMole7Time = 3000;
        setImage(mole7Animation[0]);
    }
    
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        if(mole7IsAnimating)
        {
            dazeMole7();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole7Animation[0])
        {
            mole7IsAnimating = true;
            gameWorld.increaseScore();
            if(gameWorld.level % 5 == 0)
            {
                hideMole7Time -= 500;
            }
        }
        else if(animationMole7Timer.millisElapsed() > hideMole7Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole7();
            gameWorld.aMoleIsAnimating = false;
        }        
    }
  
    int imageIndex = 0;
    public void dazeMole7()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole7Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole7Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole7Animation.length;
        dazeMole7Timer.mark();
        
        if(imageIndex == 8)
        {
            mole7IsAnimating = false;
            setImage(mole7Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole7();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
