import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;

        System.out.println("I have randomly chosen a number between 1 and 100.");
        System.out.println("Try to guess it.");

        for (int i = 10; i > 0; i--) {
            System.out.println("You have " + i + " guesses left. Choose again: ");
            Scanner scanner = new Scanner(System.in);
            int guess = scanner.nextInt();
            Scanner scan =  new Scanner(System.in);

            if (randomNumber < guess) {
                System.out.println("It's smaller than " + guess + ".");
            }
            else if (randomNumber > guess) {
                System.out.println("It's greater than " + guess + ".");
            }
            else {
                hasWon = true;
                break;
            }
        }
        if (hasWon) {
            System.out.println("Correct! You win!");
        } else {
            System.out.println("GAME OVER. YOU LOSE!");
            System.out.println("The number was: " + randomNumber);
        }
    }
}
