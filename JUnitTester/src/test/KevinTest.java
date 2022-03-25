import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class KevinTest {

    Kevin kevin;

    @BeforeEach
    void setUp() {
        kevin = new Kevin();
    }

    @DisplayName("Test getName")
    @Test
    void getName() {
        assertEquals("Lin", kevin.getName(), "what!!");
    }
    @Test

    void getAge() {
        assertEquals(26, kevin.getAge(), "Kevin is old!");
    }

    @AfterEach
    void tearDown() {
    }
}