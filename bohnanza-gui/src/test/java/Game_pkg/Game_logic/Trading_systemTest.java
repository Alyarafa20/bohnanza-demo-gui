package Game_pkg.Game_logic;

import Game_pkg.Game_components.Cards_pkg.Card;
import Game_pkg.Game_components.Player;
import Game_pkg.Game_components.Cardfactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Trading_systemTest {
    private Trading_system tradingSystem;
    private Player player1;
    private Player player2;
    private Card card1;
    private Card card2;

    @BeforeEach
    void setUp() {
        tradingSystem = Trading_system.getInstance();

        // Create players with a mock or real game instance
        // Replace null with actual Game instance or mock if necessary
        player1 = new Player("Player 1", null, 2);
        player2 = new Player("Player 2", null, 2);

        // Ensure players are properly initialized
        assertNotNull(player1);
        assertNotNull(player2);

        // Give each player some initial cards for testing
        card1 = Cardfactory.createCard("Gartenbohne"); // Example card types, adjust as needed
        card2 = Cardfactory.createCard("Rote Bohne");

        player1.getHandCards().add(card1);
        player2.getHandCards().add(card2);
    }

    @Test
    void testStartTrading_successfulTrade() {
        // Simulate trading scenario where both players agree to trade their first card
        tradingSystem.startTrading(player1, List.of(player2));

        // Verify that the trade was successful
        assertEquals(0, player1.getHandCards().size(), "Active player should have 0 cards after trade");
        assertEquals(1, player2.getHandCards().size(), "Trading player should have 1 card after trade");
    }

    @Test
    void testStartTrading_invalidTrade() {
        // Simulate a scenario where trading is attempted but fails due to invalid card selection
        // For example, player1 does not have a card to trade
        player1.getHandCards().clear();

        tradingSystem.startTrading(player1, List.of(player2));

        // Verify that the trade was not executed
        assertEquals(0, player1.getHandCards().size(), "Active player should still have 0 cards");
        assertEquals(1, player2.getHandCards().size(), "Trading player should still have 1 card");
    }

    @Test
    void testStartTrading_multiplePlayers() {
        // Simulate trading scenario with multiple players involved
        Player player3 = new Player("Player 3", null, 2);
        Card card3 = Cardfactory.createCard("Augenbohne"); // Example card types, adjust as needed
        player3.getHandCards().add(card3);

        tradingSystem.startTrading(player1, List.of(player2, player3));

        // Verify that the trade was successful between player1 and player2
        assertEquals(0, player1.getHandCards().size(), "Active player should have 0 cards after trade");
        assertEquals(1, player2.getHandCards().size(), "Trading player should have 1 card after trade");

        // Verify that player3 was not involved in the trade
        assertEquals(1, player3.getHandCards().size(), "Player 3 should still have 1 card");
    }
}
