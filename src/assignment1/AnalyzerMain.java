package assignment1;

import java.util.Scanner;

public class AnalyzerMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner to get input from user
        Analyzer reader = new Analyzer(); // create object of Analyzer class
        boolean stop = false; // flag to control the input loop

        // display user guidelines
        System.out.println("WELCOME!");
        System.out.println("This program counts lines, characters, and words. ");
        System.out.println("This program also identifies the longest word. ");
        System.out.println("<<< USER GUIDE >>>");
        System.out.println("- Enter text line by line. ");
        System.out.println("- Type 'stop' to end the input.");

        while (!stop) { // loop continues until stop command is given
            String input = scanner.nextLine(); // get line from user
            stop = reader.analyzeInput(input); // check if input signals to stop
        }

        scanner.close();

        //statistics output
        System.out.println("\nSTATISTICS:");
        System.out.println("You have entered " + reader.getLineCounter () + " lines.");
        System.out.println("You have entered " + reader.getCharCounter() + " characters.");
        System.out.println("You have entered " + reader.getWordCounter() + " words.");
        System.out.println("You have entered '" + reader.getLongestWord() + "' as the longest word.");
    }
}

