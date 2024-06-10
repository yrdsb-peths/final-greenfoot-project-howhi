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
    public int bugsBunnyDiceRoll;
    public int score;
    public int time;
    public int level;
    Label scoreLabel;
    Label currentScoreValue;
    Label currentTimeLabel;
    Label currentTimeValue;
    
    boolean aMoleIsAnimating = false;
    boolean isTrue = true;
    
    GreenfootSound gameWorldBackgroundMusic = new GreenfootSound("Background Music GameWorld.mp3");
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
        
        time = 90;
        score = 0;
        level = 1;
        
        currentScoreValue = new Label(score, 50);
        addObject(currentScoreValue, 210, 40);
        
        currentTimeLabel = new Label("Time: ", 50);
        addObject(currentTimeLabel, getWidth() * 3 / 4, 40);
        
        currentTimeValue = new Label(time, 50);
        addObject(currentTimeValue, 530, 40);
        
        diceRollTimer.mark();
        currentTimeTimer.mark();
        
        timerDiceRoll = Greenfoot.getRandomNumber(5000);        
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
        gameWorldBackgroundMusic.setVolume(20);;
        gameWorldBackgroundMusic.play();
        while(isTrue == true)
        {
            timerDiceRoll = Greenfoot.getRandomNumber(5000);
            isTrue = false;
        }
        
        if(currentTimeTimer.millisElapsed() > 1000)
        {
            decreaseTime();
            currentTimeTimer.mark();
        }
        
        if(time < 0)
        {
            gameWorldBackgroundMusic.stop();
            GameEndsWorld gameEndsWorld = new GameEndsWorld();
            Greenfoot.setWorld(gameEndsWorld);
        }
        
        if(aMoleIsAnimating == false && diceRollTimer.millisElapsed() > timerDiceRoll)
        {
            diceRollTimer.mark();
            aMoleIsAnimating = true;
            moleDiceRoll = Greenfoot.getRandomNumber(7);
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
            else if(moleDiceRoll == 6)
            {
                bugsBunnyDiceRoll = Greenfoot.getRandomNumber(6);
                if(bugsBunnyDiceRoll == 0)
                {
                    removeHiddenMole2();
                    generateBugsBunny1();
                }
                else if(bugsBunnyDiceRoll == 1)
                {
                    removeHiddenMole3();
                    generateBugsBunny2();
                }
                else if(bugsBunnyDiceRoll == 2)
                {
                    removeHiddenMole4();
                    generateBugsBunny3();
                }
                else if(bugsBunnyDiceRoll == 3)
                {
                    removeHiddenMole5();
                    generateBugsBunny4();
                }
                else if(bugsBunnyDiceRoll == 4)
                {
                    removeHiddenMole6();
                    generateBugsBunny5();
                }
                else if(bugsBunnyDiceRoll == 5)
                {
                    removeHiddenMole7();
                    generateBugsBunny6();
                }
            }
            isTrue = true;
        }
    }
    
    public void generateBugsBunny1()
    {
        BugsBunny1 bugsBunny1 = new BugsBunny1();
        addObject(bugsBunny1, getWidth() / 4, getHeight() / 3);
    }
    
    public void generateBugsBunny2()
    {
        BugsBunny2 bugsBunny2 = new BugsBunny2();
        addObject(bugsBunny2, getWidth() / 2, getHeight() / 3);
    }
    
    public void generateBugsBunny3()
    {
        BugsBunny3 bugsBunny3 = new BugsBunny3();
        addObject(bugsBunny3, getWidth() * 3 / 4, getHeight() / 3);
    }
    
    public void generateBugsBunny4()
    {
        BugsBunny4 bugsBunny4 = new BugsBunny4();
        addObject(bugsBunny4, getWidth() / 4, getHeight() * 2 / 3);
    }
    
    public void generateBugsBunny5()
    {
        BugsBunny5 bugsBunny5 = new BugsBunny5();
        addObject(bugsBunny5, getWidth() / 2, getHeight() * 2 / 3);
    }
    
    public void generateBugsBunny6()
    {
        BugsBunny6 bugsBunny6 = new BugsBunny6();
        addObject(bugsBunny6, getWidth() * 3 / 4, getHeight() * 2 / 3);
    }
    
    GameEndsWorld gameEndsWorld = new GameEndsWorld();
    
    public void increaseScore()
    {
        score++;
        
        gameEndsWorld.score++;
        
        if(gameEndsWorld.score > gameEndsWorld.highScore)
        {
            gameEndsWorld.highScore = gameEndsWorld.score;
        }
        currentScoreValue.setValue(score);
        
        if(score > 0 && score % 5 == 0)
        {
            level++;
        }
    }
    
    public void decreaseScoreBy3()
    {
        score -= 3;
        gameEndsWorld.score -= 3;
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
