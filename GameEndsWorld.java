import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The gameover screen.
 * 
 * @author Ho
 * @version June 2024
 */
public class GameEndsWorld extends World
{
    /**
     * Constructor for objects of class GameEndsWorld.
     * 
     */
    public GameEndsWorld()
    {    
        // Create a new world with 600x340 cells with a cell size of 1x1 pixels.
        super(600, 340, 1); 
        
        Label gameEndsLabel = new Label("Game. Is. Over.", 90);
        addObject(gameEndsLabel, getWidth() / 2, getHeight() / 3);
        
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, getHeight() * 5 / 8);
    }
}
