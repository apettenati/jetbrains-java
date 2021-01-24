import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Create new instance (object) of guess the game
        GuessTheMovie game = new GuessTheMovie();

        game.play();

    }
}
