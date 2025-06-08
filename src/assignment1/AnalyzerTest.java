package assignment1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnalyzerTest {

    @Test
    @DisplayName("Test 1 - counting multiple lines")
    void multiLineLines() {
        Analyzer Analyze = new Analyzer();
        Analyze.analyzeInput("the sky is clear");
        Analyze.analyzeInput("morning sun");
        assertEquals(2, Analyze.getLineCounter(), "Should count 2 lines of text");
    }

    @Test
    @DisplayName("Test 2 - total characters from multiple lines")
    void multiLineCharacters() {
        Analyzer Analyze = new Analyzer();
        Analyze.analyzeInput("this is my test");
        Analyze.analyzeInput("i do not know what to write");
        assertEquals(42, Analyze.getCharCounter(), "Total characters should be 42");
    }

    @Test
    @DisplayName("Test 3 - count words in uppercase input")
    void upperCaseWords() {
        Analyzer Analyze = new Analyzer();
        Analyze.analyzeInput("MY NAME IS SAMIN");
        assertEquals(4, Analyze.getWordCounter(), "Should count 4 words");
    }

    @Test
    @DisplayName("Test 4 - longest word")
    void LongestWord() {
        Analyzer Analyze = new Analyzer();
        Analyze.analyzeInput("I live in Sweden");
        assertEquals("Sweden", Analyze.getLongestWord(), "Longest word should be 'Sweden'");
    }


    @Test
    @DisplayName("Test 5 - stop - input 'stop' stops the program")
    void userStops() {
        Analyzer Analyze = new Analyzer();
        assertTrue(Analyze.analyzeInput("stop"), "program should stop when user enters 'stop'");
    }

    @Test
    @DisplayName("Test 6 - stop - normal input does not stop program")
    void normalWords() {
        Analyzer Analyze = new Analyzer();

        assertFalse(Analyze.analyzeInput("here"), "program should work for normal words");
    }

    @Test
    @DisplayName("Test 7 - stop - no lines counted for stop command")
    void countLineForStop() {
        Analyzer Analyze = new Analyzer();
        assertEquals(0, Analyze.getLineCounter(), "no line counted when user enters 'stop'");
    }

}
