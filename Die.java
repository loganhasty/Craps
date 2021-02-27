/**
 * This class simulates a Die
 * 
 * @author Logan Hasty
 * @version 1.0
 * 
 * 
 */
package craps;
import java.util.Random;
/**
 *
 * @author Logan
 */
public class Die 
{
    private int dieRoll;

    public Die()
    {
        dieRoll = 0;
    }
    
    /**
     * The rollDie method rolls the six-sided die
     */
    public int roll()
    {
        Random rand = new Random();
        dieRoll = rand.nextInt(6 - 1 + 1) + 1; 
        return dieRoll;
    }
    
    
}
