package assignment1;

public class Analyzer {
    //variables to keep track of data
    private int lineCounter = 0;
    private int charCounter = 0;
    private int wordCounter = 0;
    private String longestWord = "";
    private final String[] storedLines = new String[1000]; //store lines with an array

    public boolean analyzeInput(String input) {
        if (input.equalsIgnoreCase("stop")) {
            return true;
        }

        if (lineCounter < storedLines.length) { // make sure we don't surpass array size
            lineCounter++; // increment line count
            charCounter += input.length(); // update character count

            String[] words = input.split("\\s+"); // split input into words by spaces
            wordCounter += words.length; // update total word count

            // to find the longest word
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }
        return false; // keep the program running
    }

    // get the analysis
    public int getLineCounter() {
        return lineCounter;
    }

    public int getCharCounter() {
        return charCounter;
    }

    public int getWordCounter() {
        return wordCounter;
    }

    public String getLongestWord() {
        return longestWord;
    }
}