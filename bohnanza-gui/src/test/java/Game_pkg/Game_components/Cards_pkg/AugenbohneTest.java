package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AugenbohneTest {

    @Test
    public void testConstructor_ValidName() {
        Augenbohne card = new Augenbohne();
        assertEquals("Augenbohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        Augenbohne card = new Augenbohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(2, 1);
        expectedCoinMap.put(4, 2);
        expectedCoinMap.put(6, 3);
        expectedCoinMap.put(7, 4);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         Augenbohne card = new Augenbohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
    }
}