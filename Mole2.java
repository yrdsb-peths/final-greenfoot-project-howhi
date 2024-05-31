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
            mole2Animation[i].scale(100, 75);
        }
        
        setImage(mole2Animation[8]);
        animationMole2Timer.mark();
    }
    
    
    public void act()
    {        
        if(animationMole2Timer.millisElapsed() > 5000)
        {
            manifestMole2();
            animationMole2Timer.mark();
        }
        
        if(animationMole2Timer.millisElapsed() > 5000)
        {
            hideMole2();
            animationMole2Timer.mark();
        }
        else if(Greenfoot.mouseClicked(this))
        {
            dazedMole2();
        }
    }
    
    int imageIndex = 0;
    
    public void hideMole2()
    {
        setImage(mole2Animation[8]);
    }
    public void manifestMole2()
    {
        setImage(mole2Animation[0]);
    }
    
    public void dazedMole2()
    {       
        animationMole2Timer.mark();
        
        for(int i = 0; i < mole2Animation.length; i++)
        {
            setImage(mole2Animation[imageIndex]);
            imageIndex = (imageIndex + 1) % mole2Animation.length; 
            if(animationMole2Timer.millisElapsed() == 100)
            {
                animationMole2Timer.mark();
                return;
            }            
        }
               
    }
}
