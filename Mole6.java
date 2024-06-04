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
    }
    
    
    public void act()
    {    
        if(mole6IsAnimating)
        {
            dazeMole6();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole6Animation[0])
        {
            mole6IsAnimating = true;
            MyWorld gameWorld = (MyWorld) getWorld();
            gameWorld.increaseScore();
        }
        else if(animationMole6Timer.millisElapsed() > 5000)
        {
            hideMole6();
        }        
    }
    
    public void hideMole6()
    {
        setImage(mole6Animation[8]);
    }    
    
    int imageIndex = 0;
    public void dazeMole6()
    {
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
        }
    }
}
