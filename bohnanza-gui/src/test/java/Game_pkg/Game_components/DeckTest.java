package Game_pkg.Game_components;

import Game_pkg.Game_components.Cards_pkg.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = Deck.getInstance();
    }

    @Test
    public void testDrawCard() {
        // Test drawing a card
        Card card = deck.drawCard();
        assertNotNull(card);
        assertTrue(deck.getCreatedCards().containsKey(card.getName()));
        assertTrue(deck.getCreatedCards().get(card.getName()) > 0);
    }


    @Test
    public void testDiscard() {
        // Test discarding a card
        Card card = deck.drawCard(); // Draw a card first
        assertNotNull(card);
        deck.discard(card);
        assertEquals(0, deck.getCreatedCards().get(card.getName()));
    }

    @Test
    public void testMaxCardsInitialization() {
        // Test if maxCards map is initialized correctly
        Map<String, Integer> maxCards = deck.getMaxCards();
        assertNotNull(maxCards);
        assertEquals(8, maxCards.get("Rote Bohne"));
        assertEquals(14, maxCards.get("BrechBohne"));
        assertEquals(20, maxCards.get("Blaue Bohne"));
        assertEquals(0, maxCards.getOrDefault("Non-existent Type", 0)); // Ensure default value for non-existent type
    }

}
