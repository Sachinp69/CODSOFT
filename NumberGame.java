package CODSOFT;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 5;
        int score = 0;
        String playAgain;

        do {
            int attempts = 0;
            int numberToGuess = random.nextInt(100) + 1;
            System.out.println("I have randomly chosen a number between 1 and 100.");
            System.out.println("Can you guess it within " + maxAttempts + " attempts?");

            boolean hasGuessedCorrectly = false;
            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                scanner.nextLine();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Remember, the number is between 1 and 100.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("It's lower than " + userGuess + ".");
                } else if (userGuess < numberToGuess) {
                    System.out.println("It's higher than " + userGuess + ".");
                } else {
                    System.out.println("Congratulations! You've guessed it in " + attempts + " attempts!");
                    score++;
                    hasGuessedCorrectly = true;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've used all your attempts. The number was " + numberToGuess);
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
