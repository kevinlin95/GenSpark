import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("Main Menu Exceptions")
    @Test
    void mainMenuThrowsIllegalStateException(){
        assertThrows(IllegalStateException.class,
                () -> player.getName());
    }

    @DisplayName("Loop to rerun game")
    @Test()
    void anotherAttempt(){
        player.setAttempts(7);

    }

    @DisplayName("Player number is in the range of 1 - 20")
    @RepeatedTest(6)
    void playerNumbersIsBetweenOneAndTwenty() {
        player.setPlayernumber((int) (Math.random() * 20));
        assertTrue(player.getPlayerNumber() <= 20 && player.getPlayerNumber() >= 1,
                "Player guess must between 1 - 20");
    }

    @DisplayName("Equal Numbers?")
    @Test
    void areTheNumbersEqual(){
        player.setPlayernumber(4);
        player.setSecretnumber(4);
        assertTrue((player.getPlayerNumber() == player.getSecretNumber() &&
                        player.getAttempts() <= 6),
                "numbers matched - you win!");
    }

    @Test
    void groupedAssertions()
    {
        player.setPlayername("Kevin");
        player.setPlayernumber(15);
        player.setSecretnumber(15);
        player.setAttempts(6);

        assertAll("Test Props",
                ()-> assertNotNull(player.getName(),"Name test failed"),
                ()-> assertTrue(player.getPlayerNumber() <= 20 && player.getPlayerNumber() >= 1,
                        "Player guess range exceeded"),
                ()-> assertEquals(player.getPlayerNumber(), player.getSecretNumber()),
                ()-> assertTrue(player.getAttempts() <= 6, "Player attempts exceeded"));
    }
}