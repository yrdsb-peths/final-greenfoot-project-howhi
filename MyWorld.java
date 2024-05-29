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
    }
    
    public void act()
    {
        diceRollTimer.mark();
        
        if(diceRollTimer.millisElapsed() < 5000)
        {
            return;
        }
        
        diceRoll = Greenfoot.getRandomNumber(6);
        
        if(diceRoll == 0)
        {
            generateMole2();
        }
        else if(diceRoll == 1)
        {
            generateMole3();
        }
        else if(diceRoll == 2)
        {
            generateMole4();
        }
        else if(diceRoll == 3)
        {
            generateMole5();
        }
        else if(diceRoll == 4)
        {
            generateMole6();
        }
        else if(diceRoll == 5)
        {
            generateMole7();
        }
    }
    
    public void generateMole2()
    {
        
    }
    
    public void generateMole3()
    {

    }
    
        public void generateMole4()
    {

    }
    
        public void generateMole5()
    {

    }
    
        public void generateMole6()
    {
        
    }
    
        public void generateMole7()
    {
        
    }
}
