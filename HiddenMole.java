import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
 * 
 * @author Ho 
 * @version May 2024
 */
public class HiddenMole extends Animal
{
    GreenfootImage[] mole2Animation = new GreenfootImage[9];
    
    public HiddenMole()
    {
        for(int i = 0; i < mole2Animation.length; i++)
        {
            mole2Animation[i] = new GreenfootImage("images/Mole_Animate/mole_animate" + i + ".png");
            mole2Animation[i].scale(100, 75);
        }
        
        setImage(mole2Animation[8]);
    }
}
