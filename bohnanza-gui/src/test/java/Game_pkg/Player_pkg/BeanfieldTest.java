package Game_pkg.Player_pkg;

import Game_pkg.Game_components.Cards_pkg.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BeanfieldTest {

    private Beanfield beanfield;
    private Card card1;
    private Card card2;

    @BeforeEach
    public void setUp() {
        beanfield = new Beanfield(3);

        Map<Integer, Integer> coinMap1 = new HashMap<>();
        coinMap1.put(4, 1);  // Assuming a card gives 1 coin for 4 cards
        card1 = new Card("Red Bean", coinMap1);

        Map<Integer, Integer> coinMap2 = new HashMap<>();
        coinMap2.put(4, 2);  // Assuming a card gives 2 coins for 4 cards
        card2 = new Card("Black-eyed bean", coinMap2);
    }

    @Test
    public void testPlantCardInEmptyField() {
        assertTrue(beanfield.plant(card1, 0));
        assertEquals(1, beanfield.getNumCardsInField(0));
    }

    @Test
    public void testPlantDifferentCardInOccupiedField() {
        beanfield.plant(card1, 0);
        assertFalse(beanfield.plant(card2, 0));  // Field occupied by a different card type
        assertEquals(1, beanfield.getNumCardsInField(0));
    }

    @Test
    public void testPlantSameCardInOccupiedField() {
        beanfield.plant(card1, 0);
        assertTrue(beanfield.plant(card1, 0));  // Field occupied by the same card type
        assertEquals(2, beanfield.getNumCardsInField(0));
    }

    @Test
    public void testIsFieldFull() {
        for (int i = 0; i < 10; i++) {
            beanfield.plant(card1, 0);
        }
        assertTrue(beanfield.isFieldFull(0));
    }

    @Test
    public void testHarvestField() {
        for (int i = 0; i < 4; i++) {
            beanfield.plant(card1, 0);
        }
        beanfield.harvest(0);
        assertEquals(0, beanfield.getNumCardsInField(0));
        assertEquals(1, beanfield.getCoins());  // Assuming the harvested field gives 1 coin
    }

    @Test
    public void testGetPotentialHarvestCoins() {
        for (int i = 0; i < 4; i++) {
            beanfield.plant(card1, 0);
        }
        assertEquals(1, beanfield.getPotentialHarvestCoins(0));  // Assuming the field gives 1 coin for 4 cards
    }

    @Test
    public void testDisplayFields() {
        beanfield.plant(card1, 0);
        beanfield.plant(card1, 1);
        beanfield.plant(card2, 2);
        beanfield.displayFields();
    }
}
