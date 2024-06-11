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
    
    // Creating a sound for when the mole is clicked. A "boing" sound".
    GreenfootSound mole4Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    // The array of images for the mole to animate.
    GreenfootImage[] mole4Animation = new GreenfootImage[9];
    
    // Creating a timer for how long a mole has to stay popped up.
    SimpleTimer animationMole4Timer = new SimpleTimer();
    
    // Creating a timer for the animation part.
    SimpleTimer dazeMole4Timer = new SimpleTimer();
    
    // This is the int that stores how long a mole will appear for.
    public int hideMole4Time;
    
    // This is the boolean that indicates whether or not the mole is animating.
    boolean mole4IsAnimating;
    
    /**
     * The constructor for Mole4. The array of images are looped
     * through, moleIsAnimating is initialized, timer is marked, and the
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
        
        animationMole4Timer.mark();
        setImage(mole4Animation[0]);
    }
    
    
    public void act()
    {    
        MyWorld gameWorld = (MyWorld) getWorld();
        hideMole4Time = 3000 - (gameWorld.level * 500);
        if(mole4IsAnimating)
        {
            dazeMole4();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole4Animation[0])
        {
            mole4Clicked.setVolume(100);
            mole4Clicked.play();
            mole4IsAnimating = true;
            gameWorld.increaseScore();
        }
        else if(animationMole4Timer.millisElapsed() > hideMole4Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole4();
            gameWorld.aMoleIsAnimating = false;
        }        
    }
    
    int imageIndex = 0;
    public void dazeMole4()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole4Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole4Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole4Animation.length;
        dazeMole4Timer.mark();
        
        if(imageIndex == 8)
        {
            mole4IsAnimating = false;
            setImage(mole4Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole4();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
