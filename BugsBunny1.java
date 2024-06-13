import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the bugs bunnies.
 * 
 * @author Ho
 * @version June 2024
 */
public class BugsBunny1 extends Animal
{
    /**
     * Creating a sound and image for the bugs bunny, create a SimpleTimer,
     * and create a boolean to indicate whether or not the bugsBunny is animating.
     */
    
    // Creating a sound for when bugs bunny is clicked: he will cry out 
    // "Cut It Out!"
    GreenfootSound bugsBunnyCutItOut1 = new GreenfootSound("Bugs Bunny Cut It Out.mp3");
    
    // The array of images for the bugs bunny to animate through.
    GreenfootImage[] bugsBunny1Animation = new GreenfootImage[3];

    // Creating a timer for the animation part.
    SimpleTimer bugsBunnyTimer1 = new SimpleTimer();
    
    // Create a boolean to indicate if the bugs bunny is animating.
    boolean bugsBunny1IsAnimating;
    
    /**
     * The constructor for Bugs Bunny Number 1. The array of images are looped
     * through, bugsBunny1IsAnimating is initialized, the image of BugsBunny1
     * is initialized and the timer is marked.
     */
    public BugsBunny1()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < bugsBunny1Animation.length; i++)
        {
            bugsBunny1Animation[i] = new GreenfootImage("images/Bugs_Bunny_Animate/bugs_bunny_hammered" + i + ".png");
            bugsBunny1Animation[i].scale(100, 100);
        }
        
        // Set bugsBunny1IsAnimating equal to false.
        bugsBunny1IsAnimating = false;
        
        // Mark the bugsBunnyTimer.
        bugsBunnyTimer1.mark();     
        
        // Access standing bunny image, scale it to an appropriate size, and set
        // this class' image to that image.
        GreenfootImage bugsBunnyStanding1 = new GreenfootImage("images/Bugs_Bunny_Standing.png");
        bugsBunnyStanding1.scale(100, 100);
        setImage(bugsBunnyStanding1);
    }
    
    public void act()
    {
        // Getting the gameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // If this bugs bunny's boolean IsAnimating is true, then animate it.
        if(bugsBunny1IsAnimating == true)
        {
            animateBugsBunny1();
        }
        
        // If the user clicks this bugs bunny while it is standing, play a
        // sound, decrease the score by 3, and set the boolean to be true.
        if(Greenfoot.mouseClicked(this))
        {
            // Play the sound "Cut It Out" by Bugs Bunny.
            bugsBunnyCutItOut1.play();
            
            // Decrease the current score value by 3.
            gameWorld.decreaseScoreBy3();
            
            // Set boolean to true.
            bugsBunny1IsAnimating = true;
        }
        // If bugsBunny hasn't been clicked and it's been more than 2 seconds.
        else if(bugsBunnyTimer1.millisElapsed() > 2000)
        {
            // Remove this object from the world.
            gameWorld.removeObject(this);
            
            // Add the hiddenMole back in the same spot as where this bunny
            // was before.
            gameWorld.addHiddenMole2();
            
            // Set aMoleIsAnimating in the gameWorld MyWorld class to false
            // to indicate no mole or bunny is currently animating.
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    // The image index of the array is initialized.
    int imageIndex = 0;
    /**
     * This method animates the bunny. It will animate it to look like it's been 
     * "hammered down" and squashed (since it was whacked).
     */
    public void animateBugsBunny1()
    {
        // Get the gameWorld.
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // If the bugs bunny timer is less than 300 milliseconds, then return
        // out of this method.
        if(bugsBunnyTimer1.millisElapsed() < 300)
        {
            return;
        }
        
        // Set the image of the bugsBunny to the image index of the array of images.
        setImage(bugsBunny1Animation[imageIndex]);
        
        // Increase the image index by 1.
        imageIndex = (imageIndex + 1) % bugsBunny1Animation.length;
        
        // Mark the bugsBunny timer.
        bugsBunnyTimer1.mark();
        
        
        // If the bugs bunny reaches the last image in the array.
        if(imageIndex == 2)
        {
            // Set this boolean to false to stop this bunny from animating again
            // so it only animates once.
            bugsBunny1IsAnimating = false;
            
            // Set the image of this class to the last image of the array.
            setImage(bugsBunny1Animation[2]);
            
            // Remove this object.            
            gameWorld.removeObject(this);
            
            // Add the hiddenMole in place of where this bugs bunny was.
            gameWorld.addHiddenMole2();
            
            // Set aMoleIsAnimating in the gameWorld MyWorld class to false
            // to indicate no mole or bunny is currently animating.
            gameWorld.aMoleIsAnimating = false;
            
            // Mark the diceRollTimer in the MyWorld class.
            gameWorld.diceRollTimer.mark();
        }
    }
}
