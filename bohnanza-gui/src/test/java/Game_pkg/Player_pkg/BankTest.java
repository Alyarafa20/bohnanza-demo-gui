package Game_pkg.Player_pkg;

import Game_pkg.Game_components.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    private Bank bank;
    private Player player;

    @BeforeEach
    public void setUp() {
        bank = new Bank(100);
        player = new Player("TestPlayer");  // Using the default constructor for testing
    }

    @Test
    public void testBankInitialization() {
        assertEquals("Bank", bank.getName());
        assertEquals(100, bank.getCost());
        assertEquals("Black-eyed bean", bank.getBeanType());
    }

    @Test
    public void testActivate() {
        bank.activate(player);
        // Here you can add assertions related to the Bank's activation logic
        // For example, if the Bank activation affects the player's attributes, check those
        System.out.println("Bank activated for " + player.getName());
    }
}
