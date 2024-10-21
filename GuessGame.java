import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame
{
    public static void main(String args[]) 
   { 
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int Guess = random.nextInt(100) + 1; 
        int Tries = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (!hasGuessedCorrectly)
      {
            System.out.print("Enter your guess: ");
            int playerGuess = scanner.nextInt();
            Tries++;

            if (playerGuess < Guess)
            {
                System.out.println("Too low! Try again.");
            } 
          else if (playerGuess > Guess) 
          {
               System.out.println("Too high! Try again.");
           } 
         else
          {
              hasGuessedCorrectly = true;
              System.out.println("Congratulations! You've guessed the number in " + Tries + " tries.");
            }
       }

        scanner.close();
    }
}