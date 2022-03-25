import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    Player player;
    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("The main menu")
    @Test
    void mainMenu() {
        assertEquals("Kevin", player.getName(), "Get the players name");
    }

    @DisplayName("Attempts")
    @Test
    void anotherAttempt() {
        assertEquals(player.getAttempts(), 6<= player.getAttempts(), "Attempts must be 6 or less");
    }

    @DisplayName("Loop to rerun game")
    @Test
    void playAgain() {

    }

    @AfterEach
    void tearDown() {
    }
}