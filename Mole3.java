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
    
    // Creating a sound for when the mole is clicked. A "boing" sound".
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
        mole3IsAnimating = false;
        
        animationMole3Timer.mark();
        setImage(mole3Animation[0]);
    }
    
    
    public void act()
    {  
        MyWorld gameWorld = (MyWorld) getWorld();
        hideMole3Time = 3000 - (gameWorld.level * 500);
        if(mole3IsAnimating)
        {
            dazeMole3();
        }
        
        if(Greenfoot.mouseClicked(this) && this.getImage() == mole3Animation[0])
        {
            mole3Clicked.setVolume(100);
            mole3Clicked.play();
            mole3IsAnimating = true;
            gameWorld.increaseScore();
        }
        else if(animationMole3Timer.millisElapsed() > hideMole3Time)
        {
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole3();
            gameWorld.aMoleIsAnimating = false;
        }
    }
    
    int imageIndex = 0;
    public void dazeMole3()
    {
        MyWorld gameWorld = (MyWorld) getWorld();
        if(dazeMole3Timer.millisElapsed() < 100)
        {
            return;
        }
        setImage(mole3Animation[imageIndex]);
        imageIndex = (imageIndex + 1) % mole3Animation.length;
        dazeMole3Timer.mark();
        
        if(imageIndex == 8)
        {
            mole3IsAnimating = false;
            setImage(mole3Animation[8]);
            gameWorld.removeObject(this);
            gameWorld.addHiddenMole3();
            gameWorld.aMoleIsAnimating = false;
            gameWorld.diceRollTimer.mark();
        }
    }
}
