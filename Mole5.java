import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole5 extends Animal
{
    /**
     * Act - do whatever the Mole5 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] mole5Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole5Timer = new SimpleTimer();
    
    SimpleTimer dazeMole5Timer = new SimpleTimer();
    
    boolean mole5IsAnimating = false;
    public Mole5()
    {
        for(int i = 0; i < mole5Animation.length; i++)
        {
            mole5Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole5Animation[i].scale(100, 75);
        }
        
        animationMole5Timer.mark();
        
        setImage(mole5Animation[0]);
    }
    
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        if(mole5IsAnimating)
        {
            dazeMole5();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole5Animation[0])
        {
            mole5IsAnimating = true;
            gameWorld.increaseScore();
        }
        else if(animationMole5Timer.millisElapsed() > 5000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole5();
            gameWorld.aMoleIsAnimating = false;
        }        
    }
    
    int imageIndex = 0;
    public void dazeMole5()
    {
        if(dazeMole5Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole5Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole5Animation.length;
        dazeMole5Timer.mark();
        
        if(imageIndex == 8)
        {
            mole5IsAnimating = false;
            setImage(mole5Animation[8]);
            MyWorld gameWorld = (MyWorld) getWorld();
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole5();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
