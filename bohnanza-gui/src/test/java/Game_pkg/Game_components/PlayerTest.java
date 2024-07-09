package Game_pkg.Game_components;

import Game_pkg.Game;
import Game_pkg.Game_components.Cards_pkg.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Player testPlayer;
    private Game mockGame;

    @BeforeEach
    public void setUp() {
        mockGame = new Game(); // Create a mock or dummy Game object as needed

        // Initialize the bean fields map
        int numFields = 3; // Example: 3 bean fields
        Map<Integer, Integer> fieldMap = createFieldMap(numFields);

        // Initialize testPlayer
        testPlayer = new Player("TestPlayer", mockGame, numFields);
    }

    private Map<Integer, Integer> createFieldMap(int numFields) {
        Map<Integer, Integer> fieldMap = new HashMap<>();
        for (int i = 1; i <= numFields; i++) {
            fieldMap.put(i, 0); // Initialize each field with 0 cards
        }
        return fieldMap;
    }

    @Test
    public void testDrawOneCard() {
        Card drawnCard = testPlayer.drawOneCard();
        assertNotNull(drawnCard);
        assertTrue(testPlayer.getHandCards().contains(drawnCard));
    }

    @Test
    public void testDrawMultipleCards() {
        int initialHandSize = testPlayer.getHandCards().size();
        testPlayer.drawMultipleCard(2);
        assertEquals(initialHandSize + 2, testPlayer.getHandCards().size());
    }

}
