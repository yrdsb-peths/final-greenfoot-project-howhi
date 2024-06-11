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
    
    // Creating a sound for when the mole is clicked. A "boing" sound".
    GreenfootSound mole6Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole6Animation = new GreenfootImage[9];
    
    // Creating a timer for how long a mole has to stay popped up.
    SimpleTimer animationMole6Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole6Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole6Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole6IsAnimating;
    
    /**
     * The constructor for Mole6. The array of images are looped
     * through, moleIsAnimating is initialized, timer is marked, and the
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
        MyWorld gameWorld = (MyWorld) getWorld();
        hideMole6Time = 3000 - (gameWorld.level * 500);
        if(mole6IsAnimating)
        {
            dazeMole6();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole6Animation[0])
        {
            mole6Clicked.setVolume(100);
            mole6Clicked.play();
            mole6IsAnimating = true;
            gameWorld.increaseScore();
        }
        else if(animationMole6Timer.millisElapsed() > hideMole6Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole6();
            gameWorld.aMoleIsAnimating = false;
        }        
    }
 
    int imageIndex = 0;
    public void dazeMole6()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole6Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole6Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole6Animation.length;
        dazeMole6Timer.mark();
        
        if(imageIndex == 8)
        {
            mole6IsAnimating = false;
            setImage(mole6Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole6();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
