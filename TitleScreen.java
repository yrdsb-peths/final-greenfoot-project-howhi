import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first screen to pop up when the game is run.
 * 
 * @author Ho
 * @version May 2024
 */
public class TitleScreen extends World
{
    // Creating a timer to show instructions for the game.
    SimpleTimer instructionsTimer = new SimpleTimer();
    
    // Created a Greenfoot Sound for the background music to be played on the
    // TitleScreen and GameEndsWorld.
    GreenfootSound titleScreenGameEndsMusic = new GreenfootSound("Background Music TitleScreen & GameEndsWorld.mp3");
    
    // The first title to be shown when running the game.
    Label titleLabel = new Label("Connor's\nWhac-a-Mole!", 75);
    /**
     * The constructor for the TitleScreen World. Create the world, create and
     * add the animated mole to the world, create and add the title "titleLabel"
     * to the world, and mark the instructionsTimer.
     */  
    public TitleScreen()
    {    
        // Create a new world with 600x300 cells with a cell size of 1x1 pixels.
        super(600, 300, 1); 
        
        // Creating and adding an animated mole on the titleScreen.
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, 225);
        
        // Adding titleLabel to TitleScreen world.
        addObject(titleLabel, getWidth() / 2, 125);   
        
        // Marking instructionsTimer.
        instructionsTimer.mark();
    }
    
    
    public void act()
    {        
        // Play the background music all the time while in this world.
        // Set the volume to 40.
        titleScreenGameEndsMusic.setVolume(40);
        titleScreenGameEndsMusic.play();
    
        // Two seconds after pressing "Run", remove titleLabel and add instructions.
        if(instructionsTimer.millisElapsed() < 2000)
        {
            return;
        }
        removeObject(titleLabel);
        Label moleInstructionsLabel = new Label("Click on as many\nmoles in 90 seconds!", 35);
        addObject(moleInstructionsLabel, getWidth() / 2, 50);
        
        Label bugsBunnyInstructionsLabel = new Label("Clicking on Bugs Bunny\ndecreases your score by 3!", 30);
        addObject(bugsBunnyInstructionsLabel, getWidth() / 2, 130);
        
        Label startGameLabel = new Label("Press <enter> to start", 28);
        addObject(startGameLabel, getWidth() / 2, 275);
        
        
        // If user presses <enter>
        if(Greenfoot.isKeyDown("enter"))
        {
            // Stop background music. 
            titleScreenGameEndsMusic.stop();
            
            // Switch world to MyWorld.
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
