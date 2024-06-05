import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole3 extends Animal
{
    /**
     * Act - do whatever the Mole3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] mole3Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole3Timer = new SimpleTimer();
    
    SimpleTimer dazeMole3Timer = new SimpleTimer();
    
    boolean mole3IsAnimating = false;
    public Mole3()
    {
        for(int i = 0; i < mole3Animation.length; i++)
        {
            mole3Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole3Animation[i].scale(100, 75);
        }
        
        animationMole3Timer.mark();
        
        setImage(mole3Animation[0]);
    }
    
    
    public void act()
    {    
        if(mole3IsAnimating)
        {
            dazeMole3();
        }
        MyWorld gameWorld = (MyWorld) getWorld();
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole3Animation[0])
        {
            mole3IsAnimating = true;
            gameWorld.increaseScore();
        }
        else if(animationMole3Timer.millisElapsed() > 5000)
        {
            gameWorld.removeObject(this);
        }        
    }
    
    int imageIndex = 0;
    public void dazeMole3()
    {
        if(dazeMole3Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole3Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole3Animation.length;
        dazeMole3Timer.mark();
        
        if(imageIndex == 8)
        {
            mole3IsAnimating = false;
            setImage(mole3Animation[8]);
        }
    }
}
