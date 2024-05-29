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
    
    GreenfootImage[] mole2Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole2Timer = new SimpleTimer();
    
    MyWorld gameWorld = (MyWorld) getWorld();
    public Mole2()
    {
        for(int i = 0; i < mole2Animation.length; i++)
        {
            mole2Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole2Animation[i].scale(100, 100);
        }
        
        setImage(mole2Animation[8]);
        animationMole2Timer.mark();
    }
    
    
    public void act()
    {        
        if(gameWorld.diceRoll == 0)
        {
            manifestMole2();
        }
        
        if(animationMole2Timer.millisElapsed() < 5000)
        {
            setImage(mole2Animation[8]);
        }
        else if(Greenfoot.mouseClicked(this))
        {
            dazedMole2();
            setImage(mole2Animation[8]);
        }
    }
    
    int imageIndex = 0;
    
    public void manifestMole2()
    {
        setImage(mole2Animation[0]);
        animationMole2Timer.mark();
    }
    
    public void dazedMole2()
    {
        if(animationMole2Timer.millisElapsed() == 100)
        {
            return;
        }        
        
        animationMole2Timer.mark();
        setImage(mole2Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole2Animation.length;        
    }
}
