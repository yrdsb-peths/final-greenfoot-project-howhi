import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny6 extends Animal
{
    GreenfootSound bugsBunnyCutItOut6 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    GreenfootImage[] bugsBunny6Animation = new GreenfootImage[3];
    
    
    SimpleTimer bugsBunnyTimer6 = new SimpleTimer();
    boolean bugsBunny6IsAnimating = false;
    public BugsBunny6()
    {
        for(int i = 0; i < bugsBunny6Animation.length; i++)
        {
            bugsBunny6Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny6Animation[i].scale(100, 100);
        }
        
        GreenfootImage bugsBunnyStanding6 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding6.scale(100, 100);
        bugsBunnyTimer6.mark();        
        setImage(bugsBunnyStanding6);
    }
    
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunny6IsAnimating == true)
        {
            animateBugsBunny6();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            bugsBunnyCutItOut6.play();
            gameWorld.decreaseScoreBy5();
            bugsBunny6IsAnimating = true;
        }
        else if(bugsBunnyTimer6.millisElapsed() > 2000)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole7();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void animateBugsBunny6()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(bugsBunnyTimer6.millisElapsed() < 100)
        {
            return;
        }
        setImage(bugsBunny6Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % bugsBunny6Animation.length;
        bugsBunnyTimer6.mark();
        
        if(imageIndex == 2)
        {
            bugsBunny6IsAnimating = false;
            setImage(bugsBunny6Animation[2]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole7();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
