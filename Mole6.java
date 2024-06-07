import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole6 extends Animal
{
    /**
     * Act - do whatever the Mole6 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] mole6Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole6Timer = new SimpleTimer();
    
    SimpleTimer dazeMole6Timer = new SimpleTimer();
    
    public int hideMole6Time;
    
    boolean mole6IsAnimating = false;
    public Mole6()
    {
        for(int i = 0; i < mole6Animation.length; i++)
        {
            mole6Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole6Animation[i].scale(100, 75);
        }
        
        animationMole6Timer.mark();
        setImage(mole6Animation[0]);
        MyWorld gameWorld = new MyWorld();
        hideMole6Time = 3000 - (gameWorld.level * 500);
    }
    
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        if(mole6IsAnimating)
        {
            dazeMole6();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole6Animation[0])
        {
            mole6IsAnimating = true;
            gameWorld.increaseScore();

        }
        else if(animationMole6Timer.millisElapsed() > hideMole6Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole6();
            animationMole6Timer.mark();
            gameWorld.aMoleIsAnimating = false;
        }        
    }
 
    int imageIndex = 0;
    public void dazeMole6()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole6Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole6Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole6Animation.length;
        dazeMole6Timer.mark();
        
        if(imageIndex == 8)
        {
            mole6IsAnimating = false;
            setImage(mole6Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole6();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
