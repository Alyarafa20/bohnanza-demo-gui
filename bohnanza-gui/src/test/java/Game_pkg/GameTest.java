package Game_pkg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = Game.getInstance(); // Assuming the logic is fixed
        game.get_Players(null).clear(); // Clear any existing players before each test (if using singleton)
    }

    @Test
    public void testInitializePlayers_TwoPlayers() {
        game.initializePlayers(2);

        assertEquals(2, game.get_Players(null).size());
        for (int i = 0; i < game.get_Players(null).size(); i++) {
            assertEquals("Player " + (i + 1), game.get_Players(null).get(i).getName());
        }
    }

    @Test
    public void testInitializePlayers_FivePlayers() {
        game.initializePlayers(5);

        assertEquals(5, game.get_Players(null).size());
        for (int i = 0; i < game.get_Players(null).size(); i++) {
            assertEquals("Player " + (i + 1), game.get_Players(null).get(i).getName());
        }
    }



    @Test
    public void testSetHighBohnExtension_SetsExtension() {
        game.setHighBohnExtension(true);

        assertTrue(game.extension);
    }

}
