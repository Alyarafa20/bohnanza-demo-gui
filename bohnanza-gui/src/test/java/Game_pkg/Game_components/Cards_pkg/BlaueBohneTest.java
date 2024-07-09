package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BlaueBohneTest {

    @Test
    public void testConstructor_ValidName() {
        BlaueBohne card = new BlaueBohne();
        assertEquals("BlaueBohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        BlaueBohne card = new BlaueBohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(4, 1);
        expectedCoinMap.put(6, 2);
        expectedCoinMap.put(8, 3);
        expectedCoinMap.put(10, 4);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         BlaueBohne card = new BlaueBohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
     }
}
