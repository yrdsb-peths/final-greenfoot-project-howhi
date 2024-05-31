import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first screen to pop up when the game is run.
 * 
 * @author Ho
 * @version May 2024
 */
public class TitleScreen extends World
{
    SimpleTimer instructionsTimer = new SimpleTimer();
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    Label titleLabel = new Label("Connor's\nWhac-a-Mole!", 75);

    public TitleScreen()
    {    
        // Create a new world with 600x300 cells with a cell size of 1x1 pixels.
        super(600, 300, 1); 
             
        
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, 245);
        
        addObject(titleLabel, getWidth() / 2, 125);   
        
        instructionsTimer.mark();
        
    }
    
    
    public void act()
    {        
        if(instructionsTimer.millisElapsed() < 2000)
        {
            return;
        }
        removeObject(titleLabel);
        Label instructionsLabel = new Label("Click mouse on as many\nmoles in 30 seconds!\nPress <Enter> to Start", 45);
        addObject(instructionsLabel, getWidth() / 2, 100);
        
        if(Greenfoot.isKeyDown("enter"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
