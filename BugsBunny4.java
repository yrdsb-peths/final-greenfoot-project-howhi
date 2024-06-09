import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny4 extends Animal
{
    GreenfootSound bugsBunnyCutItOut4 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    GreenfootImage[] bugsBunny4Animation = new GreenfootImage[3];
    
    
    SimpleTimer bugsBunnyTimer4 = new SimpleTimer();
    boolean bugsBunny4IsAnimating = false;
    public BugsBunny4()
    {
        for(int i = 0; i < bugsBunny4Animation.length; i++)
        {
            bugsBunny4Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny4Animation[i].scale(100, 100);
        }
        
        GreenfootImage bugsBunnyStanding4 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding4.scale(100, 100);
        bugsBunnyTimer4.mark();        
        setImage(bugsBunnyStanding4);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunny4IsAnimating == true)
        {
            animateBugsBunny4();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyCutItOut4.play();
            gameWorld.decreaseScoreBy5();
            bugsBunny4IsAnimating = true;
        }
        else if(bugsBunnyTimer4.millisElapsed() > 2000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole5();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny4()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer4.millisElapsed() < 100)
        {
            return;
        }
        setImage(bugsBunny4Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunny4Animation.length;
        bugsBunnyTimer4.mark();
        
        if(imageIndex == 2)
        {
            bugsBunny4IsAnimating = false;
            setImage(bugsBunny4Animation[2]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole5();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
