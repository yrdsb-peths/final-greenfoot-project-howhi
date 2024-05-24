import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The animated mole on the title screen.
 * 
 * @author Ho
 * @version May 2024
 */
public class Mole1 extends Actor
{
    GreenfootImage[] mole1Animation = new GreenfootImage[9];    
    
    SimpleTimer animationTimer = new SimpleTimer();
    public Mole1()
    {
        for(int i = 0; i < mole1Animation.length; i++)
        {
            mole1Animation[i] = new GreenfootImage("images/Mole1_Animate/mole1_animate" + i + ".png");
            mole1Animation[i].scale(75, 75);
        }
        
        animationTimer.mark();
        setImage(mole1Animation[0]);
    }
    
    /**
     * Act - do whatever the Mole1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        animateMole1();
    }
    
    int imageIndex = 0;
    public void animateMole1()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        
        animationTimer.mark();
        setImage(mole1Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole1Animation.length;        
    }
}
