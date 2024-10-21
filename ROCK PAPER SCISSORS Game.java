//ROCK PAPER SCISSORS GAME
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors 
{
    public static void main(String args[]) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String options[] = {"Rock", "Paper", "Scissors"};
        
        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Enter your choice (Rock, Paper, Scissors). Type 'exit' to quit.");

        while (true) 
          {
            System.out.print("Your choice: ");
            String Choice = scanner.nextLine().trim();

            if (Choice.equalsIgnoreCase("exit")) 
         {
                System.out.println("Thank you for playing!");
                break;
          }

            if (!isValidChoice(Choice, options)) 
         {
                System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                continue;
          }

            String computerChoice = options[random.nextInt(options.length)];
            System.out.println("Computer chose: " + computerChoice);

            String result = determineWinner(Choice, computerChoice);
            System.out.println(result);
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice, String[] options) {
        for (String option : options) {
            if (option.equalsIgnoreCase(choice)) {
                return true;
            }
        }
        return false;
    }

    private static String determineWinner(String player, String computer) {
        if (player.equalsIgnoreCase(computer)) {
            return "It's a tie!";
        }
        
        switch (player.toLowerCase()) {
            case "rock":
                return (computer.equalsIgnoreCase("Scissors")) ? "You win!" : "You lose!";
            case "paper":
                return (computer.equalsIgnoreCase("Rock")) ? "You win!" : "You lose!";
            case "scissors":
                return (computer.equalsIgnoreCase("Paper")) ? "You win!" : "You lose!";
            default:
                return "Unexpected error!";
        }
    }
}
