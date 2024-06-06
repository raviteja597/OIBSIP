import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 5;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've picked a number between 1 and 100. Try to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + " - Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly.");
                break;
            } else if (userGuess < numberToGuess) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }

            attempts++;

            if (attempts == maxAttempts) {
                System.out.println("Out of attempts. The number was: " + numberToGuess);
                break;
            }
        }

        scanner.close();
    }
}
