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

    @DisplayName("The main menu")
    @Test
    void mainMenu() {
        assertNotNull(player.getName(),"Get the players name");
    }

    @RepeatedTest(6)
    @DisplayName("Attempts and Guess range")
    @Test
    void anotherAttempt() {
        player.setPlayernumber((int) (Math.random() * 20));
        player.setSecretnumber((int) (Math.random() * 20));
        assertTrue(player.getPlayerNumber() <= 20 && player.getPlayerNumber() >= 1,
                "Player guess must between 1 - 20");
        assertTrue((player.getPlayerNumber() == player.getSecretNumber() &&
                        player.getAttempts() <= 6),
                "numbers matched - you win!");
    }
    @DisplayName("Loop to rerun game")
    @Test
    void playAgain() {
        player.setAttempts(6);
        assertTrue(player.getAttempts() >= 6, "Player has used all 6 attempts");
    }

    @Test
    void groupedAssertions()
    {
        player.setPlayername("Kevin");
        player.setPlayernumber(15);
        player.setAttempts(6);

        assertAll("Test Props",
                ()-> assertNotNull(player.getName(),"Name test failed"),
                ()-> assertTrue(player.getPlayerNumber() <= 20 && player.getPlayerNumber() >= 1,
                        "Player guess range exceeded"),
                ()-> assertTrue(player.getAttempts() <= 6, "Player attempts exceeded"));
    }
}