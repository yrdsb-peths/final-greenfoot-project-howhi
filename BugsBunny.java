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
    public BugsBunny()
    {
        for(int i = 0; i < bugsBunnyAnimation.length; i++)
        {
            bugsBunnyAnimation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunnyAnimation[i].scale(100, 75);
        }
    }
    /**
     * Act - do whatever the BugsBunny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
