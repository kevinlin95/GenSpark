import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    Hangman test;
    @BeforeEach
    void setUp() {
        test = new Hangman("cat");
    }

    @RepeatedTest(4)
    @DisplayName("User Input - Add Letters")
    void addALetter(){
        doThrow(IllegalArgumentException.class).when(test).setComputerword(null);
    }

    @DisplayName("Option to play again if maximum attempt exceeded")
    @Test
    void mainMenuMaxAttemptPlayAgain() {

    }

    @DisplayName("Option to play again if player word matches computer word")
    @Test
    void mainMenuEqualWordsPlayAgain(){

        assertTrue(Objects.equals(test.getPlayerinput().toString(), test.getComputerword().toString()));
    }

    @DisplayName("Loop to rerun game")
    @Test
    void playAgain() {
        test.setPlayerattemptfailed(4);
        assertTrue(test.getPlayerattemptfailed() >= 4, "Player has used all 4 attempts");
    }

    @DisplayName("returns array of user input - mismatch")
    @Test
    void returnMissedLetters() {

        assertNotSame(test.getMissedletters(), test.getComputerword(), "In case missed letters = computerword");
        assertNotNull(test.getMissedletters(), "There is something to return");

    }

    @DisplayName("returns Hangman image based on failed attempts")
    @Test
    void returnFigureCount() {
        assertTrue(test.getPlayerattemptfailed() <= 4, "There is only 4 attempts");

    }
}