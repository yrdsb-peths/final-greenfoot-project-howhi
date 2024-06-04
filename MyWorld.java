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
    SimpleTimer currentTimeTimer = new SimpleTimer();
    
    public int score = 0;
    public int time = 5;
    Label scoreLabel;
    Label currentScoreValue;
    Label currentTimeLabel;
    Label currentTimeValue;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x300 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        scoreLabel = new Label("Score: ", 50);
        addObject(scoreLabel, getWidth() / 5, 40);
        
        currentScoreValue = new Label(0, 50);
        addObject(currentScoreValue, 200, 40);
        
        currentTimeLabel = new Label("Time: ", 50);
        addObject(currentTimeLabel, getWidth() * 3 / 4, 40);
        
        currentTimeValue = new Label(5, 50);
        addObject(currentTimeValue, 530, 40);
        
        currentTimeTimer.mark();
        
        diceRoll = 0;
        
        diceRollTimer.mark();
        
        generateMole2();
        generateMole3();
        generateMole4();
        generateMole5();
        generateMole6();
        generateMole7();
    }
    
    public void act()
    {
        if(currentTimeTimer.millisElapsed() > 1000)
        {
            decreaseTime();
            currentTimeTimer.mark();
        }
        
        if(time < 0)
        {
            GameEndsWorld gameEndsWorld = new GameEndsWorld();
            Greenfoot.setWorld(gameEndsWorld);
        }
        
        if(diceRollTimer.millisElapsed() < 5000)
        {
            return;
        }
        
        diceRoll = Greenfoot.getRandomNumber(6);
    }
    
    public void increaseScore()
    {
        score++;
        currentScoreValue.setValue(score);
    }
    
    
    public void decreaseTime()
    {
        time--;
        currentTimeValue.setValue(time);
    }
    
    public void generateMole2()
    {
        Mole2 mole2 = new Mole2();
        addObject(mole2, getWidth() / 4, getHeight() / 3);        
    }
    
    public void generateMole3()
    {
        Mole3 mole3 = new Mole3();
        addObject(mole3, getWidth() / 2, getHeight() / 3);
    }
    
    public void generateMole4()
    {
        Mole4 mole4 = new Mole4();
        addObject(mole4, getWidth() * 3 / 4, getHeight() / 3);
    }
    
    public void generateMole5()
    {
        Mole5 mole5 = new Mole5();
        addObject(mole5, getWidth() / 4, getHeight() * 2 / 3);
    }
    
    public void generateMole6()
    {
        Mole6 mole6 = new Mole6();
        addObject(mole6, getWidth() / 2, getHeight() * 2 / 3);
    }
    
    public void generateMole7()
    {
        Mole7 mole7 = new Mole7();
        addObject(mole7, getWidth() * 3 / 4, getHeight() * 2 / 3);
    }
}
