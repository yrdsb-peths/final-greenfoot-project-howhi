import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny5 extends Animal
{
    GreenfootSound bugsBunnyCutItOut5 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    GreenfootImage[] bugsBunny5Animation = new GreenfootImage[3];
    
    
    SimpleTimer bugsBunnyTimer5 = new SimpleTimer();
    boolean bugsBunny5IsAnimating = false;
    public BugsBunny5()
    {
        for(int i = 0; i < bugsBunny5Animation.length; i++)
        {
            bugsBunny5Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny5Animation[i].scale(100, 100);
        }
        
        GreenfootImage bugsBunnyStanding5 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding5.scale(100, 100);
        bugsBunnyTimer5.mark();        
        setImage(bugsBunnyStanding5);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunny5IsAnimating == true)
        {
            animateBugsBunny5();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyCutItOut5.play();
            gameWorld.decreaseScoreBy5();
            bugsBunny5IsAnimating = true;
        }
        else if(bugsBunnyTimer5.millisElapsed() > 2000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole6();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny5()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer5.millisElapsed() < 300)
        {
            return;
        }
        setImage(bugsBunny5Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunny5Animation.length;
        bugsBunnyTimer5.mark();
        
        if(imageIndex == 2)
        {
            bugsBunny5IsAnimating = false;
            setImage(bugsBunny5Animation[2]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole6();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
