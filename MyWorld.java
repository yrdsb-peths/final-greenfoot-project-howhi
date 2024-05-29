import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the game is to be played.
 * 
 * @author Ho
 * @version May 2024
 */
public class MyWorld extends World
{
    public int diceRoll;
    SimpleTimer diceRollTimer = new SimpleTimer();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x300 cells with a cell size of 1x1 pixels.
        super(600, 300, 1);
        
        Mole2 mole2 = new Mole2();
        addObject(mole2, getWidth() / 4, getHeight() / 3);
        
        diceRoll = 0;
        
        diceRollTimer.mark();
        
        generateMole2();
    }
    
    public void act()
    {
        if(diceRollTimer.millisElapsed() < 5000)
        {
            return;
        }
        
        diceRoll = Greenfoot.getRandomNumber(6);
    }
    
    public void generateMole2()
    {
        Mole2 mole2 = new Mole2();
    }
    
    public void manifestMole2()
    {
        
    }
}
