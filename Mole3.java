import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole3 extends Animal
{
    /**
     * Creating a sound and image array for the mole, create two SimpleTimers,
     * create an int to store the amount of time a mole has to stay popped up,
     * and create a boolean indicating whether or not the mole is animating.
     */
    
    // Creating a sound for when the mole is clicked. A "boing" sound.
    GreenfootSound mole3Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole3Animation = new GreenfootImage[9];
    
    // Creating a timer for how long a mole has to stay popped up.
    SimpleTimer animationMole3Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole3Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole3Time;
    
    // This is the boolean that indicates whether or not the mole is animating. 
    boolean mole3IsAnimating;
    
    /**
     * The constructor for Mole3. The array of images are looped
     * through, moleIsAnimating is initialized, timer is marked, and the
     * image of the class is set.
     */
    public Mole3()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole3Animation.length; i++)
        {
            mole3Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole3Animation[i].scale(100, 75);
        }
        
        // Set mole3IsAnimating equal to false.
        mole3IsAnimating = false;
        
        // Mark the animationMole3Timer
        animationMole3Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole3Animation[0]);
    }
    
    
    public void act()
    {  
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // Setting the time the mole takes to hide to be the current level
        // multiplied by 500 milliseconds (half a second), and then to subtract
        // the difference from 3000 milliseconds (3 seconds).
        hideMole3Time = 3000 - (gameWorld.level * 500);
        
        // If the mole is supposed to be animating (as per the boolean) then
        // daze the mole.
        if(mole3IsAnimating)
        {
            dazeMole3();
        }
        
        // If the mole is clicked and the mole's image is the first one in the array.        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole3Animation[0])
        {
            // Play the mole sound "boing".
            mole3Clicked.setVolume(100);
            mole3Clicked.play();
            
            // Increase the score by 1.
            gameWorld.increaseScore();
            
            // Set the boolean indicating if the mole is animating or not to be true.
            mole3IsAnimating = true;
        }
        // Else if the user took too long to click on the mole (longer than hideMole3Time).
        else if(animationMole3Timer.millisElapsed() > hideMole3Time)
        {
            // Remove this object.
            gameWorld.removeObject(this);
        
            // Add back the hiddenMole that this mole replaced.
            gameWorld.addHiddenMole3();
            
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
    public void dazeMole3()
    {
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // If the mole timer is less than 100 milliseconds, then return
        // out of this method.
        if(dazeMole3Timer.millisElapsed() < 100)
        {
            return;
        }
        
        // Set the image of the mole to the image index of the array of images
        setImage(mole3Animation[imageIndex]);
        
        // Increase the image index by 1.
        imageIndex = (imageIndex + 1) % mole3Animation.length;
        
        // Mark the mole timer.
        dazeMole3Timer.mark();
        
        // If the mole reaches the last image in the array.
        if(imageIndex == 8)
        {
            // Set this boolean to false to stop this mole from animating again
            // so it only animates once.
            mole3IsAnimating = false;
            
            // Set the image of this class to the last image of the array.
            setImage(mole3Animation[8]);
            
            // Remove this object.
            gameWorld.removeObject(this);
            
            // Add the hiddenMole in place of where this mole was.
            gameWorld.addHiddenMole3();
            
            // Set aMoleIsAnimating in the gameWorld MyWorld class to false
            // to indicate no mole or bunny is currently animating.
            gameWorld.aMoleIsAnimating = false;
            
            // Mark the diceRollTimer in the MyWorld class.
            gameWorld.diceRollTimer.mark();
        }
    }
}
