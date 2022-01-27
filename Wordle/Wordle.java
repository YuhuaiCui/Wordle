/* Daniel Cui
 * Bonus Assignment
 */ 

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Wordle {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Puzzle puzzle = new Puzzle();
        
        while ((!puzzle.getSolved()) && puzzle.getNumTries() < 6) {
            puzzle.show();
            System.out.print("\nMake a guess: ");
            String guess = scanner.nextLine();
            if (guess.length() == 5) {
                puzzle.makeGuess(guess.toLowerCase());
            }
            clearScreen();
        }

        if (puzzle.getSolved()) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose! The word was " + puzzle.getMyWord());
        }
    }
    
    public static void clearScreen() {
        System.out.println("\f");
    }
}
