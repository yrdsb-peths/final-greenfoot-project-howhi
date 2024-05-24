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
    public TitleScreen()
    {    
        // Create a new world with 600x300 cells with a cell size of 1x1 pixels.
        super(600, 300, 1); 
        
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, 245);
        
        Label titleLabel = new Label("Connor's\nWhac-a-Mole!", 50);
        addObject(titleLabel, getWidth() / 2, 125);
    }
}
