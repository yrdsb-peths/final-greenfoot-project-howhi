import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The animated mole on the title screen.
 * 
 * @author Ho
 * @version May 2024
 */
public class Mole1 extends Actor
{
    GreenfootImage[] mole1Animation1 = new GreenfootImage[3];
    GreenfootImage[] mole1Animation2 = new GreenfootImage[3];
    GreenfootImage[] mole1Animation3 = new GreenfootImage[3];
    
    
    SimpleTimer animationTimer = new SimpleTimer();
    public Mole1()
    {
        for(int i = 0; i < mole1Animation1.length; i++)
        {
            mole1Animation1[i] = new GreenfootImage("images/Mole_Animate(1)/tile00" + i + ".png");
            mole1Animation1[i].scale(100, 100);
        }
        
        for(int i = 0; i < mole1Animation2.length; i++)
        {
            mole1Animation2[i] = new GreenfootImage("images/Mole_Animate(2)/tile00" + i + ".png");
            mole1Animation2[i].scale(100, 100);
        }
        
        for(int i = 0; i < mole1Animation3.length; i++)
        {
            mole1Animation3[i] = new GreenfootImage("images/Mole_Animate(3)/tile00" + i + ".png");
            mole1Animation3[i].scale(100, 100);
        }
        
        animationTimer.mark();
        setImage(mole1Animation1[0]);
    }
    
    /**
     * Act - do whatever the Mole1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    int imageIndex = 0;
    public void animateMole1()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        
        animationTimer.mark();
        {
            setImage(mole1Animation1[imageIndex]);
            imageIndex = (imageIndex + 1) % mole1Animation1.length;
        }
        
    }
}
