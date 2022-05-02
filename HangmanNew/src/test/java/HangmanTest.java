import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HangmanTest {

    Hangman test;
    @BeforeEach
    void setUp() {
        test = new Hangman("cat");
    }

    @DisplayName("Option to play again if maximum attempt exceeded")
    @Test
    void mainMenuMaxAttemptPlayAgain() {

    }

    @DisplayName("Option to play again if player word matches computer word")
    @Test
    void mainMenuEqualWordsPlayAgain(){


    }

    @DisplayName("Loop to rerun game")
    @Test
    void playAgain() {
    }

    @DisplayName("returns array of user input - mismatch")
    @Test
    void returnMissedLetters() {


    }

    @DisplayName("returns Hangman image based on failed attempts")
    @Test
    void returnFigureCount() {


    }
}