import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny2 extends Animal
{
    GreenfootSound bugsBunnyCutItOut2 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    GreenfootImage[] bugsBunny2Animation = new GreenfootImage[3];
    
    
    SimpleTimer bugsBunnyTimer2 = new SimpleTimer();
    boolean bugsBunny2IsAnimating = false;
    public BugsBunny2()
    {
        for(int i = 0; i < bugsBunny2Animation.length; i++)
        {
            bugsBunny2Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny2Animation[i].scale(100, 100);
        }
        
        GreenfootImage bugsBunnyStanding2 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding2.scale(100, 100);
        bugsBunnyTimer2.mark();        
        setImage(bugsBunnyStanding2);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunny2IsAnimating == true)
        {
            animateBugsBunny2();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyCutItOut2.play();
            gameWorld.decreaseScoreBy5();
            bugsBunny2IsAnimating = true;
        }
        else if(bugsBunnyTimer2.millisElapsed() > 2000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole3();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny2()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer2.millisElapsed() < 100)
        {
            return;
        }
        setImage(bugsBunny2Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunny2Animation.length;
        bugsBunnyTimer2.mark();
        
        if(imageIndex == 2)
        {
            bugsBunny2IsAnimating = false;
            setImage(bugsBunny2Animation[2]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole3();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
