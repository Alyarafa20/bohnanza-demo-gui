package Game_pkg.Game_components.Cards_pkg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RoteBohneTest {

    @Test
    public void testConstructor_ValidName() {
        RoteBohne card = new RoteBohne();
        assertEquals("RoteBohne", card.getName());
    }

    @Test
    public void testConstructor_CoinMap() {
        RoteBohne card = new RoteBohne();
        Map<Integer, Integer> expectedCoinMap = new HashMap<>();
        expectedCoinMap.put(2, 1);
        expectedCoinMap.put(3, 2);
        expectedCoinMap.put(4, 3);
        expectedCoinMap.put(5, 4);

        assertEquals(expectedCoinMap, card.getCoinMap());
    }

     @Test
     public void testGetImage_ValidPath() {
         RoteBohne card = new RoteBohne();
         assertNotNull(card.getImage()); // Check if the image is loaded successfully
     }

}
