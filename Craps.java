/**
*
* @author  Logan Hasty
* @version 1.0
* @since   2021-02-18 // date last updated
* ITSC1213_156 
* Craps
* 
* The Craps program implements an application that simulates a craps game.
* Craps is a dice game that revolves around rolling two six-sided dice in an 
* attempt to roll a particular number. Wins and losses are determined by rolling 
* the dice.
*
*
*/
package craps;
/**
 *
 * @author Logan Hasty
 */

public class Craps 
{
    int wins = 0;
    int losses = 0;
    
    /**
     * @author Logan Hasty
     * @param round     This method accepts an integer to tell it which round
     *                  the game is currently on
     */
    public void playCraps(int round){
        int rollNum = 1;
        //Create objects for game
        Die d1 = new Die();
        Die d2 = new Die();
        
        //Roll dice for first roll
        
            int roll1 = d1.roll();
            int roll2 = d2.roll();
            int rollTotal = roll1 + roll2;

            //Find out if they won
            if (rollTotal == 7 || rollTotal == 11)
            {   
                if (round <= 10)
                {
                    System.out.println("Round " + round + ", Roll " + rollNum + 
                           " -- Die 1: " + roll1 + ", Die 2: " + roll2 + 
                        " -- Total: " + rollTotal);
                    System.out.println("WIN!");
                }
                round += 1;
                wins += 1;
                if (round <= 10)
                {
                    System.out.println(wins + " win(s), " + losses + " loss(es)\n");
                }

            }        
            //Find out if they lost
            else if (rollTotal == 2 || rollTotal == 3 || rollTotal == 12)
            {
                if (round <= 10)
                {
                    System.out.println("Round " + round + ", Roll " + rollNum + 
                           " -- Die 1: " + roll1 + ", Die 2: " + roll2 + 
                        " -- Total: " + rollTotal);
                    System.out.println("LOSS!");
                }
                round += 1;
                losses += 1;
                if (round <= 10)
                {
                    System.out.println(wins + " win(s), " + losses + " loss(es)\n");
                }
                
            }        
            //If they didn't win or lose, keep rolling
            else
            {
                int point = rollTotal;
                boolean keepPlaying = true;

                while (keepPlaying)
                {
                    if (round <= 10)
                    {
                        System.out.println("Round " + round + ", Roll " + rollNum + 
                           " -- Die 1: " + roll1 + ", Die 2: " + roll2 + 
                        " -- Total: " + rollTotal);
                        if (rollNum == 1)
                        {
                            System.out.println("Point is " + point);
                        }
                    }
                    
                    roll1 = d1.roll();
                    roll2 = d2.roll();
                    rollTotal = roll1 + roll2;
                    rollNum += 1;


                    //Did they win?
                    if (rollTotal == point)
                    {
                        if (round <= 10)
                        {
                            System.out.println("Round " + round + ", Roll " + rollNum + 
                           " -- Die 1: " + roll1 + ", Die 2: " + roll2 + 
                        " -- Total: " + rollTotal);
                            System.out.println("WIN!");
                        }
                        wins += 1;
                        if (round <= 10)
                        {
                           System.out.println(wins + " win(s), " + losses + " loss(es)\n");
                        }
                        keepPlaying = false;
                    }         
                    //Did they lose?
                    else if (rollTotal == 7)
                    {
                        if (round <= 10)
                        {
                            System.out.println("Round " + round + ", Roll " + rollNum + 
                           " -- Die 1: " + roll1 + ", Die 2: " + roll2 + 
                        " -- Total: " + rollTotal);
                            System.out.println("LOSS!");
                        }
                        losses += 1;
                        if (round <= 10)
                        {
                            System.out.println(wins + " win(s), " + losses + " loss(es)\n");
                        }
                        keepPlaying = false;
                    }
                }


            }
    }
    /**
     * @author Logan Hasty
     */
    public void getFinalResults() {
        System.out.println("OVERALL: ");
        System.out.println(wins + " win(s), " + losses + " loss(es)");
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Print welcome message
        System.out.println("Let's play Craps!\n");
        
        //intitalize the current round
        int round = 0;
        
        //instantiate new Craps object
        Craps playGame = new Craps();
        
        //Loop 100,000 times to run through 100,000 rounds
        for (int i = 0; i < 100000; i++)
        {
            playGame.playCraps(round += 1);
        }
        
        //Call getFinalResults to publish the overall wins/losses
        playGame.getFinalResults();
    }
    
}