import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class Mole2 extends Animal
{
    /**
     * Creating a sound and image array for the mole, create two SimpleTimers,
     * create an int to store the amount of time a mole has to stay popped up,
     * and create a boolean indicating whether or not the mole is animating.
     */
    
    // Creating a sound for when the mole is clicked. A "boing" sound".
    GreenfootSound mole2Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole2Animation = new GreenfootImage[9];
    
    // Creating a timer for how long a mole has to stay popped up.
    SimpleTimer animationMole2Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole2Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole2Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole2IsAnimating;
    
    
    /**
     * The constructor for Mole2. The array of images are looped
     * through, moleIsAnimating is initialized, timer is marked, and the
     * image of the class is set.
     */
    public Mole2()
    {
        // Looping through the array of images and scaling images.
        for(int i = 0; i < mole2Animation.length; i++)
        {
            mole2Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole2Animation[i].scale(100, 75);
        }
        
        // Set mole2IsAnimating equal to false.
        mole2IsAnimating = false;
        
        // Mark the animationMole2Timer
        animationMole2Timer.mark();
        
        // Set the current class image to the first image in the array.
        setImage(mole2Animation[0]);        
    }
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        hideMole2Time = 3000 - (gameWorld.level * 500);
        if(mole2IsAnimating)
        {
            dazeMole2();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole2Animation[0])
        {
            mole2Clicked.setVolume(100);
            mole2Clicked.play();
            gameWorld.increaseScore();
            mole2IsAnimating = true;
        }
        else if(animationMole2Timer.millisElapsed() > hideMole2Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole2();
            gameWorld.aMoleIsAnimating = false;
        }
    }  
    
    int imageIndex = 0;
    public void dazeMole2()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole2Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole2Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole2Animation.length;
        dazeMole2Timer.mark();
        
        if(imageIndex == 8)
        {
            mole2IsAnimating = false;
            setImage(mole2Animation[8]);
            
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole2();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
