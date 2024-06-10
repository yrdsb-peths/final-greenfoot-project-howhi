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
     * Act - do whatever the Mole4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound mole4Clicked = new GreenfootSound("Dazed Mole Sound.mp3");
    
    GreenfootImage[] mole4Animation = new GreenfootImage[9];
    
    SimpleTimer animationMole4Timer = new SimpleTimer();
    
    SimpleTimer dazeMole4Timer = new SimpleTimer();
    
    public int hideMole4Time;
    
    boolean mole4IsAnimating = false;
    public Mole4()
    {
        for(int i = 0; i < mole4Animation.length; i++)
        {
            mole4Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole4Animation[i].scale(100, 75);
        }
        
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
