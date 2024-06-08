import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BugsBunny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BugsBunny extends Animal
{
    GreenfootImage[] bugsBunnyAnimation = new GreenfootImage[3];
    
    SimpleTimer bugsBunnyTimer = new SimpleTimer();
    boolean bugsBunnyIsAnimating = false;
    public BugsBunny()
    {
        for(int i = 0; i < bugsBunnyAnimation.length; i++)
        {
            bugsBunnyAnimation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunnyAnimation[i].scale(100, 75);
        }
        
        bugsBunnyTimer.mark();        
        setImage(bugsBunnyAnimation[0]);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(bugsBunnyIsAnimating == true)
        {
            animateBugsBunny();
        }
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyIsAnimating = true;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer.millisElapsed() < 100)
        {
            return;
        }
        setImage(bugsBunnyAnimation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunnyAnimation.length;
        bugsBunnyTimer.mark();
    }
}
