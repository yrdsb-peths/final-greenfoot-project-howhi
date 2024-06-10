import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the moles to hit/click on.
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
