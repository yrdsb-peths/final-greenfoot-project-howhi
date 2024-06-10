import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The first screen to pop up when the game is run.
 * 
 * @author Ho
 * @version May 2024
 */
public class TitleScreen extends World
{
    SimpleTimer instructionsTimer = new SimpleTimer();
    
    GreenfootSound titleScreenGameEndsMusic = new GreenfootSound("Background Music TitleScreen & GameEndsWorld.mp3");
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    Label titleLabel = new Label("Connor's\nWhac-a-Mole!", 75);

    public TitleScreen()
    {    
        // Create a new world with 600x300 cells with a cell size of 1x1 pixels.
        super(600, 300, 1); 
        
        Mole1 mole1 = new Mole1();
        addObject(mole1, getWidth() / 2, 225);
        
        addObject(titleLabel, getWidth() / 2, 125);   
        
        instructionsTimer.mark();
    }
    
    
    public void act()
    {        
        titleScreenGameEndsMusic.setVolume(50);
        titleScreenGameEndsMusic.play();
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
        
        if(Greenfoot.isKeyDown("enter"))
        {
            titleScreenGameEndsMusic.stop();
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
