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
    
    // Creating a sound for when the mole is clicked. A "boing" sound".
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
        mole5IsAnimating = false;
        
        animationMole5Timer.mark();
        setImage(mole5Animation[0]);
    }
    
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        hideMole5Time = 3000 - (gameWorld.level * 500);
        if(mole5IsAnimating)
        {
            dazeMole5();
        }
       
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole5Animation[0])
        {
            mole5Clicked.setVolume(100);
            mole5Clicked.play();
            mole5IsAnimating = true;
            gameWorld.increaseScore();
        }
        else if(animationMole5Timer.millisElapsed() > hideMole5Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole5();
            gameWorld.aMoleIsAnimating = false;
        }        
    }
    
    int imageIndex = 0;
    public void dazeMole5()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole5Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole5Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole5Animation.length;
        dazeMole5Timer.mark();
        
        if(imageIndex == 8)
        {
            mole5IsAnimating = false;
            setImage(mole5Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole5();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
