import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole4 extends Animal
{
    /**
     * Creating a sound and image array for the mole, create two SimpleTimers,
     * create an int to store the amount of time a mole has to stay popped up,
     * and create a boolean indicating whether or not the mole is animating.
     */
    
    // Creating a sound for when the mole is clicked. A "boing" sound.
    GreenfootSound mole4Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole4Animation = new GreenfootImage[9];
    
    // Creating a timer to time how long the mole has been showing.
    SimpleTimer animationMole4Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole4Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole4Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole4IsAnimating;
    
    /**
     * The constructor for Mole4. The array of images are looped
     * through, mole4IsAnimating is initialized, timer is marked, and the
     * image of the class is set.
     */
    public Mole4()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole4Animation.length; i++)
        {
            mole4Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole4Animation[i].scale(100, 75);
        }
        
        // Set mole4IsAnimating equal to false.
        mole4IsAnimating = false;
        
        // Mark the animationMole4Timer
        animationMole4Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole4Animation[0]);
    }
    
    
    public void act()
    {    
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // Setting the time the mole takes to hide to be the current level
        // multiplied by 500 milliseconds (half a second), and then to subtract
        // the difference from 3000 milliseconds (3 seconds).
        hideMole4Time = 3000 - (gameWorld.level * 500);
        
        // If the mole is supposed to be animating (as per the boolean) then
        // daze the mole.
        if(mole4IsAnimating)
        {
            dazeMole4();
        }
        
        // If the mole is clicked and the mole's image is the first one in the array.        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole4Animation[0])
        {
            // Play the mole sound "boing".
            mole4Clicked.setVolume(100);
            mole4Clicked.play();
            
            // Increase the score by 1.
            gameWorld.increaseScore();
            
            // Set the boolean indicating if the mole is animating or not to be true.
            mole4IsAnimating = true;
        }
        // Else if the user took too long to click on the mole (longer than hideMole4Time).
        else if(animationMole4Timer.millisElapsed() > hideMole4Time)
        {
            // Remove this object.
            gameWorld.removeObject(this);
        
            // Add back the hiddenMole that this mole replaced.
            gameWorld.addHiddenMole4();
            
            // Set aMoleIsAnimating in the gameWorld to be false to let the next
            // dice roll happen.
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    // The image index of the array is initialized.
    int imageIndex = 0;
    /**
     * This method animates the mole so that the mole looks "dazed"
     * after being clicked on to resemble it being "whacked."
     */
    public void dazeMole4()
    {
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // If the mole timer is less than 100 milliseconds, then return
        // out of this method.
        if(dazeMole4Timer.millisElapsed() < 100)
        {
            return;
        }
        
        // Set the image of the mole to the image index of the array of images
        setImage(mole4Animation[imageIndex]);
        
        // Increase the image index by 1.
        imageIndex = (imageIndex + 1) % mole4Animation.length;
        
        // Mark the mole timer.
        dazeMole4Timer.mark();
        
        // If the mole reaches the last image in the array.
        if(imageIndex == 8)
        {
            // Set this boolean to false to stop this mole from animating again
            // so it only animates once.
            mole4IsAnimating = false;
            
            // Set the image of this mole to the last image of the array.
            setImage(mole4Animation[8]);
            
            // Remove this object.
            gameWorld.removeObject(this);
            
            // Add the hiddenMole in place of where this mole was.
            gameWorld.addHiddenMole4();
            
            // Set aMoleIsAnimating in the gameWorld MyWorld class to false
            // to indicate no mole or bunny is currently animating.
            gameWorld.aMoleIsAnimating = false;
            
            // Mark the diceRollTimer in the MyWorld class.
            gameWorld.diceRollTimer.mark();
        }
    }
}
