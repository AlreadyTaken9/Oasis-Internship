import java.util.Scanner;
import java.lang.Math;

public class GuessingGame {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int score = 0;
    boolean playAgain = true;

    while (playAgain) {
      int answer = (int)(Math.random() * 100) + 1;
      int k = 5;
      boolean correct = false;

      System.out.println("I'm thinking of a number between 1 and 100.\nYou have 5 tries to guess the number.");
      
      while (k > 0) {
        System.out.println("Enter your guess: ");
        int guess = input.nextInt();
        
        if (guess == answer) {
          System.out.println("You guessed the number!\nYou win this round!");
          score++;
          break;
        } else if (guess > answer) {
          System.out.println("Your guess is too high.\nYou have " + (k - 1) + " tries left.");
          k--;
        } else {
          System.out.println("Your guess is too low.\nYou have " + (k - 1) + " tries left.");
        }
        k--;
      }

      if (k == 0 && !correct) {
        System.out.println("You ran out of tries.\nYou lose this round. The number was " + answer);
      }

      System.out.println("Your score: " + score);
      System.out.print("Do you want to play again? (yes/no): ");
      String playAgainResponse = input.next().toLowerCase();
      if (!playAgainResponse.equals("yes")) {
        playAgain = false;
      }
    }
    
    System.out.println("Thanks for playing! Your final score is: " + score);
    input.close();
  }
}
