import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole7 extends Animal
{
    /**
     * Creating a sound and image array for the mole, create two SimpleTimers,
     * create an int to store the amount of time a mole has to stay popped up,
     * and create a boolean indicating whether or not the mole is animating.
     */
    
    // Creating a sound for when the mole is clicked. A "boing" sound.
    GreenfootSound mole7Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole7Animation = new GreenfootImage[9];
    
    // Creating a timer for how long a mole has to stay popped up.
    SimpleTimer animationMole7Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole7Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole7Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole7IsAnimating;
    
    /**
     * The constructor for Mole7. The array of images are looped
     * through, moleIsAnimating is initialized, timer is marked, and the
     * image of the class is set.
     */
    public Mole7()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole7Animation.length; i++)
        {
            mole7Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole7Animation[i].scale(100, 75);
        }
        
        // Set mole7IsAnimating equal to false.
        mole7IsAnimating = false;
        
        // Mark the animationMole7Timer
        animationMole7Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole7Animation[0]);
    }
    
    
    public void act()
    {    
        // Getting the GameWorld world
        MyWorld gameWorld = (MyWorld) getWorld();
        
        // Setting the time the mole takes to hide to be the current level
        // multiplied by 500 milliseconds (half a second), and then to subtract
        // the difference from 3000 milliseconds (3 seconds).
        hideMole7Time = 3000 - (gameWorld.level * 500);
        
        // If the mole is supposed to be animating (as per the boolean) then
        // daze the mole.
        if(mole7IsAnimating)
        {
            dazeMole7();
        }
        
        // If the mole is clicked and the mole's image is the first one in the array.        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole7Animation[0])
        {
            // Play the mole sound "boing".
            mole7Clicked.setVolume(100);
            mole7Clicked.play();
            
            // Increase the score by 1.
            gameWorld.increaseScore();
            
            // Set the boolean indicating if the mole is animating or not to be true.
            mole7IsAnimating = true;
        }
        // Else if the user took too long to click on the mole (longer than hideMole7Time).
        else if(animationMole7Timer.millisElapsed() > hideMole7Time)
        {
            // Remove this object.
            gameWorld.removeObject(this);
        
            // Add back the hiddenMole that this mole replaced.
            gameWorld.addHiddenMole7();
            
            // Set aMoleIsAnimating in the gameWorld to be false to let the next
            // dice roll happen.
            gameWorld.aMoleIsAnimating = false;
        } 
    }
  
    int imageIndex = 0;
    public void dazeMole7()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole7Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole7Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole7Animation.length;
        dazeMole7Timer.mark();
        
        if(imageIndex == 8)
        {
            mole7IsAnimating = false;
            setImage(mole7Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole7();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
