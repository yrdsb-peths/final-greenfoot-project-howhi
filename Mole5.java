import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole5 extends Animal
{
    /**
     * Creating a sound and image array for the mole, create two SimpleTimers,
     * create an int to store the amount of time a mole has to stay popped up,
     * and create a boolean indicating whether or not the mole is animating.
     */
    
    // Creating a sound for when the mole is clicked. A "boing" sound.
    GreenfootSound mole5Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole5Animation = new GreenfootImage[9];
    
    // Creating a timer for how long a mole has to stay popped up.
    SimpleTimer animationMole5Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole5Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole5Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole5IsAnimating;
    
    /**
     * The constructor for Mole5. The array of images are looped
     * through, moleIsAnimating is initialized, timer is marked, and the
     * image of the class is set.
     */
    public Mole5()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole5Animation.length; i++)
        {
            mole5Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole5Animation[i].scale(100, 75);
        }
        
        // Set mole5IsAnimating equal to false.
        mole5IsAnimating = false;
        
        // Mark the animationMole5Timer
        animationMole5Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole5Animation[0]);
    }
    
    
    public void act()
    {    
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // Setting the time the mole takes to hide to be the current level
        // multiplied by 500 milliseconds (half a second), and then to subtract
        // the difference from 3000 milliseconds (3 seconds).
        hideMole5Time = 3000 - (gameWorld.level * 500);
        
        // If the mole is supposed to be animating (as per the boolean) then
        // daze the mole.
        if(mole5IsAnimating)
        {
            dazeMole5();
        }
        
        // If the mole is clicked and the mole's image is the first one in the array.        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole5Animation[0])
        {
            // Play the mole sound "boing".
            mole5Clicked.setVolume(100);
            mole5Clicked.play();
            
            // Increase the score by 1.
            gameWorld.increaseScore();
            
            // Set the boolean indicating if the mole is animating or not to be true.
            mole5IsAnimating = true;
        }
        // Else if the user took too long to click on the mole (longer than hideMole5Time).
        else if(animationMole5Timer.millisElapsed() > hideMole5Time)
        {
            // Remove this object.
            gameWorld.removeObject(this);
        
            // Add back the hiddenMole that this mole replaced.
            gameWorld.addHiddenMole5();
            
            // Set aMoleIsAnimating in the gameWorld to be false to let the next
            // dice roll happen.
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void dazeMole5()
    {
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // If the mole timer is less than 100 milliseconds, then return
        // out of this loop.
        if(dazeMole5Timer.millisElapsed() < 100)
        {
            return;
        }
        
        // Set the image of the mole to the image index of the array of images
        setImage(mole5Animation[imageIndex]);
        
        // Increase the image index by 1.
        imageIndex = (imageIndex + 1) % mole5Animation.length;
        
        // Mark the mole timer.
        dazeMole5Timer.mark();
        
        // If the mole reaches the last image in the array.
        if(imageIndex == 8)
        {
            // Set this boolean to false to stop this mole from animating again
            // so it only animates once.
            mole5IsAnimating = false;
            
            // Set the image of this class to the last image of the array.
            setImage(mole5Animation[8]);
            
            // Remove this object.
            gameWorld.removeObject(this);
            
            // Add the hiddenMole in place of where this mole was.
            gameWorld.addHiddenMole5();
            
            // Set aMoleIsAnimating in the gameWorld MyWorld class to false
            // to indicate no mole or bunny is currently animating.
            gameWorld.aMoleIsAnimating = false;
            
            // Mark the diceRollTimer in the MyWorld class.
            gameWorld.diceRollTimer.mark();
        }
    }
}
