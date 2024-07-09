package Game_pkg.Player_pkg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game_pkg.Game_components.Player;

public class BuildingTest {

    private String buildingName;
    private int buildingCost;
    private String buildingBeanType;
    private Building building;

    @BeforeEach
    public void setUp() {
        buildingName = "Test Building";
        buildingCost = 10;
        buildingBeanType = "Cocoa";
        building = new Building(buildingName, buildingCost, buildingBeanType) { // Anonymous inner class for testing
            @Override
            public void activate(Player player) {
                // Implement specific activation logic for testing purposes (optional)
            }
        };
    }

    @Test
    public void testGetName_ReturnsCorrectValue() {
        assertEquals(buildingName, building.getName());
    }

    @Test
    public void testGetCost_ReturnsCorrectValue() {
        assertEquals(buildingCost, building.getCost());
    }

    @Test
    public void testGetBeanType_ReturnsCorrectValue() {
        assertEquals(buildingBeanType, building.getBeanType());
    }

}
