import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mole that is hiding in its burrow.
 * 
 * @author Ho 
 * @version May 2024
 */
public class HiddenMole extends Animal
{
    GreenfootImage hiddenMoleImage = new GreenfootImage("images/mole_Hidden.png");
    
    public HiddenMole()
    {
        hiddenMoleImage.scale(100, 75);

        setImage(hiddenMoleImage);
    }
}
