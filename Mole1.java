import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The animated mole on the title screen and ending world screen.
 * 
 * @author Ho
 * @version May 2024
 */
public class Mole1 extends Actor
{
    // The array of images for the mole to animate.
    GreenfootImage[] mole1Animation = new GreenfootImage[9];    
    
    // Created a timer for the animation part.
    SimpleTimer animationMole1Timer = new SimpleTimer();
    
    /**
     * The constructor for Mole1. The array of images are looped
     * through, the timer is marked, and the
     * image of the class is set.
     */
    public Mole1()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole1Animation.length; i++)
        {
            mole1Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole1Animation[i].scale(75, 75);
        }
        
        // Mark the animationMole1Timer
        animationMole1Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole1Animation[0]);
    }
    

    public void act()
    {
        // Constantly animate Mole1
        animateMole1();
    }
    
    // The image index of the array is initialized.
    int imageIndex = 0;
    
    /**
     * This method animates the mole so that the mole looks "dazed"
     * after being clicked on to resemble it being "whacked" (although
     * this is not one of the moles that is actually getting clicked on).
     */
    public void animateMole1()
    {
        // If the mole timer is less than 100 milliseconds, then return
        // out of this method.
        if(animationMole1Timer.millisElapsed() < 100)
        {
            return;
        }
        
        // Mark the mole timer.
        animationMole1Timer.mark();
        
        // Set the image of this class to the image index of the array.
        setImage(mole1Animation[imageIndex]);
        
        // Increase the image index by 1.
        imageIndex = (imageIndex + 1) % mole1Animation.length;        
    }
}
