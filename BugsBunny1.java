import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny1 extends Animal
{
    GreenfootSound bugsBunnyCutItOut1 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    GreenfootImage[] bugsBunny1Animation = new GreenfootImage[3];
    
    
    SimpleTimer bugsBunnyTimer1 = new SimpleTimer();
    boolean bugsBunny1IsAnimating = false;
    public BugsBunny1()
    {
        for(int i = 0; i < bugsBunny1Animation.length; i++)
        {
            bugsBunny1Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny1Animation[i].scale(100, 100);
        }
        
        GreenfootImage bugsBunnyStanding1 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding1.scale(100, 100);
        bugsBunnyTimer1.mark();        
        setImage(bugsBunnyStanding1);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunny1IsAnimating == true)
        {
            animateBugsBunny1();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyCutItOut1.play();
            gameWorld.decreaseScoreBy5();
            bugsBunny1IsAnimating = true;
        }
        else if(bugsBunnyTimer1.millisElapsed() > 2000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole2();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny1()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer1.millisElapsed() < 100)
        {
            return;
        }
        setImage(bugsBunny1Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunny1Animation.length;
        bugsBunnyTimer1.mark();
        
        if(imageIndex == 2)
        {
            bugsBunny1IsAnimating = false;
            setImage(bugsBunny1Animation[2]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole2();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
