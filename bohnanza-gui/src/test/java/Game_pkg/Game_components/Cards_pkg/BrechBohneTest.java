package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BrechBohneTest {

    @Test
    public void testConstructor_ValidName() {
        BrechBohne card = new BrechBohne();
        assertEquals("BrechBohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        BrechBohne card = new BrechBohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(3, 1);
        expectedCoinMap.put(5, 2);
        expectedCoinMap.put(6, 3);
        expectedCoinMap.put(7, 4);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         BrechBohne card = new BrechBohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
     }
}
