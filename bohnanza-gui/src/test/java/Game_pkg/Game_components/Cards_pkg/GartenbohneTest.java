package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GartenbohneTest {

    @Test
    public void testConstructor_ValidName() {
        Gartenbohne card = new Gartenbohne();
        assertEquals("Gartenbohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        Gartenbohne card = new Gartenbohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(2, 2);
        expectedCoinMap.put(3, 3);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         Gartenbohne card = new Gartenbohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
     }
}
