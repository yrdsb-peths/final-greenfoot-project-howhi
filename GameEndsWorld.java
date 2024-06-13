import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The gameover screen.
 * 
 * @author Ho
 * @version June 2024
 */
public class GameEndsWorld extends World
{
    // Created GreenfootSound for the background music for the GameEndsWorld
    // (same as the TitleScreen).
    GreenfootSound titleScreenGameEndsMusic = new GreenfootSound("Background Music TitleScreen & GameEndsWorld.mp3");

    // Created a static int variable to store the score.
    public static int score;
    
    // Created a static int variable to store the high score.
    public static int highScore;
    /**
     * The constructor for the GameEndsWorld world. A world is created, labels and instruction labels
     * are added, and the animated mole from the TitleScreen is brought back.
     */
    public GameEndsWorld()
    {    
        // Create a new world with 600x340 cells with a cell size of 1x1 pixels.
        super(600, 340, 1); 
        
        // Created and added a label to indicate the game is over.
        Label gameEndsLabel = new Label("Game. Is. Over.", 100);
        addObject(gameEndsLabel, getWidth() / 2, getHeight() * 1 / 4);
        
        // Created and added the mole1 from TitleScreen to animate on this
        // world as well.
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, getHeight() / 2);
        
        // Created and added label to show "Score: ".
        Label scoreLabel = new Label("Score: ", 40);
        addObject(scoreLabel, getWidth() * 1 / 4, getHeight() * 5 / 8);
        
        // Created and added label to show "High Score: ".
        Label highScoreLabel = new Label("High Score: ", 40);
        addObject(highScoreLabel, getWidth() * 3 / 4, getHeight() * 5 / 8);
        
        // Created and added label to show the score value obtained from
        // playing the game.
        Label currentScoreLabel = new Label(score, 40);
        addObject(currentScoreLabel, 220, getHeight() * 5 / 8);
        
        // Created and added label to show the highest score obtained in the
        // current session.
        Label currentHighScoreLabel = new Label(highScore, 40);
        addObject(currentHighScoreLabel, 555, getHeight() * 5 / 8);
        
        // Created and added label to indicate to the user to press <enter>
        // in order to replay the game.
        Label replayLabel = new Label("Press <enter> to play again", 35);
        addObject(replayLabel, getWidth() / 2, getHeight() * 7 / 8);
    }
    
    public void act()
    {
        // Play the background music for the game. Set the volume to the same volume
        // as the TitleScreen world.
        titleScreenGameEndsMusic.setVolume(40);
        titleScreenGameEndsMusic.play();
        
        // If the user presses <enter>, the game is to be replayed.
        if(Greenfoot.isKeyDown("enter"))
        {
            // The static int variable "score" is reset to zero
            score = 0;
            
            // This world's background music is stopped
            titleScreenGameEndsMusic.stop();
            
            // The world is set to MyWorld again
            MyWorld gameWorld = new MyWorld();            
            Greenfoot.setWorld(gameWorld);
        }
    }
}
