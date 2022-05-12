import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class HangmanNewTest {
    HangmanNew test;
    Scanner scanner;
    HangmanNew tester = mock(HangmanNew.class);

    @DisplayName("Checking if player 1 string is stored/working")
    @Test
    public void playerOne() {
        test.setPlayerOneName("John");
        verify(test).setPlayerOneName("John");
        assertNotNull(test.getPlayerOneName());
    }

    @RepeatedTest(value = 5, name = "Random Letter")
    void makeSureWordIsRandom() throws FileNotFoundException {
        //when(HangmanNew.playerOne(test, scanner)).thenReturn();
    }


    @Test
    void playAgainYesNo() {
        //when(playAgainYesNo()).thenReturn();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "e", "i", "o", "u"})
    void getPlayerGuess(String randomCharacters) {
        when(HangmanNew.getPlayerGuess(scanner, randomCharacters, playerGuesses())).thenReturn(true);
    }

    @DisplayName("Needed to test for playerGuesses")
    private static List<Character> playerGuesses(){
        return Arrays.asList('a', 'b', 'c', 'd');
    }

}