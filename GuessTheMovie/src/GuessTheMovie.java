import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class GuessTheMovie {
    //Declare my variables
    private String[] movieList;  //Entire movie list
    private String randomMovie; //Name of the randomMovie selected
    private char[] charactersInRandomMovie; //Array of characters in the randomMovie
    private char guess; //Character from the current guess
    private int guessCount; //Total running guess count
    private Set<Character> guesses;
    private Set<Character> uniqueRandomMovie;


    public GuessTheMovie() {
        //Constructor
        //Initialize declared variables
        this.guessCount = 0;
        this.guesses = new HashSet<Character>();
        this.uniqueRandomMovie = new HashSet<>();

        //Scan movie.txt file
        File file = new File("movies.txt");
        try {
            Scanner scanner = new Scanner(file);

            // Count the lines in the file.
            int linesInFile = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                linesInFile = linesInFile + 1;
            }

            // Initialize our movie list as a String array based on the number of lines in the file.
            this.movieList = new String[linesInFile];

            // Create a new file-reading scanner.
            Scanner newScanner = new Scanner(file);

            // Load the lines of the file into our String array.
            int movieIndex = 0;
            while (newScanner.hasNextLine()) {
                this.movieList[movieIndex] = newScanner.nextLine();
                movieIndex = movieIndex + 1;
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found" + exception);
        }

        // Randomly assign a movie from the list
        int randomNumber = (int) (this.movieList.length * Math.random());
        this.randomMovie = this.movieList[randomNumber];


        this.charactersInRandomMovie = this.randomMovie.toCharArray();

        for (int i = 0; i < this.charactersInRandomMovie.length; i++) {
            this.uniqueRandomMovie.add(this.charactersInRandomMovie[i]);
        }
    }

    //Win Condition
    public boolean isGameOver() {
        if (hasLost()) {
            return true;
        }
        if (hasWon()) {
            return true;
        }
        return false;
    }

    //Check if game has ended
    public boolean hasLost() {
        if (this.wrongGuesses() == 10) {
            return true;
        }
        return false;
    }

    //Check if the game has been won
    public boolean hasWon() {
        if (this.rightGuesses() == this.uniqueRandomMovie.size()) {
            return true;
        }
        return false;
    }

    //Accept new guess from user
    public String userGuess() {
        Scanner scanner = new Scanner(System.in);
        this.guess = scanner.nextLine().charAt(0);
        this.guessCount = this.guessCount + 1;
        this.guesses.add(this.guess);
        return Character.toString(this.guess);
    }

    public String currentGuess() {
        String answer = "";
        for (int i = 0; i < charactersInRandomMovie.length; i++) {
            char currentCharacter = charactersInRandomMovie[i];
            if (guesses.contains(currentCharacter)) {
                answer = answer + currentCharacter;
            } else {
                answer = answer + "_";
            }
        }
        return answer;
    }

    //Check if guess is correct
    public boolean isGuessCorrect(String userGuess) {
        return this.randomMovie.contains(userGuess);
    }

    public int wrongGuesses() {
        int wrongGuesses = 0;
        for (Character guess : guesses) {
            if (!uniqueRandomMovie.contains(guess)) {
                wrongGuesses = wrongGuesses + 1;
            }
        }
        return wrongGuesses;
    }

    public int rightGuesses() {
        int rightGuesses = 0;
        for (Character guess : guesses) {
            if (uniqueRandomMovie.contains(guess)) {
                rightGuesses = rightGuesses + 1;
            }
        }
        return rightGuesses;
    }

    public void turn() {
        System.out.print("Guess a letter: ");
        this.userGuess();
        System.out.println("You are guessing: " + guess);
    }

    public void play() {
        System.out.println("Can you guess the movie?");
        while (!isGameOver()) {
            turn();
            System.out.println("You are guessing " + currentGuess());
            System.out.println("You have guessed " + wrongGuesses() + " wrong letters.");
        }
        if (hasLost()) {
            System.out.println("You're a fucking loser.");
        }
        if (hasWon()) {
            System.out.println("YOU ROCK! :D ");
        }
    }
}
