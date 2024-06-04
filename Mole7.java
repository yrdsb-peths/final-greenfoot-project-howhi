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
    
    boolean mole7IsAnimating = false;
    public Mole7()
    {
        for(int i = 0; i < mole7Animation.length; i++)
        {
            mole7Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole7Animation[i].scale(100, 75);
        }
        
        animationMole7Timer.mark();
        
        setImage(mole7Animation[0]);
    }
    
    
    public void act()
    {    
        if(mole7IsAnimating)
        {
            dazeMole7();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole7Animation[0])
        {
            mole7IsAnimating = true;
            MyWorld gameWorld = (MyWorld) getWorld();
            gameWorld.increaseScore();
        }
        else if(animationMole7Timer.millisElapsed() > 5000)
        {
            hideMole7();
        }        
    }
    
    public void hideMole7()
    {
        setImage(mole7Animation[8]);
    }    
    
    int imageIndex = 0;
    public void dazeMole7()
    {
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
        }
    }
}