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
        
        Label gameEndsLabel = new Label("Game. Is. Over.", 100);
        addObject(gameEndsLabel, getWidth() / 2, getHeight() * 1 / 4);
        
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, getHeight() / 2);
        
        Label scoreLabel = new Label("Score: ", 40);
        addObject(scoreLabel, getWidth() * 1 / 4, getHeight() * 5 / 8);
        
        Label highScoreLabel = new Label("High Score: ", 40);
        addObject(highScoreLabel, getWidth() * 3 / 4, getHeight() * 5 / 8);
        
        MyWorld gameWorld = new MyWorld();
        int currentScore = gameWorld.score;
        int currentHighScore = gameWorld.highScore;
        
        Label currentScoreLabel = new Label(currentScore, 40);
        addObject(currentScoreLabel, 210, getHeight() * 5 / 8);
        
        Label currentHighScoreLabel = new Label(currentHighScore, 40);
        addObject(currentHighScoreLabel, 550, getHeight() * 5 / 8);
        
        Label replayLabel = new Label("Press <enter> to play again", 35);
        addObject(replayLabel, getWidth() / 2, getHeight() * 7 / 8);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
