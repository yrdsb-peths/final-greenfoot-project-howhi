import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world where the game is to be played.
 * 
 * @author Ho
 * @version May 2024
 */
public class MyWorld extends World
{
    /**
     * Here, before the constructor, timers, ints, booleans, labels,
     * and a sound is created.
     */
    
    // The int that determines when the next mole or bunny will pop up (in milliseconds).
    public int timerDiceRoll;
    
    // The timer that times the timerDiceRoll variable.
    SimpleTimer diceRollTimer = new SimpleTimer();
    
    // The timer that times the game.
    SimpleTimer currentTimeTimer = new SimpleTimer();
    
    // This is the int that determines which mole will pop up.
    public int moleDiceRoll;
    
    // This is the int that determines which bugsBunny will pop up.
    public int bugsBunnyDiceRoll;
    
    // This is the int that stores the current time.
    public int time;
    
    // This is the int that stores the current level.
    public int level;
    
    // This is the label that shows "Score: ".
    Label scoreLabel;
    
    // This is the label that shows the current score value.
    Label currentScoreValue;
    
    // This is the label that shows "Time: "
    Label currentTimeLabel;
    
    // This is the label that shows the current time value.
    Label currentTimeValue;
    
    // This is the boolean that returns whether or not a mole or bugs bunny
    // is animating.
    boolean aMoleIsAnimating;
    
    // This is the boolean that helps get a random number for timerDiceRoll
    // in the act() method.
    boolean isTrue;
    
    // This initializes a new GameEndsWorld world.
    GameEndsWorld gameEndsWorld = new GameEndsWorld();
    
    // Created a GreenfootSound for the background music that is to be played
    // throughout gameplay.
    GreenfootSound gameWorldBackgroundMusic = new GreenfootSound("Background Music GameWorld.mp3");
    
    /**
     * The constructor for the MyWorld world. The world is created, the time value, score,
     * level, and booleans are initialzied. Labels are added. Timers are marked. 
     * The int timerDiceRoll is initialized, and the HiddenMoles are added to the world.
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // Initialized the time, the score, and the level. *Note: "score" is
        // a variable part of the GameEndsWorld class in order to show it in
        // that world when the game is over.
        time = 90;
        gameEndsWorld.score = 0;
        level = 1;
        
        // Initialized the booleans.
        aMoleIsAnimating = false;
        isTrue = true;
        
        /*
         * The following 4 labels are created and added to the world.
         */
        scoreLabel = new Label("Score: ", 50);
        addObject(scoreLabel, getWidth() / 5, 40);
        
        // Set the currentScoreValue to the current score.
        currentScoreValue = new Label(gameEndsWorld.score, 50);
        addObject(currentScoreValue, 210, 40);
        
        currentTimeLabel = new Label("Time: ", 50);
        addObject(currentTimeLabel, getWidth() * 3 / 4, 40);
        
        // Set the currentTimeValue to the current time.
        currentTimeValue = new Label(time, 50);
        addObject(currentTimeValue, 530, 40);
        
        
        
        // Marked the diceRollTimer.
        diceRollTimer.mark();
        
        // Marked the current time timer.
        currentTimeTimer.mark();
        
        // Initialized timerDiceRoll to be a random number from 0 - 4999 (inclusive)
        // similar to rolling a dice.
        timerDiceRoll = Greenfoot.getRandomNumber(5000);
        
        // Prepared/added the hiddenMoles to the world.
        addHiddenMole2();
        addHiddenMole3();
        addHiddenMole4();
        addHiddenMole5();
        addHiddenMole6();
        addHiddenMole7();
    }
    
    public void act()
    {
        // Play the background music for the game. Ensured volume is lower than
        // other two worlds so the moles clicked sound and bugs bunny clicked 
        // sound can be heard sufficiently.
        gameWorldBackgroundMusic.setVolume(20);
        gameWorldBackgroundMusic.play();
        
        // Set the timerDiceRoll to be a random number between 0 - 4999 (inclusive).
        // Used boolean to ensure timerDiceRoll is constantly being randomized.
        while(isTrue == true)
        {
            timerDiceRoll = Greenfoot.getRandomNumber(5000);
            isTrue = false;
        }
        
        // After every second of gameplay, decrease the time by one second.
        if(currentTimeTimer.millisElapsed() > 1000)
        {
            decreaseTime();
            currentTimeTimer.mark();
        }
        
        // If the time value ever gets below zero, the game is over.
        if(time < 0)
        {
            // Set the highScore equal to the score if the score is a new high.
            if(gameEndsWorld.score > gameEndsWorld.highScore)
            {
                gameEndsWorld.highScore = gameEndsWorld.score;
            }
            
            // Stop the background music.
            gameWorldBackgroundMusic.stop();
            
            // Change to the gameEndsWorld world.
            GameEndsWorld gameEndsWorld = new GameEndsWorld();
            Greenfoot.setWorld(gameEndsWorld);
        }
        
        /**
         * This if statement control structure controls when and where the moles and bugs bunnies appear.
         * Only if all the moles/bunnies are hidden (no moles/bunnies are showing) and when the time that has passed, in milliseconds,
         * is greater than the random int from 0 - 4999, then a new mole or bunny will pop up. Only one mole or bunny 
         * appears at a time.
         */
        if(aMoleIsAnimating == false && diceRollTimer.millisElapsed() > timerDiceRoll)
        {
            // Mark the diceRollTimer.
            diceRollTimer.mark();
            
            // A mole or bunny is animating is true.
            aMoleIsAnimating = true;
            
            // Get a random number from 0 and 6 (inclusive).
            moleDiceRoll = Greenfoot.getRandomNumber(7);
            
            // According to the moleDiceRoll number, make one of the moles appear
            // and remove the hiddenMole that the appearing mole replaces.
            // Each mole will appear at a different location in the world.
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
            // If the random moleDiceRoll equals 6, then make a bugs bunny appear.
            else if(moleDiceRoll == 6)
            {
                // Get another random number between 0 and 5.
                bugsBunnyDiceRoll = Greenfoot.getRandomNumber(6);
                
                // Again, depending on the diceRoll, generate the appropriate bugs bunny.
                // Each bugs bunny will appear at a different location in the world.
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
            // Once the bunny or mole that has been generated has finished animating
            // (if clicked on) or has gone back to being hidden because the user failed
            // to click on it in time, set isTrue to true so that another random number for
            // timerDiceRoll can be set.
            isTrue = true;
        }
    }
    
    
    /**
     * This method increases the score. It sets the value of the currentScoreValue
     * label to the updated score and also increases the level if the score is a 
     * multiple of 5.
     */
    public void increaseScore()
    {
        // Increase the score by 1.
        gameEndsWorld.score++;
        
        // Set the currentScoreValue to the updated score.
        currentScoreValue.setValue(gameEndsWorld.score);
        
        // Increase the level by 1 if the score is a multiple of 5 and is greater than 0.
        if(gameEndsWorld.score > 0 && gameEndsWorld.score % 5 == 0)
        {
            level++;
        }
    }
    
    
    /**
     * This method decreases the score by 3 and sets the currentScoreValue label
     * to the updated score.
     */
    public void decreaseScoreBy3()
    {
        // Decrease the score by 3.
        gameEndsWorld.score -= 3;
        
        // Set the currentScoreValue to the updated score.
        currentScoreValue.setValue(gameEndsWorld.score);
    }
    
    /**
     * This method decreases the time by 1 and sets the currentTimeValue to the updated time.
     */
    public void decreaseTime()
    {
        // Decrease the time by 1.
        time--;
        
        // Set the currentTimeValue to the updated time.
        currentTimeValue.setValue(time);
    }
    
    
    /**
     * The following methods whose names start with "generate" creates the "showing" moles and
     * bunnies and adds them to the world at different locations.
     */
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

    
    
    
    // Creating the hidden moles.
    HiddenMole hiddenMole2 = new HiddenMole();
    HiddenMole hiddenMole3 = new HiddenMole();
    HiddenMole hiddenMole4 = new HiddenMole();
    HiddenMole hiddenMole5 = new HiddenMole();
    HiddenMole hiddenMole6 = new HiddenMole();
    HiddenMole hiddenMole7 = new HiddenMole();
    
    /**
     * The following methods adds the hiddenMoles to the world at different locations (same as above methods' locations).
     */
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
    
    
    /**
     * The following methods removes the indicated hiddenMole from the world.
     */
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
