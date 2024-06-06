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
    public static int highScore = 0;
    public int score;
    public int time = 8;
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
        
        score = 0;
        
        currentScoreValue = new Label(score, 50);
        addObject(currentScoreValue, 200, 40);
        
        currentTimeLabel = new Label("Time: ", 50);
        addObject(currentTimeLabel, getWidth() * 3 / 4, 40);
        
        currentTimeValue = new Label(8, 50);
        addObject(currentTimeValue, 530, 40);
        
        diceRollTimer.mark();
        currentTimeTimer.mark();
        
        timerDiceRoll = 5000;        
        moleDiceRoll = 0;
        
        addHiddenMole2();
        addHiddenMole3();
        addHiddenMole4();
        addHiddenMole5();
        addHiddenMole6();
        addHiddenMole7();
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
        
        if(diceRollTimer.millisElapsed() > timerDiceRoll)
        {
            diceRollTimer.mark();
            aMoleIsAnimating = true;
            moleDiceRoll = Greenfoot.getRandomNumber(6);
            if(moleDiceRoll == 0)
            {
                removeHiddenMole2();
                generateMole2();
            }
            else if(moleDiceRoll == 1)
            {
                removeHiddenMole3();
                generateMole3();
            }
            else if(moleDiceRoll == 2)
            {
                removeHiddenMole4();
                generateMole4();
            }
            else if(moleDiceRoll == 3)
            {
                removeHiddenMole5();
                generateMole5();
            }
            else if(moleDiceRoll == 4)
            {
                removeHiddenMole6();
                generateMole6();
            }
            else if(moleDiceRoll == 5)
            {
                removeHiddenMole7();
                generateMole7();
            }
        }
    }
    
    public void increaseScore()
    {
        score++;
        currentScoreValue.setValue(score);
        
        if(score > highScore)
        {
            highScore = score;
        }
    }
    
    public int currentScore()
    {
        return score;
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

    HiddenMole hiddenMole2 = new HiddenMole();
    HiddenMole hiddenMole3 = new HiddenMole();
    HiddenMole hiddenMole4 = new HiddenMole();
    HiddenMole hiddenMole5 = new HiddenMole();
    HiddenMole hiddenMole6 = new HiddenMole();
    HiddenMole hiddenMole7 = new HiddenMole();
    
    public void addHiddenMole2()
    {
        addObject(hiddenMole2, getWidth() / 4, getHeight() / 3); 
    }
    
    public void addHiddenMole3()
    {
        addObject(hiddenMole3, getWidth() / 2, getHeight() / 3);
    }
    
    public void addHiddenMole4()
    {
        addObject(hiddenMole4, getWidth() * 3 / 4, getHeight() / 3);
    }
    
    public void addHiddenMole5()
    {
        addObject(hiddenMole5, getWidth() / 4, getHeight() * 2 / 3);
    }
    
    public void addHiddenMole6()
    {
        addObject(hiddenMole6, getWidth() / 2, getHeight() * 2 / 3);
    }
    
    public void addHiddenMole7()
    {
        addObject(hiddenMole7, getWidth() * 3 / 4, getHeight() * 2 / 3);
    }
    
    public void removeHiddenMole2()
    {
        removeObject(hiddenMole2);
    }
    
    public void removeHiddenMole3()
    {
        removeObject(hiddenMole3);
    }
    
    public void removeHiddenMole4()
    {
        removeObject(hiddenMole4);
    }
    
    public void removeHiddenMole5()
    {
        removeObject(hiddenMole5);
    }
    
    public void removeHiddenMole6()
    {
        removeObject(hiddenMole6);
    }
    
    public void removeHiddenMole7()
    {
        removeObject(hiddenMole7);
    }
}
