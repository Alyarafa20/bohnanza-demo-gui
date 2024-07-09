package Game_pkg.Game_components;

import Game_pkg.Game_components.Cards_pkg.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardfactoryTest {

    @BeforeEach
    public void setUp() {
        // Reset production status before each test
        Cardfactory.startProducingCardType("Gartenbohne");
        Cardfactory.startProducingCardType("Rote Bohne");
        Cardfactory.startProducingCardType("Augenbohne");
    }

    @Test
    public void testCreateCard_validCardType() {
        Card card = Cardfactory.createCard("Gartenbohne");
        assertNotNull(card);
        assertInstanceOf(Gartenbohne.class, card);
    }

    @Test
    public void testCreateCard_invalidCardType() {
        Card card = Cardfactory.createCard("InvalidType");
        assertNull(card);
    }



    @Test
    public void testStopProducingCardType() {
        assertTrue(Cardfactory.isProducingCardType("Rote Bohne"));

        Cardfactory.stopProducingCardType("Rote Bohne");
        assertFalse(Cardfactory.isProducingCardType("Rote Bohne"));
    }
}
