package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FeuerbohneTest {

    @Test
    public void testConstructor_ValidName() {
        Feuerbohne card = new Feuerbohne();
        assertEquals("Feuerbohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        Feuerbohne card = new Feuerbohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(3, 1);
        expectedCoinMap.put(6, 2);
        expectedCoinMap.put(8, 3);
        expectedCoinMap.put(9, 4);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         Feuerbohne card = new Feuerbohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
     }
}
