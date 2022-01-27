import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Puzzle {
    String[] guesses = new String[]{"", "", "", "", "", "", ""};
    String myWord;
    ArrayList<String> words;
    boolean solved;
    int numTries;
    
    public Puzzle() {
        words = new ArrayList<String>(3300);
        loadWords("words.txt");
        int r = (int) (Math.random()*words.size());
        myWord = words.get(r);
        //myWord = "hello";
        myWord.toLowerCase();
        solved = false;
        numTries = 0;
    }
    
    public void loadWords(String filename) {
        File wordfile = new File(filename);
        try {
            Scanner fileScanner = new Scanner(wordfile);
            while(fileScanner.hasNext()) {
                String w = fileScanner.nextLine();
                if (w.length() == 5 && !Character.isUpperCase(w.charAt(0))) {
                    words.add(w);
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println(e);
        }
    }
    
    public void show() {
        System.out.println("1: " + guesses[0]);
        System.out.println();
        System.out.println("2: " + guesses[1]);
        System.out.println();
        System.out.println("3: " + guesses[2]);
        System.out.println();
        System.out.println("4: " + guesses[3]);
        System.out.println();
        System.out.println("5: " + guesses[4]);
        System.out.println();
        System.out.println("6: " + guesses[5]);
    }

    
    public String getMyWord() {
        return myWord;
    }
    
    public int getNumTries() {
        return numTries;
    }
    
    public boolean isUnsolved() {
        for (String g : guesses) {
            if (g.toLowerCase().equals(getMyWord().toLowerCase())) return false;
        }
        return true;
    }
    
    public boolean getSolved() {
        return solved;    
    }
    
    public void makeGuess(String g) {
        if (g.equals(getMyWord())) solved = true;
        else {
           int n = 0;
           for (int i = 0; i < g.length(); i++) {
               if (g.substring(i, i + 1).equals(myWord.substring(i, i + 1))) {
                   guesses[numTries] += g.substring(i, i + 1) + "**";
               }
               else if (myWord.contains(g.substring(i, i + 1))) {
                   guesses[numTries] += g.substring(i, i + 1) + "*";
               }
               else {
                   guesses[numTries] += g.substring(i, i + 1);
               }
           }
           numTries++; 
        }
    }
}