package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SaubohneTest {

    @Test
    public void testConstructor_ValidName() {
        Saubohne card = new Saubohne();
        assertEquals("Saubohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        Saubohne card = new Saubohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(3, 1);
        expectedCoinMap.put(5, 2);
        expectedCoinMap.put(7, 3);
        expectedCoinMap.put(8, 4);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         Saubohne card = new Saubohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
     }
}
