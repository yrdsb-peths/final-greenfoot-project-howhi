import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny3 extends Animal
{
    GreenfootSound bugsBunnyCutItOut3 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    GreenfootImage[] bugsBunny3Animation = new GreenfootImage[3];
    
    
    SimpleTimer bugsBunnyTimer3 = new SimpleTimer();
    boolean bugsBunny3IsAnimating;
    public BugsBunny3()
    {
        for(int i = 0; i < bugsBunny3Animation.length; i++)
        {
            bugsBunny3Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny3Animation[i].scale(100, 100);
        }
        bugsBunny3IsAnimating = false;
        
        GreenfootImage bugsBunnyStanding3 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding3.scale(100, 100);
        bugsBunnyTimer3.mark();        
        setImage(bugsBunnyStanding3);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunny3IsAnimating == true)
        {
            animateBugsBunny3();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyCutItOut3.play();
            gameWorld.decreaseScoreBy3();
            bugsBunny3IsAnimating = true;
        }
        else if(bugsBunnyTimer3.millisElapsed() > 2000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole4();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny3()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer3.millisElapsed() < 300)
        {
            return;
        }
        setImage(bugsBunny3Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunny3Animation.length;
        bugsBunnyTimer3.mark();
        
        if(imageIndex == 2)
        {
            bugsBunny3IsAnimating = false;
            setImage(bugsBunny3Animation[2]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole4();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
