import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A mole that is hiding in its burrow.
 * 
 * @author Ho 
 * @version May 2024
 */
public class HiddenMole extends Animal
{
    // Created a new GreenfootImage.
    GreenfootImage hiddenMoleImage = new GreenfootImage("images/mole_Hidden.png");
    
    /**
     * The constructor for HiddenMole. Here, the image above is scaled to an 
     * appropriate size and then this actor's image is set to that scaled image.
     */
    public HiddenMole()
    {
        hiddenMoleImage.scale(100, 75);

        setImage(hiddenMoleImage);
    }
}
