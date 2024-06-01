import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        // Initialize the game
        Game game = new Game();
        game.start();
    }
}

class Game {
    private int numberToGuess;
    private int numberOfAttempts;
    private int maxAttempts;
    private int score;
    private Random random;
    private Scanner scanner;

    public Game() {
        random = new Random();
        scanner = new Scanner(System.in);
        maxAttempts = 10; // Maximum attempts allowed
    }

    public void start() {
        boolean playAgain = true;
        while (playAgain) {
            playRound();
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }
        System.out.println("Thank you for playing! Your final score is: " + score);
    }

    private void playRound() {
        numberToGuess = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        numberOfAttempts = 0;
        boolean isCorrect = false;

        System.out.println("I have generated a number between 1 and 100. Can you guess it?");
        
        while (numberOfAttempts < maxAttempts && !isCorrect) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess == numberToGuess) {
                isCorrect = true;
                int points = calculatePoints();
                score += points;
                System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts. You earned " + points + " points. Your current score is: " + score);
            } else if (userGuess < numberToGuess) {
                System.out.println("The number is higher than your guess. Try again.");
            } else {
                System.out.println("The number is lower than your guess. Try again.");
            }
        }

        if (!isCorrect) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
        }
    }

    private int calculatePoints() {
        return (maxAttempts - numberOfAttempts + 1) * 10; // Simple scoring formula
    }
}
