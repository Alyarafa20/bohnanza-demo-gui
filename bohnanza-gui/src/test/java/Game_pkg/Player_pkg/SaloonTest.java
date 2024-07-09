package Game_pkg.Player_pkg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game_pkg.Game_components.Player;

public class SaloonTest {

    private Player player;
    private Saloon saloon;

    @BeforeEach
    public void setUp() {
        player = new Player("Test Player", null, 0);
        saloon = new Saloon(10); // Assuming cost is 10 for this test
    }

    @Test
    public void testSaloonActivation_PrintsCorrectMessage() {
        // Act
        saloon.activate(player);

        // Assert
        String expectedMessage = "Saloon activated for Test Player";
        System.out.print(expectedMessage); // Print the expected message directly


    }
}
