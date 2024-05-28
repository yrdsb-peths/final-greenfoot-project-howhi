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
    }
    
    public void act()
    {
        diceRollTimer.mark();
        
        if(diceRollTimer.millisElapsed() < 2000)
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
        Mole2 mole2 = new Mole2();
        addObject(mole2, getWidth() / 3, getHeight() / 2);
    }
    
    public void generateMole3()
    {
        Mole3 mole3 = new Mole3();
        addObject(mole3, getWidth() / 3, getHeight() / 2);
    }
    
        public void generateMole4()
    {
        Mole4 mole4 = new Mole4();
        addObject(mole4, getWidth() / 3, getHeight() / 2);
    }
    
        public void generateMole5()
    {
        Mole5 mole5 = new Mole5();
        addObject(mole5, getWidth() / 3, getHeight() / 2);
    }
    
        public void generateMole6()
    {
        Mole6 mole6 = new Mole6();
        addObject(mole6, getWidth() / 3, getHeight() / 2);
    }
    
        public void generateMole7()
    {
        Mole7 mole7 = new Mole7();
        addObject(mole7, getWidth() / 3, getHeight() / 2);
    }
}
