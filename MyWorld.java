import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the game is to be played.
 * 
 * @author Ho
 * @version May 2024
 */
public class MyWorld extends World
{
    public int timerDiceRoll;
    SimpleTimer diceRollTimer = new SimpleTimer();
    SimpleTimer currentTimeTimer = new SimpleTimer();
    
    public int moleDiceRoll;
    
    public int score = 0;
    public int time = 5;
    Label scoreLabel;
    Label currentScoreValue;
    Label currentTimeLabel;
    Label currentTimeValue;
    
    boolean aMoleIsAnimating = false;
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
        
        diceRollTimer.mark();
        currentTimeTimer.mark();
        
        timerDiceRoll = 0;        
        moleDiceRoll = 0;
        
        prepareMoles();
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
        
        if(aMoleIsAnimating == false && diceRollTimer.millisElapsed() < timerDiceRoll)
        {
            moleDiceRoll = Greenfoot.getRandomNumber(6);
            
            if(moleDiceRoll == 0)
            {
                generateMole2();
            }
            else if(moleDiceRoll == 1)
            {
                generateMole3();
            }
            else if(moleDiceRoll == 2)
            {
                generateMole4();
            }
            else if(moleDiceRoll == 3)
            {
                generateMole5();
            }
            else if(moleDiceRoll == 4)
            {
                generateMole6();
            }
            else if(moleDiceRoll == 5)
            {
                generateMole7();
            }
        }
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
    
    public void prepareMoles()
    {
        Mole2 preparedMole2 = new Mole2();
        Mole3 preparedMole3 = new Mole3();
        Mole4 preparedMole4 = new Mole4();
        Mole5 preparedMole5 = new Mole5();
        Mole6 preparedMole6 = new Mole6();
        Mole7 preparedMole7 = new Mole7();
        
    }
}
