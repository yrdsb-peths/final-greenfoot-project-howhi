import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole6 extends Animal
{
    /**
     * Creating a sound and image array for the mole, create two SimpleTimers,
     * create an int to store the amount of time a mole has to stay popped up,
     * and create a boolean indicating whether or not the mole is animating.
     */
    
    // Creating a sound for when the mole is clicked. A "boing" sound.
    GreenfootSound mole6Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole6Animation = new GreenfootImage[9];
    
    // Creating a timer to time how long the mole has been showing.
    SimpleTimer animationMole6Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole6Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole6Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole6IsAnimating;
    
    /**
     * The constructor for Mole6. The array of images are looped
     * through, mole6IsAnimating is initialized, timer is marked, and the
     * image of the class is set.
     */
    public Mole6()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole6Animation.length; i++)
        {
            mole6Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole6Animation[i].scale(100, 75);
        }
        
        // Set mole6IsAnimating equal to false.
        mole6IsAnimating = false;
        
        // Mark the animationMole6Timer
        animationMole6Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole6Animation[0]);
    }
    
    
    public void act()
    {    
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // Setting the time the mole takes to hide to be the current level
        // multiplied by 500 milliseconds (half a second), and then to subtract
        // the difference from 3000 milliseconds (3 seconds).
        hideMole6Time = 3000 - (gameWorld.level * 500);
        
        // If the mole is supposed to be animating (as per the boolean) then
        // daze the mole.
        if(mole6IsAnimating)
        {
            dazeMole6();
        }
        
        // If the mole is clicked and the mole's image is the first one in the array.        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole6Animation[0])
        {
            // Play the mole sound "boing".
            mole6Clicked.setVolume(100);
            mole6Clicked.play();
            
            // Increase the score by 1.
            gameWorld.increaseScore();
            
            // Set the boolean indicating if the mole is animating or not to be true.
            mole6IsAnimating = true;
        }
        // Else if the user took too long to click on the mole (longer than hideMole6Time).
        else if(animationMole6Timer.millisElapsed() > hideMole6Time)
        {
            // Remove this object.
            gameWorld.removeObject(this);
        
            // Add back the hiddenMole that this mole replaced.
            gameWorld.addHiddenMole6();
            
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
    public void dazeMole6()
    {
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // If the mole timer is less than 100 milliseconds, then return
        // out of this method.
        if(dazeMole6Timer.millisElapsed() < 100)
        {
            return;
        }
        
        // Set the image of the mole to the image index of the array of images
        setImage(mole6Animation[imageIndex]);
        
        // Increase the image index by 1.
        imageIndex = (imageIndex + 1) % mole6Animation.length;
        
        // Mark the mole timer.
        dazeMole6Timer.mark();
        
        // If the mole reaches the last image in the array.
        if(imageIndex == 8)
        {
            // Set this boolean to false to stop this mole from animating again
            // so it only animates once.
            mole6IsAnimating = false;
            
            // Set the image of the mole to the image index of the array of images
            setImage(mole6Animation[8]);
            
            // Remove this object.
            gameWorld.removeObject(this);
            
            // Add the hiddenMole in place of where this mole was.
            gameWorld.addHiddenMole6();
            
            // Set aMoleIsAnimating in the gameWorld MyWorld class to false
            // to indicate no mole or bunny is currently animating.
            gameWorld.aMoleIsAnimating = false;
            
            // Mark the diceRollTimer in the MyWorld class.
            gameWorld.diceRollTimer.mark();
        }
    }
}
